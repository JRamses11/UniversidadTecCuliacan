--1.VERIFICACION
USE NorthwindNew

--2.CREAR EL DISPOSITIVO
sp_addumpdevice 'disk', RespaldoRT,
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\respaldoRT.bak'

--ES NECESARIO QUE LA RECUPERACION SEA DE TIPO COMPLETA
--PARA QUE PUEDA REALIZAR UNA CSRT
alter database NorthwindNew set recovery full

--2.VERIFICAR LA BD
dbcc checkdb(NorthwindNew)

--3.REALIZAR LA CS DE LA BD --------5:16
backup database NorthwindNew to RespaldoRT
with init, format, name='CSC CON RT', description= 'CSC DE LA BD Northwind'

--4.MODIFICAR LA BD---------- 5:19
use NorthwindNew
select*into TABLAA1 from Products

--5. 3 MINUTOS DESPUES SE REALIZA LA SIGUIENTE MODIFICACIO----------5:21
select*into TABLAA2 from Employees

--6. 3 MINUTOS DESPUES LA SIGUIENTE MODIFICACION--------------5:24
select*into TABLAA3 from Categories

--7. REALIZAR LA COPIA DEL REGISTRO DE TRASANCCIONES---------5:27
backup log NorthwindNew to respaldoRT
with noinit, noformat, name= 'CSRT FINAL', description= 'CSRT de la bd Northwind';

--RESTAURACION
--1.BUSCAR Y VERIFICAR LA CS EN EL RESPALDO
restore headeronly from respaldoRT
restore verifyonly from respaldoRT with file=1
restore verifyonly from respaldoRT with file=2

--CASO 1
--REALIZAR LA RESTAURACION DE LA CSC Y DEJARLA PREPARADA PARA AGREGAR LA CSRT
use master
restore database NorthwindNew from respaldoRT with file=1, replace, norecovery

--REALIZAR LA RESTAURACION DE LA CSRT Y DEJARLA EN OPERACION
restore log NorthwindNew from respaldoRT with file=2, recovery,
stopat='march 08, 2023 [la hora establecida][17:16:30]'

--CASO 1 OPCION 2

--CASO 1
--REALIZAR LA RESTAURACION DE LA CSC Y DEJARLA PREPARADA PARA AGREGAR LA CSRT
use master
BACKUP LOG NorthwindNew to respaldoRT with norecovery
go
--SE REALIZA LA CSC
restore database NorthwindNew from respaldoRT with file=1, norecovery

--REALIZAR LA RESTAURACION DE LA CSRT Y DEJARLA EN OPERACION
restore log NorthwindNew from respaldoRT with file=2, recovery,
stopat='march 08, 2023 [la hora establecida][17:16:30]'
--VERIFICAR LAS TABLAS
use NorthwindNew
--SI EXISTE
select*from TABLAA1
--NO EXISTE
select*from TABLAA2
select*from TABLAA3

--CASO 2
--REALIZAR LA RESTURACION DE LA CSC Y DEJARLA PREPARADA ´PARA AGREGAR CSRT
use master
restore database NorthwindNew from respaldoRT with file=1,replace, norecovery
--REALIZAR LA RESTAURACION DE LA CSRT Y DEJARLA EN OPERACION
restore log NorthwindNew from respaldoRT with file=2, recovery,
stopat='march 08, 2023 [la hora establecida][17:16:30] pm'

--SI EXISTE
use NorthwindNew
select*from TABLAA1
select*from TABLAA2
--NO EXISTE
select*from TABLAA3

--CASO 3 
restore database NorthwindNew from respaldoRT with file=1,norecovery, replace
--REALIZAR LA RESTAURACION DE LA CSRT Y DEJARLA EN OPERACION
restore log NorthwindNew from respaldoRT with file=2, replace,recovery,
stopat='march 08, 2023 [la hora establecida][17:16:30] pm'

--SI EXISTEN
use NorthwindNew
select*from TABLAA1
select*from TABLAA2
select*from TABLAA3













