USE Northwind

--RESTRICCIONES DE LA VISTA
--1. DEBE ESPECIFICAE EN UNA VISTA LOS NOMBRES DE TODAS LAS COLUMNAS DERIVADAS
--ADEMAS DE LOS NOMBRES DE LAS COLUMNAS NO SE DEBEN REPETIR
create view vw_productoprecio as
select productname, Precio=unitprice*1.4 from products
go

--2. LAS INSTRUCCIONES CREATE VIEW NO PUEDEN COMBINARSE CON OTRA 
--INSTRUCCION EN SQL EN UN LOTE. UN LOTE ES UN CONJUNTO DE INSTRUCCIONES
--SEPARADAS POR LA PALABRA GO
create view vw_productos2 as
select*from products 
go
create view vw_productos3 as
select*from products
go

--3. TODOS LOS OBJETOS DE BD A LOS QUE HAGA REFERENCIA EN LA VISTA 
--SE VERIFICA AL MOMENTO DE CREARLA
--MARCA ERROR, EL CAMPO GASTOS NO EXISTE EN LA TABLA PRODUCTOS
create view vw_productos4 as
select gastos from products
go

--4. NO SE PUEDEN INCLUIR LAS CLAUSULAS ORDER BY EN LA INSTRUCCION SELECT
--DENTRO DE UNA VISTA
create view vw_productos6 as
select*from products
order by productname 
go
--SE ORDENA HASTA QUE SE EJECUTA LA VISTA
select*from vw_productos6
order by productname 

--5. SI SE ELIMINAN OBJETOS A LOS QUE SE HACE REFERENCIA DENTRO DE UNA VISTA 
--LA VISTA PERMANECE, LA SIGUIENTE VEZ QUE INTENTA USAR ESA VISTA RECIBIRA
--UN MENSAJE DE ERROR
create view vw_productos7 as
select*from vw_productos6
go
drop view vw_productos6
--LA VISTA 7 YA NO SE EJECUTA, LA VISTA 6 FUE ELIMINADA PREVIAMENTE
select*from vw_productos7 order by productid

--6. NO SE PUEDE HACER REFERENCIA A TABLAS TEMPORALES EN UNA VISTA
--TAMPOCO PUEDE UTILIZAR LA CLAUSULA SELECT INTO DENTRO DE LA VISTA
--TABLA TEMPORAL
create table #local (col1 int, col2 int)
--TABLA TEMPORAL GLOBAL
create table ##global (col1 int, col2 int)

select*from #local
select*from ##global
go
--MARCA ERROR 
create view vw_products5 as
select*from #local
go
--SELECT INTO, COPIA LA ESTRUCTURA DE UNA TABLA Y LA LLENA DE DATOS
select*
INTO CopiaProd
from products
go
select*from CopiaProd
 
drop table CopiaProd
go
--MARCA ERROR
create view vw_products5 as
select*
into tabla4
from products
go

--7. SI LA VISTA EMPLEA EL ASTERISCO * EN LA INSTRUCCION SELECT Y
--LA TABLA BASE A LA QUE HACE REFERENCIA SE LE AGREGAN NUEVAS COLUMNAS,
--ESTAS NO SE MOSTRARAN EN LA VISTA
create table tabla1(col1 int, col2 int)
go
create view vw_tablaA as
select*from tabla1
go
alter table tabla1 add col3 int
go
select*from vw_tablaA
--ES NECESARIO UTILIZAR EL COMANDO ALTER VIEW PARA ACTUALIZAR LOS CAMPOS EN LA VISTA
alter view vw_tablaA as
select*from tabla1
go
--AL ELIMINAR UNA COLUMNA DE TABLA1, LA VISTA MARCARA ERROR AL EJECUTARSE
alter table tabla1 drop column col1
--MARCA ERROR
select*from vw_tablaA
--SE CORRIGE EJECUTANDO ALTER VIEW

--8.SI CREA UNA VISTA HIJA CON BASE EN UNA VISTA PADRE, DEBE TOMAR PRESENTE LO
--QUE ESTA HACIENDO LA VISTA PADRE

--9. LOS DATOS DE LAS VISTAS NO SE ALMACENAN POR SEPARADO, SI CAMBIA UN DATO EN
--UNA VISTA, ESTA MODIFICANDO EL DATO EN LA TABLA BASE
create view vw_productos as
select*from products
go
update vw_productos set unitprice+10 
where productid=1
select*from Products where productid=1

--10. EN UNA VISTA NO PUEDE HACER REFERENCIA A MAS DE 1024 COLUMNAS

--11. EN UNA VISTA NO PUEDE CREAR INDICES, NI DESENCADENADORES (TIGGERS)