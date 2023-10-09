use Northwind
--DICCIONARIO DE DATOS

--TABLAS DE SISTEMAS

--Tabla SYSOBJECTS
--Contiene toda la informacion referente a tablas, vistas, sp, funciones y demas objetos de la BD
select*from sysobjects
select*from INFORMATION_SCHEMA.TABLES
xtype:
u:tablas
p:sp
v:vistas
fn,tf:funciones

--Tablas de usuario de la base de datos
select id,name,xtype
from sysobjects where xtype='u'
order by id

--Funciones utilizadas
object_id('Nombre de la tabla')
--funcion que recibe el nombre de un objeto y regresa el identificador de dicho objeto.
select object_id('categories')

object_name (identificador):
--funcion que recibe el identificador de un objeto y regresa el nombre de dicho objeto
select object_name(21575115)

--TABLA SYSCOLUMNS:
--Contiene el nombre de columnas de tablas y vistas, tambien el nombre de los parametros de los
--procedimientos almacenados
select id,colid, colorder,name,xtype,length, prec,scale, isnullable
from syscolumns where object_id('products')=id

--TABLA SYSTYPES
--contiene los datos asociados a columnas de tablas y vistas
--tambien incluye los tipos de datos asociados a los parametros de los proc alm
select xtype, name from systypes

--consulta el nombre de las columnas y tipos de datos
go
select c.colorder, c.name, tipo=t.name, c.prec, c.scale, isnullable
from syscolumns c
inner join systypes t on c.xtype= t.xtype
where c.id=object_id('products') and t.name not like 'sysname'
order by c.colorder
go
create proc sp_columnas @tabla nvarchar(100) as
declare @texto nvarchar (2000), @alias varchar(2), @min int, @columna varchar (50)

select @alias=substring (@tabla,1,1)
select @texto='Select'

select @min=min(colid) from syscolumns where id=object_id(@tabla)
while @min is not null
begin
      select @columna= name from syscolumns where id=object_id(@tabla) and @min=colid
	  select @texto=@texto+@alias+'.'+@columna+','

	  select @min=min (colid)from syscolumns where id=object_id(@tabla) and colid>@min
end
select @texto=substring (@texto,1,len(@texto)-1)
select @texto=@texto+'from'+@tabla+''+@alias
select @texto
go
--EJECUCION 
sp_columnas categories

--SP QUE RECIBA LA CLAVE DEL EMPLEADO Y REGRESA LA CLAVE DEL JEFE SUPERIOR Y NIVEL DEL EMPLEADO
create proc SP_superior @emp int, @jefesup int output, @nivel int output as
declare @aux int
select @nivel=0
select @jefesup=reportsto from employees where employeeid=@emp

while @jefesup is not null
begin
     select @aux=@jefesup
	 select @nivel=@nivel+1

	 select @jefesup=reportsto from employees where employeeid=@jefesup
end
    select @jefesup=@aux
go
--EJECUCION
declare @a int, @b int
exec SP_superior 3, @a output, @b output
select sup=@a, nivel=@b

--SP QUE RECIBA LA CLAVE DEL EMPLEADO Y REGRESA LA CLAVE DEL JEFE SUPERIOR Y EL NIVEL DEL EMPLEADO
go
create proc sp_jefeSuperior @emp int, @jefesup int output, @nivel int output as
declare @aux int 
select @nivel=0
select @jefesup=reportsto from employees where employeeid=@emp

while @jefesup is not null
begin
     select @aux=@jefesup
	 select @nivel=@nivel+1

	 select @jefesup=reportsto from employees where employeeid=@jefesup
end
    select @jefesup=@aux
go
--EJECUCION
declare @a int, @b int
exec sp_jefeSuperior 6, @a output, @b output
select sup=@a, nivel=@b





