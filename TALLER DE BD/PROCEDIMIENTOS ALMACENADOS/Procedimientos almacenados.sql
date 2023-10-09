USE Northwind
--PROCEDIMIENTO ALMACENADOS 
--1.SIN PARAMETRO
go
create proc SP_aumento as
update products set unitprice=unitprice*1.1
go
--EJECUCION
exec SP_aumento
--VALIDAR PRODUCTO 1
select productid, unitprice from products where productid=1

--2.SP CON PARAMETRO DE ENTRADA
--SP QUE RECIBA 4 CALIFICACIONES IMPRIMIR EL PROMEDIO
go
create proc SP_calificaciones 
@cal1 int, @cal2 int, @cal3 int, @cal4 int as
declare @prom numeric(12,2)

select @prom=(@cal1+@cal2+@cal3+@cal4)/4

select @prom
go
--EJECUCION
exec SP_calificaciones 34,56,79,80
--SE PUEDE CAMBIAR EL ORDEN DE LOS PARAMETROS INDICANDO EL NOMBRE ANTES DEL VALOR
exec SP_calificaciones @cal2=56, @cal3=79,@cal4=80,@cal1=34

--3.CON PARAMETROS DE SALIDA
--SP QUE RECIBA 4 CALIFICACIONES Y REGRESE COMO PARAMETRO DE SALIDAA EL PROMEDIO Y SI FUE APROBADO
go
create proc SP_calificaciones_sal
@cal1 int, @cal2 int, @cal3 int, @cal4 int,
@prom numeric(12,3)output, @tipo char(20) output as

select @prom=(@cal1+@cal2+@cal3+@cal4)/4.0
if @prom>=70
   select @tipo='Aprobado'
else
   select @tipo='Reprobado'
go
--EJECUCION
declare @A numeric(12,3), @B char(20)
select @A, @B
exec SP_calificaciones_sal 70,80,60,70, @A output, @B output
select calificacion=@A, resultado=@B


--PROPORCIONAR UNA FECHA DE NACIMIENTO Y CALCULAR LA EDAD EXACTA
go
create proc SP_edad @fecha datetime, @edad int output as
select @edad=datediff(yy,@fecha,getdate())
select @fecha=dateadd(yy,@edad,@fecha)

if @fecha>getdate()
   select @edad=@edad-1
go
--EJECUCION
declare @r int
exec SP_edad '10/11/2000', @r output
select @r

--TABLA CON EL NOMBRE DEL EMPLEADO Y LA EDAD EXACTA DE LOS EMPLEADOS
go
alter proc SP_edadtodos as
declare @emp int, @edadexacta int, @fechanac datetime
create table #aux (emp int, edadexacta int)

select @emp=min(employeeid) from employees
while @emp is not null
begin
     select @fechanac= birthdate from employees where employeeid=@emp
	 exec SP_edadtodos @fechanac, @edadexacta output
	 insert into #aux values(@emp, @edadexacta)
	 select @emp=min(employeeid) from employees where employeeid>@emp
end
select nombre=e.firstname+''+e.lastname, e.birthdate, edadExacta=a.edadExacta
from #aux a
inner join employees e on e.employeeid=a.emp
go
--EJECUCION
exec SP_edadtodos

--4 CON VALOR POR RETORNO
--VALOR POR RETORNO UTILIZA LA PALABRA RESERVADA RETURN Y
--REGRESA SOLO VALORES ENTEROS
go
create proc SP_calificacionreturn
@cal1 int, @cal2 int, @cal3 int, @cal4 int as
declare @prom int
select @prom=(@cal1+@cal2+@cal3+@cal4)/4.0
return
@prom
go
--EJECUCION 
declare @a integer
select @a
exec @a=SP_calificacionreturn 60,80,98,70
select @a

--5 CON VALORES PREDEFINIDOS
--PROCEDIMIENTO QUE RECIBE PARAMETROS Y TIENE VALORES PREDEFINIDOS
--DECLARACION
create proc SP_recibir_default
@val1 int, @val2 int, @val3 int=20, @val4 int=30 as

declare @total int
select @total= @val1+@val2+@val3+@val4
select @total
go
--EJECUCION
exec SP_recibir_default 2,4,5,6

--SE PUEDE OMITIR LOS 2 ULTIMOS VALORES
exec SP_recibir_default 2,4

exec SP_recibir_default 2,4, @val4=6

