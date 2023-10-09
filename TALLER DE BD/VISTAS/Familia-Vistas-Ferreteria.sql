use FERRETERIA

--NOMBRE                           TABLAS UTILIZADAS
----------------------------------------------------------------------------------
--vw_clientes                     clientes, municipios, colonias
--vw_empleados                    empleados, zonas
--vw_articulos                    familias, articulos
--vw_ventas                       ventas, ferreteria, vw_empleados, vw_clientes
--vw_detalle                      detalle, vw_articulos, vw_ventas
-----------------------------------------------------------------------------------
--VISTA CLIENTES
create view vw_clientes as
select
c.cteid, c.ctenombre, c.cteapepat, c.cteapemat, c.ctecel, c.ctedom, c.cterfc, c.ctecurp, c.ctefechanacimiento, c.ctesexo,

m.munid, m.munnombre,

col.colid, col.colnombre, col.cp 

from clientes c
inner join colonia col on c.colid = col.colid 
inner join municipio m on col.munid= m.munid 
go
select*from vw_clientes

--VISTA EMPLEADO
create view vw_empleados as
select
e.empid, e.empnombre, e.empapepat, e.empapemat, e.empdomicilio, e.emptelefono, e.empcelular, e.emprfc, e.empcurp, e.empfechaingreso,
e.empfechanacimiento,

z.zonaid, z.zonanombre

from empleados e
inner join zona z on e.zonaid= z.zonaid 
go
select*from vw_empleados

--VISTA ARTICULOS
create view vw_articulos as
select
a.artdescripcion, a.artid, a.artnombre, a.artprecio, 

f.famdesc, f.famid, f.famnombre 

from articulos a
inner join familias f on a.famid= f.famid 
go
select*from vw_articulos

--VISTA VENTAS
create view vw_ventas as
select
v.fecha, v.folio, e.*, c.*,

f.ferrdomicilio, f.ferrid, f.ferrnombre, f.ferrtelefono 

from venta v
inner join ferreterias f on v.ferrid= f.ferrid 
inner join vw_empleados e on v.empid= e.empid
inner join vw_clientes c on v.cteid= c.cteid 
go
select*from vw_ventas

--VISTA DETALLE
create view vw_detalle as
select
d.folio, d.cantidad, d.precio, a.*, v.*

from detalle d
inner join vw_articulos on d.artid= a.artid
inner join vw_ventas on d.folio= v.folio
go
select*from vw_detalle
