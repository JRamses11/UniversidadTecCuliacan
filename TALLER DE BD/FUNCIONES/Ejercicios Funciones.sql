USE Northwind

--1.- FUNCION ESCALAR QUE RECIBA DOS CLAVES DE CLIENTES Y UN AÑO, Y REGRESE EL NOMBRE DEL CLIENTE 
--QUE MAS HA VENDIDO PIEZAS DE LOS DOS EN ESE AÑO Y EL TOTAL DE PIEZAS VENDIDAS. POR EJEMPLO, DEBE REGRESAR: 
--EL CLIENTE JUAN PEREZ VENDIO 450 PIEZAS.
go
create function dbo.ClienteMasVentas (@Cliente1 nchar(5), @Cliente2 nchar(5), @Anno numeric(4, 0))
returns nvarchar(90)
as
begin

	declare @VentasC1 smallint, @VentasC2 smallint

	select @VentasC1 = COUNT(*) from [Order Details] OD
	inner join Orders O on OD.OrderID = O.OrderID
	group by O.CustomerID, O.OrderDate
	having O.CustomerID = @Cliente1 and YEAR(O.OrderDate) = @Anno

	select @VentasC2 = COUNT(*) from [Order Details] OD
	inner join Orders O on OD.OrderID = O.OrderID
	group by O.CustomerID, O.OrderDate
	having O.CustomerID = @Cliente2 and YEAR(O.OrderDate) = @Anno

	declare @Nombre nvarchar(30), @Ventas smallint
	select @Ventas = @VentasC1
		
	if(@VentasC1 > @VentasC2)
	begin
		select @Ventas = @VentasC1
		select @Nombre = C.ContactName from Customers C where C.CustomerID = @Cliente1
	end
	else if(@VentasC2 > @VentasC1)
	begin
		select @Ventas = @VentasC2
		select @Nombre = C.ContactName from Customers C where C.CustomerID = @Cliente2
	end
	else
		return ('AMBOS CLIENTES COMPRARON ' + CONVERT(nvarchar(5), @Ventas) + ' PIEZAS. ')

	declare @Retorno nvarchar(90)
	select @Retorno = 'EN EL AÑO ' + CONVERT(nvarchar(4), @Anno) + ', AL CLIENTE ' + @Nombre + ' SE LE VENDIERON ' + CONVERT(nvarchar(5), @Ventas) + ' PIEZAS'

	return (@Retorno)
end
go
select [Cliente con más ventas] = dbo.ClienteMasVentas('FRANK', 'BERGS', 1997)
go


--2.- FUNCION ESCALAR QUE RECIBA LA CLAVE DEL EMPLEADO Y REGRESE UNA CADENA CON LOS NOMBRE 
--DE LOS TERRITORIOS QUE ATIENDE.
create function dbo.TerritoriosQueAtiende (@Empleado int)
returns nvarchar(500)
as
begin
	declare @Retorno nvarchar(500), @Territorio nvarchar(20)

	select @Territorio = MIN(ET.TerritoryID) from EmployeeTerritories ET where ET.EmployeeID = @Empleado
	select @Retorno = T.TerritoryDescription from Territories T where T.TerritoryID = @Territorio

	while @Territorio is not null
	begin
		select @Territorio = MIN(ET.TerritoryID) from EmployeeTerritories ET
		where ET.EmployeeID = @Empleado and ET.TerritoryID > @Territorio

		select @Retorno = @Retorno + ', ' + T.TerritoryDescription
		from Territories T where T.TerritoryID = @Territorio
	end

	return @Retorno
end
go
select [Territorios del empleado] = dbo.TerritoriosQueAtiende(6)
go


--3.- FUNCION DE TABLA EN LINEA QUE RECIBA LA CLAVE DE UN PRODUCTO Y REGRESE UNA TABLA CON EL NOMBRE
--DE TODOS LOS CLIENTES QUE HAN COMPRADO ESE PRODUCTO, EL TOTAL DE PRODUCTOS COMPRADO 
--Y EL TOTAL DE ORDENES EN LAS QUE SE HA VENDIDO.
create function dbo.ProductData (@ProductID int)
returns table
as
return
select p.ProductID, [NOMBRE DEL CLIENTE] = c.CompanyName, [TOTAL PRODUCTOS] = SUM(OD.Quantity), [TOTAL ORDENES] = COUNT(*)
from Products p
inner join [Order Details] od on od.ProductID = p.ProductID
inner join Orders o on o.OrderID = od.OrderId
inner join Customers c on c.CustomerID = o.CustomerID
where p.ProductID = @ProductID
group by c.CompanyName, P.ProductID
go
select * from DBO.ProductData(1)
go


--4.- FUNCION DE TABLA EN LINEA QUE RECIBA LA CLAVE DEL EMPLEADO Y AÑO, REGRESE EN UNA CONSULTA 
--EL NOMBRE DEL PRODUCTO Y TOTAL DE PRODUCTOS VENDIDOS POR ESE EMPLEADO Y ESE AÑO.
create function dbo.EmpProdData (@EMPLOYEE_ID int, @YEAR int)
returns table
as
return
select [NOMBRE DEL PRODUCTO] = P.ProductName, [TOTAL PIEZAS] = ISNULL(SUM(OD.Quantity), 0)
from [Order Details] OD 
inner join Products P on P.ProductID = OD.ProductID
inner join Orders O on O.OrderID = OD.OrderID
inner join  EMPLOYEES E on E.EmployeeID = O.EmployeeID
group by P.ProductName, O.EmployeeID, YEAR(O.OrderDate)
having O.EmployeeID = @EMPLOYEE_ID AND YEAR(O.OrderDate) = @YEAR
go
select * from DBO.EmpProdData(2, 1996)
go

--4.1.- UTILIZANDO LA FUNCION ANTERIOR MOSTRAR UNA CONSULTA SIGUIENTE:
select [NOMBRE DEL PRODUCTO] = P.ProductName, [TOTAL PIEZAS 96] = COALESCE(DATA_SEIS.[TOTAL PIEZAS], 0),
[TOTAL PIEZAS 97] = COALESCE(DATA_SIETE.[TOTAL PIEZAS], 0), [TOTAL PIEZAS 98] = COALESCE(DATA_OCHO.[TOTAL PIEZAS], 0)
from Products P 
left outer join dbo.EmpProdData(2, 1996) DATA_SEIS on DATA_SEIS.[NOMBRE DEL PRODUCTO] = P.ProductName
left outer join dbo.EmpProdData(2, 1997) DATA_SIETE on DATA_SIETE.[NOMBRE DEL PRODUCTO] = P.ProductName
left outer join dbo.EmpProdData(2, 1998) DATA_OCHO on DATA_OCHO.[NOMBRE DEL PRODUCTO] = P.ProductName
go

--5.-
--FUNCION DE TABLA DE MULTISENTENCIA (NO LLEVA PARAMETROS DE ENTRADA) QUE REGRESE UNA TABLA 
--CON EL NOMBRE DE LA CATEGORIA Y LOS NOMBRES DE LOS PRODUCTOS QUE PERTENECEN A LA CATEGORIA Y EL TOTAL DE PIEZAS 
--QUE SE HAN VENDIDO DE ESA CATEGORIA
create function dbo.fn_categrorias()
returns @categorias table(NomCat varchar(500), NomPro varchar(500), TotalP int) 
as
begin
	declare @IdCat int, @Productos nvarchar(500), @CatName nvarchar(500), @Total int 
	select @IdCat = MIN(c.CategoryID) from Categories c
	while @IdCat is not null
		begin
			select  @CatName = c.CategoryName from Categories c where c.CategoryID = @IdCat
			select  @Productos = STRING_AGG(p.ProductName, ' ,') from Products p where p.CategoryID = @IdCat
			select  @Total = c.TotalPiezas from Categories c where c.CategoryID = @IdCat
			insert	@categorias values (@CatName, @Productos, @Total)
			select  @IdCat = MIN(c.CategoryID) from Categories c where CategoryID > @IdCat
		end
return
end
go
select * from fn_categrorias()
go
--6.- FUNCION DE TABLA DE MULTISENTENCIA QUE RECIBA UN AÑO COMO PARAMETRO DE ENTRADA, QUE REGRESE UNA TABLA 
--CON DOS COLUMNAS: DIA DE LA SEMANA, FOLIOS QUE SE 
--VENDIERON ESE DÍA DE SEMANA. NOTA, DEBE MOSTRAR TODOS LOS DIAS 
--DE LA SEMANA AUNQUE NO SE HAYAN REALIZADO ORDENES.
create function dbo.fn_DiasSemana() --Funcion dias de la semana
returns table 
as return(
	select clave = 1, nombre = 'sunday' union
	select 2, 'monday' union
	select 3, 'tuesday' union
	select 4, 'wednesday' union
	select 5, 'thursday' union
	select 6, 'friday' union
	select 7, 'saturday')
go
create function dbo.fn_Folios2 (@año int)
returns @VentasDias table (DiaSemana nvarchar(500), Folios nvarchar(500))
as
begin
	insert into @VentasDias
	select s.nombre, STRING_AGG(CONVERT(nvarchar(MAX), ISNULL(o.OrderID,0)),',')
	from dbo.fn_DiasSemana() s
    LEFT outer join orders o on DATEPART(dw,o.OrderDate)=s.clave AND YEAR(OrderDate) = @AÑO
	group by s.nombre, s.clave
	order by s.clave
return
end
go
select * from dbo.fn_Folios2(1996)
go