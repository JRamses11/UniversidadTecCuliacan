USE Northwind

--1.- AGREGAR A LA TABLA CATEGORIES EL CAMPO TOTALPIEZAS, EL CUAL REPRESENTARÁ EL TOTAL DE PIEZAS VENDIDAS DE 
--CADA CATEGORIA. CREAR UN PROCEDIMIENTO ALMACENADO QUE LLENE DICHO CAMPO.
Alter table categories add totalPiezas int null;
go
create proc sp_PiezasVendidas as
declare @totalPiezas int = 0, @count int = 0, @producto int, @categoria int, @aux int;

select @categoria = min(categoryid) from products;

while @categoria is not null
begin
	select @totalPiezas = sum(quantity)
	from vw_orderdetails
	where categoryid = @categoria

	update Categories set totalPiezas = @totalPiezas where CategoryID = @categoria

	select @categoria = min(categoryid) from products where CategoryID > @categoria
end
exec sp_PiezasVendidas
select*from Categories
go

--2.- SP QUE RECIBA LA CLAVE DEL EMPLEADO Y REGRESE POR RETORNO LA EDAD EXACTA DEL EMPLEADO.
create proc sp_edadEmpleado @empid int as

declare @edad int, @fecha datetime
select @edad = datediff(yy, birthdate, getdate()) from employees where employeeid = @empid
select @fecha = DATEADD(YY, @edad, birthdate) from employees where EmployeeID = @empid

if @fecha > getdate()
begin
	select @edad = @edad - 1;
end
select [Edad empleado] = @edad;
go
exec sp_edadEmpleado 3
go

--3.- PROCEDIMIENTO ALMACENADO QUE RECIBA COMO PARAMETRO UNA FECHA Y REGRESE DOS PARAMETROS:
--UN PARAMETRO CON EL NOMBRE DE TODOS LOS CLIENTES QUE COMPRARON ESE DIA Y OTRO PARAMETRO 
--CON LA LISTA DE LAS ORDENES REALIZADAS ESE DIA.
go
create proc sp_OrdenClientes
@fecha datetime, @nombre nvarchar(2000) output, @orden nvarchar(2000) output as
select @nombre = '', @orden = ''
declare @customer nchar(8) = 0, @aux1 nvarchar(100) = '', @aux2 int 

while @customer is not null
begin   
	select @customer = min(CustomerID) from vw_orderdetails where CustomerID > @customer

	select @aux1 = customerContactName, @aux2 = OrderID
	from vw_orderdetails 
	where CustomerID = @customer AND OrderDate = @fecha

	if @aux1 <> ''
	begin 
		set @nombre = @nombre + '' + @aux1 + ', '
		set @orden = @orden + '' + cast(@aux2 as nvarchar(20)) + ', '
		set @aux1 = ' '
	end
end
go
declare @r1 nvarchar(2000),  @r2 nvarchar(2000)
exec sp_OrdenClientes '1996-07-19', @r1 output, @r2 output
select Nombres = @r1, Ordenes = @r2
go

--4.- PROCEDIMIENTO ALMACENADO QUE REGRESE UNA TABLA CON LA FECHA 
--Y LOS NOMBRES DE LOS CLIENTES QUE COMPRARON ESE DÍA.
go
alter proc sp_tablaClientes as

create table #tabla (fecha datetime, cliente nvarchar(40)) 
declare @fecha datetime, @cliente nvarchar(40)
select @fecha = MIN(orderdate) from orders

while @fecha is not null
begin
	select @cliente = customerContactName from vw_orders where OrderDate = @fecha
	insert #tabla values(@fecha, @cliente)
	select @fecha = MIN(orderdate) from orders where OrderDate > @fecha
end
select * from #tabla
go
exec sp_tablaClientes
go

--5.- SP QUE RECIBA UN AÑO Y REGRESE COMO PARAMETRO DE SALIDA LA CLAVE DEL ARTICULO 
--QUE MAS SE VENDIO ESE AÑO Y CANTIDAD DE PIEZAS VENDIDAS DE ESE PRODUCTO EN ESE AÑO.
go
create proc sp_ArtMasVendido 
@año int, @claveProd int output, @cantidadPiezas int output as
declare @auxID int = 0, @masVendido int = 0;

while @auxID is not null
begin
	select @auxID = MIN( productid ) from Products where ProductID > @auxID
	select @cantidadPiezas = SUM( quantity ) 
	from [Order Details] od 
	inner join orders o on od.OrderID = o.OrderID
	inner join products p on od.ProductID = p.ProductID
	where p.ProductID = @auxID AND YEAR(o.OrderDate) = @año

	if @cantidadPiezas > @masVendido
	begin
		select @masVendido = @cantidadPiezas
		select @claveProd = @auxID
	end
end
select @cantidadPiezas = @masVendido
go
declare @prodID int, @totalPiezas int
exec sp_ArtMasVendido 1996, @prodID output, @totalPiezas output
select clave = @prodID, total = @totalPiezas
go
 @cantidadPiezas= @masVendido
go

--6.- SP QUE RECIBA LA CLAVE DEL EMPLEADO Y REGRESE COMO PARAMETRO 
--DE SALIDA TODOS LOS NOMBRES DE LOS TERRITORIOS QUE ATIENDEN EL EMPLEADO.
go
create proc sp_employeeTerritories 
@empid int, @territoriosAtendidos nvarchar(2500) output as
declare @territoryID int, @aux nvarchar(50)

select @territoriosAtendidos = ' '
select @territoryID = MIN(territoryid) from vw_employeeterritories

while @territoryID is not null
begin

	select @aux = TerritoryDescription
	from vw_employeeterritories
	where TerritoryID = @territoryID AND EmployeeID = @empid

	if @aux <> ' '
	begin
		set @territoriosAtendidos = @territoriosAtendidos + '' + @aux
		set @aux = ' '
	end
	select @territoryID = MIN(territoryid) from vw_employeeterritories where TerritoryID > @territoryID
	print @aux
end
go
declare @territorios nvarchar(2500)
exec sp_employeeTerritories 5, @territorios output
select @territorios


--7.- SP QUE REALICE UN PROCESO DONDE REGRESE LA SIGUIENTE TABLA:
--"NOMBRE DE JEFES" SERÁ LA CADENA CON TODOS LOS NOMBRE DE LOS JEFES QUE TIENE EL EMPLEADO. 
--“Jefe Superior” ES EL JEFE QUE SE ENCUENTRA EN LA RAIZ DEL ARBOL DE EMPLEADOS.
go
create proc sp_EmpleadoJefe as

create table #tabla2 (Empleado nvarchar(100), Jefes nvarchar(100), JefeSup nvarchar(100))

declare @emp2 nvarchar(50), @emp int, @jefe int, @aux nvarchar(200), @jefeSup nvarchar(50)
select @emp = MIN(EmployeeID) from Employees

while @emp is not null
begin 
	select @jefe = reportsTo from Employees where EmployeeID = @emp
	if @jefe is null 
		select @aux = ''
	else
		select @aux = FirstName + ', ' from Employees where EmployeeID = @jefe 

	select @jefeSup = FirstName from Employees where EmployeeID = @jefe

	while @jefe is not null
	begin
		select @jefe = reportsTo from Employees where EmployeeID = @jefe
		
		select @aux = @aux + ', ' + FirstName from Employees where EmployeeID = @jefe 
		select @jefeSup = FirstName from Employees where EmployeeID = @jefe
	end
	
	select @emp2 = FirstName from Employees where EmployeeID = @emp
	insert #tabla2 values(@emp2, @aux, @jefeSup)
	
	select @emp = min(EmployeeID) from Employees where EmployeeID > @emp
end

select * from #tabla2
go
exec sp_EmpleadoJefe


--8.- PROCEDIMIENTO ALMACENADO QUE RECIBA EL NOMBRE DE UNA TABLA Y
--QUE EL PROCEDIMIENTO IMPRIMA EL CODIGO DE CREACIÓN DE DICHA TABLA.
create proc sp_codigoCreacionTabla
@nombreTabla nvarchar(100) as

declare @texto nvarchar( 2000 ), @columna nvarchar(50), @tipo nvarchar(20), @isnull int, @col int
declare @prec int, @scale int

print 'create table ' + @nombreTabla + ' ('

select @col = min(colorder) from syscolumns
while @col is not null
begin
	select @columna =  c.name, @tipo = t.name, @prec = c.prec, @scale = c.scale, @isnull = isnullable
	from syscolumns c
	inner join systypes t on c.xtype = t.xtype
	where c.id = object_id(@nombreTabla) and t.name not like 'sysname' and c.colorder = @col

	select @texto = @columna + ' ' + @tipo 
	if @texto like '%char'
		select @texto = @texto + '(' + CAST(@prec as nvarchar(10)) + ')'
	if @texto like '%numeric'
		select @texto = @texto + '(' + CAST(@prec as nvarchar(10)) + ',' + CAST(@scale as nvarchar(10)) + ')'

	if @isnull = 0
		select @texto = @texto + ' not null,'
	else
		select @texto = @texto + ' null,'

	select @col = min(colorder) from syscolumns where colorder > @col AND id = object_id(@nombreTabla)
	if @col is null
	begin
		select @texto = substring(@texto, 1, len(@texto) - 1)
		select @texto = @texto + ')'
	end
	print '' + @texto
end
go
exec sp_codigoCreacionTabla categories

