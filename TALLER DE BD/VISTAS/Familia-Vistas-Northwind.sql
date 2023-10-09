use Northwind
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
select*from vw_products
--VISTA ORDERS
create view vw_orders as
select
o.orderid, o.orderdate,o.requireddate , o.shippeddate, 
o.freight , o.shipname,o.shipaddress,o.shipcity,o.shipregion,o.shippostalcode,o.shipcountry,

e.employeeid , e.lastname, e.firstname, e.title , e.titleofcourtesy ,e.birthdate ,e.hiredate , employeedaddress = e.address,
e.city,employeedregion = e.region , employeedpostalcode =  e.postalcode, employeedcountry = e.country , e.homephone , e.extension,
e.photo,e.notes,e.reportsto , e.photopath,

s.shipperid, s.companyname , shipperphone = s.phone,

c.customerid , customerscompanyname = c.companyname, nomcliente=c.contactname, c. contacttitle , customersaddress = c.address , 
customerscity=c.city , customersregion = c.region ,
customerspostalcode =c.postalcode , customerscountry = c.country , c.phone ,c.fax

from orders o
inner join employees e on o.employeeid = e.employeeid
inner join shippers s on  o.shipvia = s.shipperid
inner join customers c on o.customerid = c.customerid
go
select*from vw_orders
--VISTA ORDERDETAILS
create view vw_orderdetails as
select
od.unitprice, od.quantity, od.discount, p.*, o.*
from [order details] od
inner join vw_products p on od.productid= p.productid
inner join vw_orders o on o.orderid= od.orderid
go
select*from vw_orderdetails

--VISTA TERRITORIES
create view vw_territories as
select
t. territoryid , t.territorydescription ,

r.regionid , r.regiondescription

from territories t
inner join region r on t.regionid = r.regionid
select*from vw_territories
go
select*from vw_territories
--VISTA EMPLOYEETERRITORIES
create view vw_employeeterritories as
select 

t.territoryid, t.territorydescription ,

e.employeeid , e.lastname, e.firstname, e.title , e.titleofcourtesy ,e.birthdate ,e.hiredate , employeedaddress = e.address,
e.city,employeedregion = e.region , employeedpostalcode =  e.postalcode, employeedcountry = e.country , e.homephone , e.extension,
e.photo,e.notes,e.reportsto , e.photopath

from employeeterritories et
inner join employees e on  e.employeeid = et.employeeid
inner join territories t on  t.territoryid = et.territoryid
go
select*from vw_employeeterritories