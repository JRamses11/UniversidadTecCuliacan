USE Northwind
--CONTROL DE FLUJO
--BLOQUE: DETERMINA UNA CANTIDAD DE TRABAJO EN SQL SERVER
begin 
sentencia 1
sentencia 2
end
--SENTENCIA IF SE UTILIZA PARA EJECUTAR UNA CONDICION
if (condicion)
begin 
sentencia 1
sentencia 2
end
else
begin
sentencia 3
sentencia 4
end
--IMPRIMIR EL PRECIO DEL PRODUCTO MAS CARO Y ESPECIFICAR SI ES MAYOR A 30 PESOS O NO
declare @precio numeric(12,2)
select @precio=max(unitprice) from products
if @precio>30
   print 'El precio maximo es mayor a 30= ' +convert (varchar(10), @precio)
else
   print 'El precio maximo es menor a 30= ' +convert (varchar(10), @precio)

--VERIFICAR SI EXISTE EL PRODUCTO 100
if exists (select*from products where productid=11)
   print 'Si existe es verdadero 11'
else
   print 'No existe el producto 11'

--SENTENCIA WHILE
while (condicion)
begin 
     sentencia 1
     sentencia 2
end

--RECORRER LA TABLA PRODUCTOS IMPRIMIENDO LA CLAVE DE TODOS LOS PRODUCTOS
declare @min int
select @min = min(productid) from products

while @min is not null
begin 
     print @min

     select @min= min(productid) from products where productid>@min
end
   print 'fin del ciclo'

----RECORRER LA TABLA EMPLEADO IMPRIMIENDO LA CLAVE DE TODOS LOS EMPLEADO
declare @emp int 
select @emp= min(employeeid) from employees

while @emp is not null
  begin 
      print @emp

      select @emp = min (employeeid) from employees where employeeid>@emp
  end
print 'Fin del ciclo'
go
--CICLO QUE IMPRIMA LA CLAVE DEL EMPLEADO (DE MAYOR A MENOR) Y CLAVE DE SU JEFE INMEDIATO
declare @emp int, @jefe int
select @emp= max(employeeid)from employees

while @emp is not null
begin
     select @jefe =reportsto from employees where employeeid=@emp

	 PRINT str(@emp)+',' +str(isnull(@jefe,''))

	 select @emp=max(employeeid) from employees where employeeid<@emp
end
   PRINT 'FIN DEL CICLO'

go
--PROCESO QUE RECIBA UNA FECHA CON QUE INICIO A TRABAJAR UN EMPLEADO Y CALCULE LOS DIAS TRABAJADOS
declare @fecha datetime, @conta int=0, @dia int

select @fecha='1/1/2000'

while @fecha<=getdate()
begin
     select @dia= datepart (dw,@fecha)

	 if @dia in (2,3,4,5,6)
	    select @conta= @conta+1

		select @fecha= dateadd (dd,1,@fecha)
end
select @conta

--PROCESO PARA ENCONTRAR LOS DIAS TRABAJADOS DE TODOS LOS EMPLEADOS DESCONTANDO SABADO Y DOMINGO
go
declare @clave int, @dia int, @conta int, @fecha datetime
create table #tabla (emp int, dias int)
select @clave= MIN (employeeid) from Employees
while @clave is not null
begin
     select @fecha=hiredate from employees where employeeid= @clave
	 select @conta=0

	 while @fecha<=getdate()
	 begin
	      select @dia=datepart (dw, @fecha)
		  if @dia not in(2,3,4,5,6)
		     select @conta=@conta+1

			 select @fecha=dateadd(dd,1,@fecha)
	  end
	  insert #tabla values (@clave, @conta)
	  
	  select @clave=MIN (employeeid) from employees where employeeid>@clave
end
select e.firstname+' '+e.lastname, trabajados=T.dias, datediff (dd, e.hiredate, getdate() )
from #tabla T
inner join employees e on e.employeeid=T.emp
