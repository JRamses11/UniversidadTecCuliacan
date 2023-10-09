--1.CREAR EL DISPOSITIVO sp_dropdevice NWMOVE
sp_addumpdevice 'disk', NWMOVE,
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\NWMOVE.BAK'

--CREAMOS LA CSC
backup database NorthwindNew to NWMOVE
with init, format, description='CSC DE LA BD NORTHWIND'

--2. RESTAURACION 
--OBTENEMOS EL NOMBRE LOGICO Y FISICO DE LOS ARCHIVOS DE LA BASE DE DATOS
RESTORE FILELISTONLY FROM NWMOVE;
--BUSCAMOS EL TIPO DE CS, LA POSICION Y EL NOMBRE DE LA BASE DE DATOS
RESTORE HEADERONLY FROM NWMOVE;

--RESTAURAMOS LA CS CON OTRO NOMBRE
RESTORE DATABASE NWCopia from NWMOVE
with file=1,
MOVE 'NorthwindNew' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWCopia.mdf',
MOVE 'NorthwindNew_log' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWCopia.log';
GO
sp_helpdb NWCopia

--VERIFICAMOS QUE SEA LA COPIA DE LA BD DE NORTHWIND
use NWCopia
select*from Orders
select*from [Order Details]

--OPCION 2
--REALIZAR UNA RESTAURACION DE UNA BD YA EXISTENTE
--1.CREAR EL DISPOSITIVO sp_dropdevice NWRESPALDO
sp_addumpdevice 'disk', NWRESPALDO, 
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\Backup\NWRESPALDO.BAK'
--CREAMOS LA CS COMPLETA
backup database NorthwindNew to NWRESPALDO
with init, format, description= 'CSC DE LA BD NORTHWINDNEW'

--CREAMOS LA BASE DE DATOS NUEVA
create database NWNueva
on (Name= NWNueva,
filename='C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWNueva.mdf')
log on (Name= NWNueva_log,
filename= 'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWNueva_log.ldf')

--OBTENEMOS EL NOMBRE LOGICO Y FISICO DE LOS ARCHIVO DE BASE DE DATOS
RESTORE FILELISTONLY FROM NWRESPALDO;

--RESTAURA LA CSC EN LA NUEVA BASE DE DATOS
restore database NWNueva from NWRESPALDO with
file=1,
move 'NorthwindNew' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWNueva.mdf',
move 'NorthwindNew_log' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\NWNueva_log.ldf',
replace

sp_helpdb NWNueva

--VERIFICAMOS LA COPIA
use NWNueva
select*from Orders

--OPCION 3
--RESTAURAR EL ARCHIVO BAK
--BAJAR EL ARCHIVO DE MOODLE :d
