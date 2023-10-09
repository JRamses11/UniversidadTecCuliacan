sp_helpdb NorthwindNew

--ES NECESARIO TENER LA RECUPERACION COMPLETA
ALTER DATABASE NorthwindNew SET RECOVERY FULL

--1.CREAR EL DISPOSITIVO 
sp_addumpdevice 'disk', 'RESPMARCA',
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\RESPMARCA.bak'

--2.VERIFICAR LA BD
dbcc checkdb('NorthwindNew')

--3.SE REALIZAR LA CS COMPLETA DE LA BD NORTHWINDNEW
BACKUP DATABASE NorthwindNew to RESPMARCA
with format, init, name='CSC', description='CSC CON MARCA'

--SE REALIZA UNA TRANSACCION Y SE MARCA
use NorthwindNew
begin transaction ACTUALIZARPRECIOS with MARK 'ActualizarPrecios';
      update products set unitprice=30
commit transaction ACTUALIZARPRECIOS;
go

--SE REALIZA LA CSRT
backup log NorthwindNew to RESPMARCA
with noinit, noformat, name='CSRT MARCA', description='CSRT CON MARCA'

--SE REALIZA UNA TRANSACCION Y SE MARCA
use NorthwindNew
begin transaction ACTUALIZARNOMBRES with MARK 'ActualizarNombre';
      update Employees set FirstName='ANA'
commit transaction ACTUALIZARNOMBRE;
go

--SE REALIZA LA CSRT
backup log NorthwindNew to RESPMARCA
with noinit, noformat, name='CSRT MARCA NOMBRE', description='CSRT CON MARCA NOMBRE'

--1.buscar y verificar la cs en el respaldo
restore headeronly from RESPMARCA
restore verifyonly from RESPMARCA with file=1
restore verifyonly from RESPMARCA with file=2
restore verifyonly from RESPMARCA with file=3

--CASO 1 SE REALIZA LA RESTAURACION ANTES DE LA MARCA
use master
restore database NorthwindNew from RESPMARCA with file=1, replace, norecovery

--SE REALIZA LA CSRT ANTES DE LA MARCA
restore log NorthwindNew from RESPMARCA with file=2, recovery,
stopbeforemark= 'ACTUALIZARPRECIOS'

--verificar los datos los precios de la transaccion
USE NorthwindNew
SELECT*FROM products
select*from employees

--CASO 2 SE REALIZA LA RESTAURACION ANTES DE LA MARCA
use master
restore database NorthwindNew from RESPMARCA with file=1, replace, norecovery

--SE REALIZA LA CSRT ANTES DE LA MARCA
restore log NorthwindNew from RESPMARCA with file=2, recovery,
stopatmark= 'ACTUALIZARPRECIOS'

--verificar los datos los precios de la transaccion
USE NorthwindNew
SELECT*FROM products ---YA HAY MODIFICACION
select*from employees


--CASO 3 SE REALIZA LA RESTAURACION ANTES DE LA MARCA
use master
restore database NorthwindNew from RESPMARCA with file=1, replace, norecovery

--SE REALIZA LA CSRT ANTES DE LA MARCA
restore log NorthwindNew from RESPMARCA with file=2, norecovery

--SE REALIZA LA COPIA DE SEGURIDAD CRST EN LA MARCA ACTUALIZANOMBRE
restore log NorthwindNew from RESPMARCA with file=3, recovery,
stopbeforemark= 'ACTUALIZARNOMBRE'

--verificar los datos los precios de la transaccion
USE NorthwindNew
SELECT*FROM products
select*from employees






