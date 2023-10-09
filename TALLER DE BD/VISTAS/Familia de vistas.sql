USE Northwind

--FAMILIA DE VISTAS
--PLAN PARA GENERAR LA FAMILIA DE VISTAS EN LA BASE DE DATOS NORTHWIND
--SE DEBE IR GENERANDO LAS VISTAS DE AFUERA HACIA DENTRO E IR REUTILIZANDO LAS
--VISTAS CREADAS PREVIAMENTE CON TODAS SUS COLUMNAS

--SECUENCIA CREACION DE VISTAS
--NOMBRE                         TABLAS UTILIZADAS
------------------------------------------------------------------------------------------
--vw_products                      products,categories,suppliers
--vw_orders                        orders, employees,shippers, customers
--vw_orderdetais                   [orderdetails], vw_orders, vw_products

--SUPLEMENTARIAS
--vw_territories                   territories,region
--vw_employeeterritories           vw_territories, employees, employeeterritories
------------------------------------------------------------------------------------------

go
--VISTA PRODUCTS
create view vw_products as
select
p.productid, p.productname,p.quantityperunit, produnitprice=p.unitprice,
p.unitsinstock, p.unitsonorder, p.reorderlevel, p.discontinued,

s.supplierid, s.companyname, s.contactname, s.contacttitle, s.address,
s.city, s.region, s.postalcode, s.country, s.phone, s.fax, s.homepage,

c.categoryid, c.categoryname, c.description, c.picture
from products p
inner join suppliers s on p.supplierid=s.supplierid
inner join categories c on p.categoryid=c.categoryid
go
--EJECUCION DE VISTA PRODUCTS
select*from vw_products

--CONSULTA CON EL NOMBRE DE PRODUCTO, NOMBRE DE LA CATEGORIA Y NOMBRE DEL PROVEEDOR
select Productname, CategoryName, CompanyName
from vw_products

--ANTES SE REALIZABA EL COMBINADO DE 3 TABLAS

--CONSULTA CON EL NOMBRE DEL PROVEEDOR Y CUANTOS PRODUCTOS SURTE
select productname, categoryname, companyname
from vw_products
order by companyname

--PRIMERO AGRUPAMOS POR NOMBRE DEL PROVEEDOR
select companyname
from vw_products
group by companyname -- Busca los proveedores distintos

--FUNCIONES AGREGADOS: REGRESA UN SOLO VALOR
--COUNT
--SUM
--MAX
--MIN
--AVG

--TOTAL DE PRODUCTOS
select COUNT(*)from vw_products

--SUMA TODOS LOS PRECIOS DE LOS PRODUCTOS
select SUM(produnitprice)from vw_products
select produnitprice from vw_products

--CLAVE MAXIMA DE LOS PRODUCTOS
select MAX(productid) from vw_products

--CLAVE MINIMA
select MIN(productid) from vw_products

--FECHA MAS GRANDE DE ORDENES
select MAX (orderdate) from orders

--FECHA MAS PEQUEÑA DE ORDENES
select MIN(orderdate) from orders

--CONSULTA CON EL NOMBRE DEL PROVEEDOR Y CUANTOS PRODUCTOS SURTE
select companyname, total=count(*)
from vw_products
group by companyname  --BUSCA LOS PROVEEDORES DISTINTOS

--CONSULTA CON EL NOMBRE DE LA CATEGORIA Y CUANTOS PRODUCTOS CONTIENE
select categoryname, total=COUNT(*)
from vw_products
group by categoryname

--CONSULTA CON EL FOLIO DE LA ORDEN Y EL IMPORTE TOTAL DE VENTA
select orderid, productname, quantity, unitprice
from vw_orderdetails

select orderid
from vw_orderdetails
group by orderid --MUESTRA LAS ORDENES DISTINTAS

select orderid, importe=SUM(quantity*unitprice)
from vw_orderdetails
group by orderid --MUESTRA LAS ORDENES DISTINTAS

--CONSULTA CON EL NOMBRE DE LA CATEGORIA Y TOTAL DE PRODUCTOS QUE SURTE
--MOSTRAR SOLO LAS CATEGORIAS QUE TENGAN MENOS DE 10 PRODUCTOS

--MARCA ERROR, NO SE PERMITEN FUNCIONES DE AGREGADO EN WHERE
select categoryname, total=count(*)
from vw_products
where count(*)<10
group by categoryname

--ES NECESARIO INCLUIR LA FUNCION DE AGREGADO EN LA CLAUSULA HAVING
select categoryname, total=count(*)
from vw_products
group by categoryname
having count(*)<10

--CONSULTA CON EL NOMBRE DEL PROVEEDOR Y TOTAL DE PRODUCTOS QUE SURTE
--MOSTRAR SOLO LOS PROVEEDORES QUE SU NOMBRE EMPIECE CON M,N 
--Y QUE SURTAN ENTRE 1 Y 3 PRODUCTOS
select productname, categoryname, companyname
from vw_products
order by companyname

select companyname, count(*)
from vw_products
where companyname like '[mn]%'
group by companyname
having count(*) between 1 and 3

--CONSULTA CON EL NOMBRE DEL CLIENTE, TOTAL DE ORDENES REALIZADAS E IMPORTE TOTAL DE VENTAS
--MOSTRAR SOLO LOS CLIENTES CON UN IMPORTE MAYOR A 10,000
select orderid,nomcliente , productname, quantity, unitprice
from vw_orderdetails
order by 

select nomcliente ,mal=count(*), correcto=count (distintic orderid), imp=sum(quantity*unitprice)
from vw_orderdetails
group by nomcliente
having sum=(quantity*unitprice)>10000

--CONSULTA CON EL NOMBRE DEL CLIENTE, EL IMPORTE TOTAL DE VENTAS,
--IMPORTE DE 1996, IMPORTE 1997 E IMPORTE 1998
select nomcliente, tota=sum(quantity*unitprice)
from vw_orderdetails
group by nomcliente

--ESTRUCTURA DE CASE WHEN
case when condicion then "verdadero" else "falso" end

case when condicion then "verdadero" else "falso" end

select nomcliente
total=sum(quantity*unitprice)
total96= sun(case when year (orderdate)=1996 then quantity*unitprice else 0 end),
total97= sun(case when year (orderdate)=1997 then quantity*unitprice else 0 end),
total98= sun(case when year (orderdate)=1998 then quantity*unitprice else 0 end)
from vw_orderdetails
group by nomcliente

select*from costumers 

--LA CONSULTA ANTERIOR NO MUESTRA TOODS LOS CLIENTES, MODIFICAR LA CONSULTA PARA QUE LOS MUESTRE
select c.companyname, importetotal=isnull(sum(quantity*unitprice),0),
importe96= sun(case when year (orderdate)=1996 then quantity*unitprice else 0 end),
importe97= sun(case when year (orderdate)=1997 then quantity*unitprice else 0 end),
importe98= sun(case when year (orderdate)=1998 then quantity*unitprice else 0 end)
from vw_orderdetails d
right outer join Customers c on c.customerid= d.costumerid
group by companyname

--CONSULTA CON EL NOMBRE DEL CLIENTE, EL IMPORTE TOTAL DE VENTAS,
--IMPORTE DE 1996, IMPORTE 1997 E IMPORTE 1998
--METODO 2 CON VISTA
create view vw_cte96 as
select nomcliente, T96=sum (quantity*unitprice)
from vw_orderdetails
where year (orderdate)=1996
group by nomcliente
go
create view vw_cte97 as
select nomcliente, T97=sum (quantity*unitprice)
from vw_orderdetails
where year (orderdate)=1997
group by nomcliente
go
create view vw_cte98 as
select nomcliente, T98=sum (quantity*unitprice)
from vw_orderdetails
where year (orderdate)=1998
group by nomcliente
go
select*from cw_cte98
--NO MUESTRA TOODS LOS CLIENTES
select A.nomcliente, A.T96, B.T97, C.T98
from vw_cte96 A
inner join vw_cte97 B on B.nomcliente= A.companyname
inner join vw_cte98 C on C.nomcliente= A.companyname

--MUESTRA TODOS LOS CLIENTES
select C.companyname,Isnull(A.T96,0), ISNULL(B.T97,0), ISNULL(D.T98,0)
from customers c
Left outer join vw_cte96 A on A.nomcliente= c.companyname 
Left outer join vw_cte97 B on B.nomcliente= c.companyname 
Left outer join vw_cte98 D on D.nomcliente= c.companyname 

--CONSULTA CON EL NOMBRE DE PRODUCTO, TOTAL DE PIEZAS VENDIDAS E IMPORTE DE VENTA
--MOSTRAR SOLO LOS PRODUCTOS QUE TENGAN UN IMPORTE MENOR DE A 300
select orderid, nomcliente, productname, quantity, unitprice
from vw_orderdetails
group by productname
having sum(quantity*unitprice)<3000

--NOMBRE DEL EMPLEADO, TOTAL DE CLIENTES ATENDIDOS, TOTAL DE ORDENES REALIZADAS E IMPORTE DE VENTA
select orderid, firstname, lastname, customerid, nomcliente, productname, quantity, unitprice
from vw_orderdetails
order by FirstName

select firstname, lastname, clientes=count(distinct customerid), ordenes=count(distinct orderid),
importe=sum (quantity*unitprice)
from vw_orderdetails
group by firstname lastname
