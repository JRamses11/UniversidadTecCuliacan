USE Northwind
--TRIGGERS 
--ES UN OBJETO QUE ASOCIA CON TABLAS Y SE ALMACENA EN LA BASE DE DATOS
--SU NOMBRE SE DERIVA POR EL COMPORTAMIENTO QUE PRESENTA SU COMPORTAMIENTO YA QUE SE EJECUTA
--CUANDO SUCEDE ALGUN EVENTO. LOS EVENTOS QUE HACEN QUE SE EJECUTEN UN TRIGGER SON LAS 
--OPERACIONES DE INSERCION (INSERT), BORRADO (DELETE) O ACTUALIZACION (UPDATE), YA QUE
--MODIFICIAN LOS DATOS DE LA TABLA
--PROCEDIMIENTOS ALMACENADOS ESPECIALES
--se puede realizar:
--DECLARAR VARIABLE
--USAR CURSORES
--MODIFICAR DATOS DE OTRAS TABLAS
--DESHACER LA TRANSACCION EXPLICITA CON ROLLBACK TRAN

--CREACION DE TRIGGERS
create trigger nombre_trigger
on nombre_tabla
[with encryption]
for {[delete][,][insert][,][update]}
as
sentencia_SQL

--MODIFICACION 
alter trigger nombre_trigger
on nombre_tabla
for {[delete][,][insert][,][update]}
as
sentencia_SQL

--ELIMINACION
drop trigger nombre_trigger

--EJEMPLO :
--CREA UN TIGGER DE INSERCION EN LA TABLA MATERIALES
create table materiales
(clave int primary key, nombre char(50), precio numeric(12,2))
go
create trigger TR_materiales_ins
on materiales for insert as
select 'se ejecuto el trigger al insertar'
select*from inserted
go
--EJECUCION
insert materiales values (1,'lapiz',9)
insert materiales values (2,'bote',9)

--INSERCION MASIVA
insert materiales
select productid, productname, unitprice from products
where productid>2

select*from materiales

--EJEMPLO CREAR UN TRIGGER DE ELIMINACION EN LA TABLA MATERIALES
go
create trigger tr_materiales_del
on materiales for delete as
   select 'se ejecuto el trigger eliminar'
   select*from deleted
go
--EJECUCION
delete materiales where clave=55
delete materiales where clave=66
delete materiales where clave between 70 and 75

--EJEMPLO CREA UN TRIGGER PARA LA ACTUALIZACION DE LA TABLA
go
create trigger tr_materiales_upd
on materiales for update as
select 'Se ejecuto el trigger al actualizar'
select*from inserted  --CONTIENE EL NUEVO VALOR
select*from deleted   --CONTIENE EL VIEJO VALOR
go
--EJECUCION
update materiales set nombre= 'Pala', precio=32 where clave=287

--ELIMINACION
drop trigger tr_materiales_upd
drop trigger tr_materiales_ins
drop trigger tr_materiales_del

--VALIDAR QUE EL PRECIO DEL MATERIAL NO SE ACTUALICE CON UN PRECIO MENOR AL QUE YA TENIA
create trigger tr_materiales_precio
on materiales for update as
declare @precioanterior numeric (12,2), @precionuevo numeric(12,2)

   select @precionuevo= precio from inserted
   select @precioanterior= precio from deleted

   if @precionuevo<@precioanterior
      begin
	  RollBack Tran
	  raiserror ('No se puede actualizar con un precio menor',16, 1)
	  end
go

update materiales set precio=19 where clave=28

select*from materiales where clave=28

--SENTENCIA IF UPDATE
--SINTAXIS VALIDA QUE NO SE MODIFIQUE UN CAMPO DENTRO DE UN TRIGGER
if update (nombre_columna) and | or update (nombre_columna)
begin 
    sentencia_select
end
   else
   begin
        sentencia_select
   end

--VALIDAR QUE EL NOMBRE DE LOS MATERIALES NO SE ACTUALICE
go
create trigger tr_materiales_ins3
on materiales for update as

if update(nombre)
begin 
     Rollback tran
	 raiserror('No se puede actualizar el nombre del material'16,1)
end
go
--NO SE ACTUALIAZA EL NOMBRE
update materiales set nombre = 'Boa' where clave = 1

-- VALIDAR QUE REALMENTE SE EJECUTA UN ROLLBACK TRAN (DESHACER TRANSACCION)
-- ES PELIGROSO UNA ACTUALIZACION MASIVA

update materiales set precio = 20

-- NO PERMITIR ACTUALIZACION MASIVAS EN LA TABLA MATERIALES
go
create trigger tr_mat_upd
on materiales for update as
	declare @conta int
	select @conta = count(*) from inserted

	if @conta > 1
	begin
		rollback tran
		raiserror('NO SE PUEDEN HACER INSERCIONES MASIVAS', 16, 1)
	end
go
drop trigger tr_mat_upd

-- NO ES PERMITIDO
update materiales set precio = 1000;

-- PERMITIDO
update materiales set precio = 1000 where clave = 1;
go

-- NO PERMITIR QUE SE ELIMINEN REGISTROS DE LA TABLA MATERIALES
create trigger tr_materiales_delete2
on materiales for delete as
	
	rollback tran
	raiserror('POR EL MOMENTO NO SE PUEDE ELIMINAR REGISTROS', 16, 1)

go

-- PROCEDIMIENTO ALM QUE LLEGUE A CREAR UN TRIGGER QUE NO PERMITA ELIMINAR
-- REGISTROS EN TODAS LAS TABLAS
create or alter proc sp_crea_trigger_delete as
begin
	declare @min int, @nom varchar(50)

	select @min = min(id) from sysobjects
	where xtype = 'U' and name not like 'SYS%'

	while @min is not null
	begin
		select @nom = name from sysobjects
		where id = @min

		print 'CREATE TRIGGER TR_' + replace(@nom,' ','') + '_DELETE'
		print 'ON [' + @nom + '] FOR DELETE AS'
		print ' ROLLBACK TRAN'
		print ' RAISERROR(' + CHAR(39) + 'POR EL MOMENTO NO SE PUEDE ELIMINAR REGISTROS' + CHAR(39) + ', 16, 1)'
		print 'GO'
		print 'HOLA'
		select @min = min(id) from sysobjects
		where id > @min and xtype = 'U' and name not like 'SYS%'
	end
end
go

exec sp_crea_trigger_delete

-- AGREGAMOS EL CAMPO CONTADOR PARA LLEVAR EL NUMERO DE ACTUALIZACIONES
alter table materiales add contador int
update materiales set contador = 0
alter table materiales add constraint def_cont_materiales default( 0 ) for contador
go
create trigger tr_materiaes_conta
on materiales for update as
	
	declare @clave int, @conta int

	select @clave = clave, @conta = isnull( contador, 0) from inserted

	if update( nombre )
	begin
		if @conta > 0
		begin
			rollback tran
			raiserror('NO SE PUEDE ACTUALIZAR EL NOMBRE MAS DE UNA VEZ', 16, 1)
		end
		else
		begin
			update materiales set contador = 1 where clave = @clave
		end
	end
go
--
--CREAR EL HISTORICO DE PRECIOS EN LA TABLA PRODUCTS
create table historico(
productid int not null,
unitprice numeric(12,2) not null,
fecha datetime not null,
usuario char(30)
)
go
create trigger Tr_products_hist
on products for insert, update
as

if update(unitprice)
begin
     insert historico
	 select productid, unitprice, getdate(), system_user from inserted
end
go

--LLENAMOS LA TABLA CON LA FECHA ACTUAL
insert historico
select productid, unitprice, getdate(), system_user from products

update products set productname='CHAI' where productid=1
update products set unitprice=61.1 where productid=1

--NOSE GRABA




