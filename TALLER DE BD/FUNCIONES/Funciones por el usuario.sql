use Northwind
--TIPOS DE FUNCIONES DEFINIDAS POR EL USUARIO

/*
1-Las funciones escalares
2-Tabla en linea
3-Funciones de tabla de multisentencia
*/

--1. FUNCIONES ESCALARES
--VUELVEN UN TIPO DE DATO TAL COMO INT, MONEY, VARCHAR, REAL, ETC.
--FUNCION QUE SACA EL CUBO DE UN NUMERO
go
create function dbo.cubo(@num numeric(12,2))
returns numeric(12,2)
as
begin
     return (@num*@num*@num)
end
go
--ejecucion
select dbo.cubo(4)
declare @r numeric(12,2)
select @r=dbo.cubo(3)
select @r

--FACTORIAL DE UN NUMERO
go
create function dbo.Factorial(@Numero int)
returns int 
as
begin
     declare @i int
	 if @Numero<=1
	    set @i=1
	 else
	    set @i=@Numero*dbo.Factorial(@Numero-1)

	return @i
end
go
--EJECUCION
select dbo.Factorial(2)

select employeeid, reportsto from employees

--FUNCION JEFE SUPERIOR: LA FUNCION RECIBE LA CLAVE DE UN EMPLEADO Y REGRESA EL JEFE SUPERIOR
GO
create function dbo.JEFE(@emp int)
returns int
as
begin
    declare @jefe int, @r int
	select @jefe=reportsto from employees where employeeid=@emp

	if @jefe is null
	   select @r=@emp
	else
	   select @r=dbo.JEFE(@jefe)

	return @r
end
GO
--EJECUCION
select dbo.JEFE(3)

--FUNCIONES DE TABLA EN LINEA
--LAS FUNCIONES SON LAS FUNCIONES QUE DEVUELVEN LA SALIDA DE UNA SIMPLE DECLARACION
--SELECT. LA SALIDA SE PUEDE UTILIZAR ADENTRO DE CONSULTAS COMO SI FUERA UN TABLA DE ESTANDAR

--La sintaxis para una funcion de tabla en linea es como sigue
create function [propietario].Nombre_Funcion
(@NombreParametro TipoDato[=default],...)
returns table
as
return (sentencia_select)
--Ejecucion
select*from dbo.fn_nombre(parametros)

--EJEMPLO: FUNCION DE TABLA QUE REGRESA LAS ORDENES REALIZADAS POR UN EMPLEADO EN PARTICULAR
go
create function dbo.Ordenes(@emp int)
returns table
as
return(select*from orders where employeeid=@emp)
go
--EJECUCUON
select*from dbo.Ordenes(1)

select o.orderid, e.firstname, d.unitprice, d.quantity
from dbo.Ordenes(1) O
inner join [Order Details] d on o.orderid=d.orderid
inner join employees e on e.employeeid=o.employeeid

--EJEMPLO 1
--FUNCION DE TABLA EN LINEA QUE RECIBA EL AÑO Y REGRESE EL NOMBRE DEL CLIENTE Y 
--EL TOTAL DE ORDENES DE ESE AÑO MOSTRAR TODOS LOS CLIENTES AUNQUE NO HAYAN PEDIDOS
go
create function dbo.OrdenesAño(@año int)
returns table
as
return (
select c.companyname, 'Total'=count (o.orderid)
from orders o
right outer join customers c on c.customerid=o.customerid and year(o.orderdate)=@año
group by c.companyname )
go
--EJECUCION
select*from dbo.OrdenesAño(1996) order by companyname
select*from dbo.OrdenesAño(1997) order by 1
select*from dbo.OrdenesAño(2000) order by 1

--NOMBRE DEL CLIENTE, TOTAL DE ORDENES 96, TOTAL ORDENES 97, TOTAL ORDENES 98
select a.companyname, t96=a.total, t97=b.total, t98=c.total
from dbo.OrdenesAño(1996) a
inner join dbo.OrdenesAño(1997) b on a.companyname=b.companyname
inner join dbo.OrdenesAño(1997) c on a.companyname=c.companyname

--EJEMPLO 2
--FUNCION DE TABLA EN LINEA QUE RECIBA EL AÑO Y REGRESE EL DIA DE LA SEMANA
--Y EL IMPORTE TOTAL DE VENTA DE ESE DIA
go
create function dbo.ventasDias(@año int)
returns table
as return(
select clave=datepart(dw,o.orderdate), dia=datename(dw,o.orderdate),
total= sum(d.quantity*d.unitprice)
from orders o
inner join [Order Details] d on d.orderid= o.orderid
where year(o.orderdate)=@año
group by datename(dw,o.orderdate), datepart (dw,o.orderdate))
go

select*from dbo.ventasDias(1998) order by clave

--PROBLEMA NO APARECEN LOS 7 DIAS DE LA SEMANA Y NO APARECE ORDENADOS POR DIA DE LA SEMANA
go
 create function dbo.fn_diasSemana()
 returns table
 as return(
    select clave=1,nombre='Sunday' union
	select 2, 'Monday' union
	select 3, 'Tuesday' union
	select 4, 'Wednesday' union
	select 5, 'Thursday' union
	select 6, 'Friday' union
	select 7, 'Saturday' )
go
--EJECUCION
select*from dbo.fn_diasSemana()
--SOLUCION A
select d.nombre, total=coalesce (v.total,0)
from dbo.fn_diasSemana() d
left outer join dbo.ventasDias(2000) v on v.clave=d.clave
order by d.clave

--SOLUCION B
go
alter function dbo.ventasDias(@año int)
returns table
as return(
select s.clave, Dia=s.nombre, Total=isnull(sum (d.quantity*d.unitprice),0)
from dbo.fn_diasSemana() s
left outer join orders o on s.clave=datepart (dw,o.orderdate) and year (o.orderdate)=@año
left outer join [order details] d on d.orderid= o.orderid
group by s.nombre, s.clave
)
go
select*from dbo.ventasDias (2000) o order by 1

--.-Las funciones de la tabla multisentencia
 CREATE FUNCTION [propietario] nombreFuncion
 (@parametros TipoDato [=default],...)
 returns @nomTabla table (nomCol, tipo_dato,...)
 as
 begin
     cuerpo funcion

	 --llenar tabla @nomTabla
	 return
end
--EJECUCION
select*from dbo.nombrefuncion(parametros)

--FUNCION DE TABLA MULTISENTENCIA QUE REGRESE LOS DIAS DE LA SEMANA
go
create function dbo.fn_DiasSemana2()
returns @semana table (clave int, nombre varchar(20))
as
begin
     insert @semana values(1,'Sunday')
	 insert @semana values(2,'Monday')
	 insert @semana values(3,'Thuesday')
	 insert @semana values(4,'Wednesday')
	 insert @semana values(5,'Thursday')
	 insert @semana values(6,'Friday')
	 insert @semana values(7,'Saturday')
	 return
end
go
select*from dbo.fn_DiasSemana2()

--CONSULTA CON EL DIA DE LA SEMANA Y EL TOTAL DE ORDENES REALIZADAS
--SE DEBEN MOSTRAR LOS 7 DIAS DE LA SEMANA
select d.nombre, count(o.orderid)
from dbo.fn_DiasSemana2() d
left outer join Orders o on datepart(dw, o.orderdate)=d.clave
group by d.nombre, d.clave
order by d.clave

--FUNCION MULTISENTENCIA QUE RECIBA UN AÑO, REGRESE EL NOMBRE DEL EMPLEADO Y EL TOTAL DE VENTAS DE LOS
--EMPLEADO EN ESE AÑO, MOSTRAR TODOS LOS EMPLEADOS AUNQUE NO HAYAN REALIZADO ORDENES}
go
create function fn_ventas(@año int)
returns @ventas table (Nomemp varchar(100), Total numeric (12,2))
as
begin
     insert @ventas
	 select firstname + ''+lastname, total=isnull(sum(quantity*unitprice),0)
	 from orders o
	 right outer join [Order Details] d on o.orderid= d.orderid
	 right outer join employees e on e.employeeid=o.employeeid and year (o.orderdate)=@año
	 group by firstname, lastname
	 return
end
go
--EJECUCION
select*from fn_ventas(2000)

--CONSULTA CON EL NOMBRE DEL EMPLEADO Y EL IMPORTE DE VENTA EN 1994, 1996 Y 1999
select a.nomemp, T94=isnull(a.Total,0), T96=isnull(b.Total,0), T99=isnull(c.Total,0)
from fn_ventas(1994) A
inner join fn_ventas (1996) b on b.Nomemp= a.Nomemp
inner join fn_ventas (1999) c on c.Nomemp= a.Nomemp

--FUNCION DE TABLA MULTISENTENCIA QUE REGRESE LA CLAVE DEL EMPLEADO Y EL TOTAL DE DIAS TRABAJADOS
--DESCONTANDO SABADOS, DOMINGOS
go
create function dbo.fn_diasTrabajados()
returns @resp table(emp int, dias int) as
begin
     declare @empId int, @dias int, @fechainicio datetime, @contador int

	 select @empId= min(employeeid) from employees
	 while @empId is not null
	 begin
	      select @fechainicio=hiredate from employees where employeeid=@empId
		  select @contador=0

		  while @fechainicio<=getdate()
		  begin
		       if not(datepart(dw,@fechainicio) in (1,7))
			      select @contador=@contador+1

				  select @fechainicio=dateadd(dd,1,@fechainicio)
		   end
		   insert @resp values(@empid, @contador)
		   select @empid= min (employeeid) from employees where employeeid>@empid
	  end
	  return
end
go
--EJECUCION 
select*from dbo.fn_diasTrabajados() d

--EJECUCION
select e.firstname+''+e.lastname, d.dias
from dbo.fn_diasTrabajados() d
inner join employees e on e.employeeid= d.emp

--FUNCION MULTISENTENCIA QUE RECIBA EL AÑO Y REGRESE TODOS LOS MESES Y EL IMPORTE TOTAL DE VENTA
go
create function dbo.fn_ImporteMeses(@año int)
returns @resp table( clave int, nombremes varchar(20), total numeric (12,2)) as
begin
     declare @mes table (clave int, nombremes varchar(20))
	 insert @mes values (1,'January')
	 insert @mes values (2,'February')
	 insert @mes values (3,'March')
	 insert @mes values (4,'April')
	 insert @mes values (5,'May')
	 insert @mes values (6,'June')
	 insert @mes values (7,'July')
	 insert @mes values (8,'August')
	 insert @mes values (9,'September')
	 insert @mes values (10,'October')
	 insert @mes values (11,'November')
	 insert @mes values (12,'December')

	 insert @resp
	 select m.clave, m.nombremes, isnull(sum (d.quantity*d.unitprice),0)
	 from  [Order Details] d
	 right outer join orders o on o.orderid=d.orderid
	 right outer join @mes m on m.clave=datepart(mm,o.orderdate) and year(o.orderdate)=@año
	 group by m.clave, m.nombremes
	 order by m.clave
	 return
end
go
select*from fn_Importemeses(2000)

--CONSULTA CON LA COMPARATIVA DE LOS MESES Y EL IMPORTE DE 1997,1998,1999
select a.nombremes, T97=a.total, T98=b.total, T99= c.total
from fn_ImporteMeses (1997) a
inner join fn_ImporteMeses(1998) b on b.clave=a.clave
inner join fn_Importemeses (1999) c on c.clave=a.clave
order by a.clave

--TABLA MULTISENTENICA, NO RECIBIRA PARAMETROS, REGRESARA UNA TABLA CON EL NOMBRE DEL EMPLEADO Y 
--LOS PRODUCTOS QUE HA VENDIDO EN SOLO CAMPO
go
create function dbo.fn_EmpleadosProductos()
returns @resp table(nombreEmp varchar(100), productos varchar(4000))
as
begin
    declare @emp int, @nomprod varchar(4000), @nombre varchar(100)
	declare @prod table(nomprod varchar(100))

	select @emp=min(employeeid) from employees
	while @emp is not null
	begin
	     select @nombre=firstname+''+lastname from employees
		 where employeeid=@emp

		 delete @prod

		 insert @prod
		 select p.productname
		 from [Order Details] d
		 inner join orders o on o.orderid=d.orderid
		 inner join products p on p.productid= d.productid
		 where o.employeeid=@emp
		 group by p.productname
		 order by 1
		 select @nomprod=''
		 select @nomprod= @nomprod+','+nomprod from @prod

		 insert @resp values(@nombre, @nomprod)
		 select @emp=min (employeeid) from employees where employeeid>@emp
	end
    return
end
go
select*from fn_EmpleadosProductos ()

--RECIBE EL AÑO Y REGRESE TODOS LOS DIAS DE LA SEMANA Y EL TOTAL DE ORDENES REALIZADAS
go
create function dbo.fn_diasT(@año int)
returns @resp table (nombredia varchar(20), importetotal int)
as
begin
     declare @semana table(clave int, nombredia varchar(20))
	 insert @semana values(1,'Sunday')
	 insert @semana values(2,'Monday')
	 insert @semana values(3,'Tuesday')
	 insert @semana values(4,'Wednesday')
	 insert @semana values(5,'Thursday')
	 insert @semana values(6,'Friday')
	 insert @semana values(7,'Saturday')

	 insert @resp
	 select s.nombredia, count(o.orderid)
	 from orders o
	 right outer join @semana s on s.clave=datepart (dw,o.orderdate) and year (o.orderdate)= @año
	 group by s.clave, s.nombredia
	 order by s.clave
	 return
end
go
--EJECUCION
select*from dbo.fn_diasT(1996)

select a.nombredia, T96=a.importetotal, T97=b.importetotal, T98=c.importetotal
from dbo.fn_diasT(1996) a
inner join dbo.fn_diasT (1997) b on b.nombredia= a.nombredia
inner join dbo.fn_diasT (1998) c on c.nombredia= a.nombredia
