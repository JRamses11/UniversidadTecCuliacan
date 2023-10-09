sp_helpdb Northwind
--ES NECESARIO QUE EL RECOVERY SEA SIMPLE PARA QUE NO MARQUE ERROR AL RESTORE
ALTER DATABASE Northwind SET RECOVERY SIMPLE

--1. CREAR UN DISPOSITIVO  -sp_dropdevice RESPALDONW
sp_addumpdevice 'DISK', 'RESPALDONW'
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\RESPNORTHWIND.bak'

--2.VERIFICA LA BASE DE DATOS
dbcc checkDB ('Northwind')

--3. SE REALIZA LA CS COMPLETA DE LA BD Northwind
BACKUP DATABASE Northwind to RESPALDONW
with Format, Init, Name='CSC', description='CSC 1 Northwind'

--REALIZAR CAMBIO EN LA BD
use Northwind
select*into categoriasCS from Categories

--4.REALIZAR LA CS DIFERENCIAL EN EL DISPOSITIVO
BACKUP DATABASE Northwind to RESPALDONW
with Differential, NoFormat, NoInit, NAME='CSD 1', description='CSD 1 Northwind'

--REALIZAR CAMBIO EN LA BD
select*into TablaNuevaProd from Products

--5.REALIZAR LA CS DIFERENCIAL EN EL DISPOSITIVO
BACKUP DATABASE Northwind to RESPALDONW
with Differential, NoFormat, NoInit, Name='CSD 2', description='CSD 2 Northwind'

--6.VERIFICACION DEL CONTENIDO DEL RESPALDO
restore headronly from respaldonw