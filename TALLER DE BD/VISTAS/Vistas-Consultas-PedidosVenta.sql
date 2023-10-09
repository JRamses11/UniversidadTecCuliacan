USE PedidosVenta

--NOMBRE                        TABLAS UTILIZADAS
-----------------------------------------------------------
--vw_Clientes                      Clientes, Estados, Pais
--vw_Pedidos                       vw_Clientes, Empleados
------------------------------------------------------------
CREATE VIEW vw_Clientes AS
SELECT
c.cliid, c.clnombre, c.clapellidos, c.clrfc, c.cldomicilio,
e.edoid, e.estnombre, e.estarea,
pa.paisid, pa.panombre

FROM Clientes c
inner join Estados e on c.edoid= e.edoid and c.paisid= e.paisid
inner join Pais pa on c.paisid= pa.paisid
GO
SELECT*FROM vw_Clientes
GO
CREATE VIEW vw_Pedidos AS
SELECT
p.folio, p.pedfecha, p.pedimporte,
c.*,
em.empid, em.emnombre, em.emapellidos, em.emcelular, em.jefeid

FROM Pedidos p
inner join vw_Clientes c on p.cliid= c.cliid 
inner join Empleados em on p.empid= em.empid
GO 
SELECT*FROM vw_Pedidos

------------------------CONSULTAS
--1.- NOMBRE DEL PAIS Y TOTAL DE ESTADOS QUE CONTIENE.
SELECT Paises=panombre, TotalEstados=COUNT(distinct edoid)
FROM vw_Clientes
group by panombre

--2.- NOMBRE DEL ESTADO, TOTAL DE PEDIDOS REALIZADOS E IMPORTACIÓN TOTAL.
SELECT Estado=estnombre, TotalPedidos=COUNT(distinct folio), ImporteTotal=SUM(pedimporte)
FROM vw_Pedidos
group by estnombre

--3.- AÑO, TOTAL DE PEDIDOS REALIZADOS E IMPORTACIÓN TOTAL.
SELECT AñoPedido=year(pedfecha), TotalPedidos=COUNT(distinct folio), ImporteTotal=SUM(pedimporte)
FROM vw_Pedidos
group by pedfecha

--4.- MES Y TOTAL DE PEDIDOS REALIZADOS. MOSTRAR TODOS LOS MESES, SI NO TIENE PEDIDOS, MOSTAR EN CERO.
create table meses(
ClaveMes int not null,
NombreMes nvarchar(50) not null
)
INSERT INTO meses VALUES (1,'Enero')
INSERT INTO meses VALUES (2,'Febrero')
INSERT INTO meses VALUES (3,'Marzo')
INSERT INTO meses VALUES (4,'Abril')
INSERT INTO meses VALUES (5,'Mayo')
INSERT INTO meses VALUES (6,'Junio')
INSERT INTO meses VALUES (7,'Julio')
INSERT INTO meses VALUES (8,'Agosto')
INSERT INTO meses VALUES (9,'Septiembre')
INSERT INTO meses VALUES (10,'Octubre')
INSERT INTO meses VALUES (11,'Noviembre')
INSERT INTO meses VALUES (12,'Diciembre')
select meses.NombreMes, total=count(distinct Folio)
from vw_pedidos right outer join meses on meses.ClaveMes=DATEPART(MM,vw_Pedidos.pedfecha)
group by meses.ClaveMes,meses.NombreMes 
order by meses.ClaveMes asc

--5.- NOMBRE DEL EMPLEADO, TOTAL DE PEDIDOS REALIZADOS E IMPORTACIÓN TOTAL.
SELECT Empleado=emnombre, TotalPedidos=COUNT(distinct folio), ImporteTotal=SUM(pedimporte)
FROM vw_Pedidos
group by emnombre

--6.- NOMBRE DEL CLIENTE, TOTAL DE PEDIDOS REALIZADOS E IMPORTACIÓN TOTAL. 
SELECT Cliente=clnombre, TotalPedidos=COUNT(distinct folio), ImporteTotal=SUM(pedimporte)
FROM vw_Pedidos
group by clnombre

--7.- NOMBRE DEL ESTADO Y TOTAL DE PEDIDOS REALIZADOS POR MES DEL AÑO 2020. POR
SELECT Estado=estnombre,
ENERO=SUM(CASE WHEN DATEPART (mm,pedfecha)=1 THEN 1 ELSE 0 END),
FEBRERO =SUM(CASE WHEN DATEPART (mm,pedfecha)=2 THEN 1 ELSE 0 END),
MARZO=SUM(CASE WHEN DATEPART (mm,pedfecha)=3 THEN 1 ELSE 0 END),
ABRIL=SUM(CASE WHEN DATEPART (mm,pedfecha)=4 THEN 1 ELSE 0 END),
MAYO=SUM(CASE WHEN DATEPART (mm,pedfecha)=5 THEN 1 ELSE 0 END),
JUNIO=SUM(CASE WHEN DATEPART (mm,pedfecha)=6 THEN 1 ELSE 0 END),
JULIO=SUM(CASE WHEN DATEPART (mm,pedfecha)=7 THEN 1 ELSE 0 END),
AGOSTO=SUM(CASE WHEN DATEPART (mm,pedfecha)=8 THEN 1 ELSE 0 END),
SEPTIEMBRE=SUM(CASE WHEN DATEPART (mm,pedfecha)=9 THEN 1 ELSE 0 END),
OCTUBRE=SUM(CASE WHEN DATEPART (mm,pedfecha)=10 THEN 1 ELSE 0 END),
NOVIEMBRE =SUM(CASE WHEN DATEPART (mm,pedfecha)=11 THEN 1 ELSE 0 END),
DICIEMBRE=SUM(CASE WHEN DATEPART (mm,pedfecha)=12 THEN 1 ELSE 0 END)
FROM vw_Pedidos
WHERE DATEPART (yy,pedfecha)=2022
group by estnombre, YEAR (pedfecha)

--8.- AÑO, Y TOTAL DE PEDIDOS REALIZADOS POR DIA DE LA SEMANA.
SELECT AñoPedido=year(pedfecha),
LUNES=SUM(CASE WHEN DATEPART (dw,pedfecha)=1 THEN 1 ELSE 0 END),
MARTES=SUM(CASE WHEN DATEPART (dw,pedfecha)=2 THEN 1 ELSE 0 END),
MIERCOLES=SUM(CASE WHEN DATEPART (dw,pedfecha)=3 THEN 1 ELSE 0 END),
JUEVES=SUM(CASE WHEN DATEPART (dw,pedfecha)=4 THEN 1 ELSE 0 END),
VIERNES=SUM(CASE WHEN DATEPART (dw,pedfecha)=5 THEN 1 ELSE 0 END),
SABADO=SUM(CASE WHEN DATEPART (dw,pedfecha)=6 THEN 1 ELSE 0 END),
DOMINGO=SUM(CASE WHEN DATEPART (dw,pedfecha)=7 THEN 1 ELSE 0 END)
FROM vw_Pedidos
group by year(pedfecha)

--9.- AÑO Y TOTAL DE PEDIDOS REALIZADOS POR ESTADO.
SELECT AñoPedido=year(pedfecha),
Sinaloa=SUM(CASE WHEN e.estnombre='Sinaloa' THEN 1 ELSE 0 END),
Sonora=SUM(CASE WHEN e.estnombre='Sonora' THEN 1 ELSE 0 END),
LosAngeles=SUM(CASE WHEN e.estnombre='Los angeles' THEN 1 ELSE 0 END),
Texas=SUM(CASE WHEN e.estnombre='Texas' THEN 1 ELSE 0 END),
Toronto=SUM(CASE WHEN e.estnombre='Toronto' THEN 1 ELSE 0 END)
FROM vw_Pedidos p inner join Estados e on p.edoid=e.edoid
group by year(pedfecha)

-- 10.- NOMBRE DEL PAIS, TOTAL DE ESTADOS QUE CONTIENE, TOTAL DE CLIENTES QUE CONTIENE.
SELECT Paises=panombre, TotalEstados=COUNT(distinct edoid), TotalClientes=COUNT(distinct cliid)
FROM vw_Clientes
group by panombre