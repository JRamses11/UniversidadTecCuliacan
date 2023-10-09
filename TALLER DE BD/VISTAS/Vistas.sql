USE Northwind

--VISTAS
--VISTA CON LA CLAVE, EL NOMBRE Y PRECIO DEL PRODUCTO 
create view vw_productos as
select productid, productname, unitprice from products 
go
--UTILIZAR LA VISTA
select*from vw_productos

--DENTRO DE COMBINACIONES 
select*
from vw_productos p
inner join [Order Details] d on d.ProductID=p.productid

--PARA LA MODIFICACION DE UN REGISTRO
update vw_productos set UnitPrice= UnitPrice +1 where ProductID=1

--SE CONSULTA LOS DATOS SOBRE LA TABLA
select productname, UnitPrice from products where ProductID=1
go

--CON ESTE PROCEDIMIENTO ALMACENADO SE VE EL CONTENIDO DE LA VISTA SI NO ESTA ENCRIPTADA
sp_helptext vw_productos

--ELEMINACION DE UNA VISTA
drop view vw_productos
go

--AHORA LA VISTA CREADA Y ENCRIPTADA
create view vw_productos with encryption as
select productid, productname, unitprice, costo=UnitPrice*0.2 from products
go

--NO SE PUEDE MOSTRAR EL CONTENIDO DE LA VISTA
sp_helptext vw_productos

