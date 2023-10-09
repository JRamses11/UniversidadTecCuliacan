--1.RESTAURACION CSC Y CSD EN UNA NUEVA BD

--DEJAR LA BD CON RECOVERY SIMPLE PARA QUE NO OCURRA NADA CON EL RESGISTRO DE TRANSACCIONES
ALTER DATABASE NorthwindNew SET RECOVERY SIMPLE

--1.CREAR EL DISPOSITIVO 
sp_addumpdevice 'disk', respaldoNW2,
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\respaldoNW2.bak'

--2.VERIFICAR LA BD
dbcc checkdb (NorthwindNew)

--3.REALIZAR LA CSC DE LA BD
backup database NorthwindNew to respaldoNW2
with init, format, description='CSC DE LA BD NORTHWINDNEW'

--MODIFICAR LA BD
USE NorthwindNew
select*into ProductosCopia from products

--REALIZAR LA CSD DE LA BD
backup database NorthwindNew to respaldoNW2
with differential, noinit, noformat, description='CSD DE LA BD NORTHWINDNEW'

--RESTAURACION
--CREAR LA BD DONDE SE LEVANTARA DE LA BD NORTHWINDNEW
create database pruebaNW
on (name= pruebaNW,
filename='C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pruebaNW.mdf')
log on (name=pruebaNW_log,
filename='C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pruebaNW_log.ldf')

--1.LOCALIZACION DEL CONJUNTO DE CS ADECUADO
restore headeronly from respaldonw2
restore filelistonly from respaldonw2 with file=1
restore filelistonly from respaldonw2 with file=2

--RESTAURACION LA CSC
restore database pruebaNW from respaldonw2 with
move 'NorthwindNew' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pruebaNW.mdf',
move 'NorthwindNew_log' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\pruebaNW_log.ldf',
file=1, replace, norecovery

--RESTAURA LA CSD
restore database pruebaNW from respaldoNW2 with
file=2, replace, recovery

--VERIFICACION
use pruebaNW
select*from ProductosCopia
select*from orders






