sp_helpdb NorthwindNew
--ES NECESARIO EL RECOVERY SEA SIMPLE PARA QUE NO MARQUE ERROR EL RESTORE
ALTER DATABASE NorthwindNew SET RECOVERY SIMPLE

--1.CREAR UN DISPOSITIVO
sp_addumpdevice 'DISK', 'RESPALDONW',
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\RESPNORTHWINDNEW.bak'

--VERIFICA LA BASE DE DATOS
dbcc checkDB('NorthwindNew')

--3-SE REALIZA LA CS COMPLETA DE LA BD NORTHWINDNEW
BACKUP DATABASE NorthwindNew to RESPALDONW
with Format, Init, Name='CSC', description='CSC 1 NorthwindNew'

--REALIZAR CAMBIO EN LA BD
use NorthwindNew
select*into categoriesCS from Categories

--4.REALIZAR LA CS DIFERENCIAL EN EL DISPOSITIVO
BACKUP DATABASE NorthwindNew to RESPALDONW
with Differential, NoFormat, NoInit, Name='CSD1', description='CSC 1 NorthwindNew'

--REALIZAR CAMBIO EN LA BD
select*into TablaNuevaProd from Products

--5. REALIZAR LA CS DIFERENCIAL EN EL DISPOSITIVO
BACKUP DATABASE NorthwindNew to RESPALDONW
with Differential, NoFormat, NoInit, Name='CSD2', description='CSD2 1 NorthwindNew'