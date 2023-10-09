--1.- RESTAURAR LA BD UTILIZANDO LOS ARCHIVOS ELECCIONES.MDF Y ELECCIONES_LOG.LDF.
create database Elecciones
on (filename= 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\ELECCIONES.MDF')
log on
(filename='C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\ELECCIONES_LOG.LDF')
FOR ATTACH;

--2.- DEL ARCHIVO RESPALDOS.BAK, REALIZAR LAS RESTAURACIONES NECESARIAS
--Y RESPONDER A LAS SIGUIENTES PREGUNTAS:
--CUANTAS BD CONTIENE Y SUS NOMBRES?
--4 base de datos: AdventureWorksLT2008, rstys, urge ,envios
--EL MODELO DE DATOS DE CADA BD.
--CUANTOS REGISTROS TIENE CADA TABLA DE CADA BD.
--DE LA BD QUE CONTIENE UNA CSC Y 2 CSD, ESPECIFICAR LAS TABLAS QUE SE CREARON DE FORMA INTERMEDIA ENTRE CADA COPIA DE SEGURIDAD.

sp_addumpdevice 'disk', respaldo,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'

RESTORE headeronly from respaldo

RESTORE DATABASE AdventureWorksLT2008
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'
WITH FILE = 1,
MOVE 'AdventureWorksLT2008_Data' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva.mdf',
MOVE 'AdventureWorksLT2008_log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva_log.ldf';

RESTORE DATABASE rstys
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'
WITH FILE = 2,
MOVE 'rstys' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\rstys.mdf',
MOVE 'rstys_log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\rstys_log.ldf';

RESTORE DATABASE urge
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'
WITH FILE = 3,
MOVE 'urge' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\urge.mdf',
MOVE 'urge_log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\urge_log.ldf';

RESTORE DATABASE envios
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'
WITH FILE = 5,
MOVE 'envios' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\envios.mdf',
MOVE 'envios_log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\envios_log.ldf';

--3.- UTILIZANDO EL ARCHIVO RESPALDOS.BAK, ENCONTRAR LA PRIMERA COPIA DE SEGURIDAD COMPLETA Y RESTAURARLA EN UNA NUEVA BASE DE DATOS.
--ENTREGAR EL CODIGO PARA LA RESTAURACION E IMPRIMIR EL MODELO DE DATOS DE LA BD QUE CONTIENE.
CREATE DATABASE nueva
ON (NAME = nueva, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva2.mdf')
LOG ON (NAME = nueva_log, FILENAME = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva2_log.ldf');

-- Restaurar la primera copia de seguridad completa en la base de datos "nueva"
RESTORE DATABASE nueva
FROM DISK = 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'
WITH FILE = 1,
MOVE 'AdventureWorksLT2008_Data' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva2.mdf',
MOVE 'AdventureWorksLT2008_Log' TO 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\nueva2_log.ldf',
REPLACE;

-- Imprimir el modelo de datos de la base de datos "nueva"
EXEC sp_helpdb 'nueva';

SELECT database_id, name, state_desc FROM sys.databases


--4.- UTILIZANDO EL ARCHIVO RESPALDOS.BAK, ENCONTRAR LA SEGUNDA COPIA DE SEGURIDAD COMPLETA 
--Y RESTAURARLA EN UNA BASE DE DATOS YA EXISTENTE LLAMADA  PRUEBA_CS  (LA BASE DE DATOS CREARLA PREVIAMENTE). 
--ENTREGAR EL CODIGO PARA LA RESTAURACION E IMPRIMIR EL MODELO DE DATOS DE LA BD QUE CONTIENE.

--1.BUSCAR Y VERIFICAR LA CS EN EL RESPALDO
restore headeronly from disk= 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak'

--CREAMOS LA BASE DE DATOS NUEVA
create database PRUEBA_CS
on (Name= PRUEBA_CS,
filename='C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\PRUEBA_CS.mdf')
log on (Name= PRUEBA_CS_log,
filename= 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\PRUEBA_CS_log.ldf')

--RESTAURA LA SEGUNDA CSC EN LA NUEVA BASE DE DATOS
restore database PRUEBA_CS from disk= 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\Respaldos.bak' with
file=2,
move 'RSTyS' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\PRUEBA_CS.mdf',
move 'RSTyS_LOG' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\PRUEBA_CS_log.ldf',
replace


--5.- REALIZAR UNA COPIA DE LA BASE DE DATOS NORTHWIND Y NOMBRARLA NWPARALELO, DE ESTA BASE DE DATOS 
--REALIZAR UNA COPIA DE SEGURIDAD COMPLETA EN PARALELO (3 DISPOSITIVOS). 
--REALIZAR LA RESTAURACION DE LA COPIA DE SEGURIDAD COMPLETA EN PARALELO ANTERIOR. INCLUYE EL CODIGO COMPLETO.
--sp_dropdevice NWCOPIA
--CREAR EL DISPOSITIVOS
sp_addumpdevice 'disk', NWCOPIA,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\NWCOPIA.bak'

--CREAMOS LA CSC
backup database Northwind to NWCOPIA
with init, format, description='CSC DE LA BD NORTHWIND'

--OBTENEMOS EL NOMBRE LOGICO Y FISICO DE LOS ARCHIVOS DE LA BASE DE DATOS
RESTORE FILELISTONLY FROM NWCOPIA;
--BUSCAMOS EL TIPO DE CS, LA POSICION Y EL NOMBRE DE LA BASE DE DATOS
RESTORE HEADERONLY FROM NWCOPIA;

--CREAMOS LA BASE DE DATOS NUEVA
create database NWPARALELO
on (Name= NWPARALELO,
filename='C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO.mdf')
log on (Name= NWPARALELO_log,
filename= 'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO_log.ldf')

--RESTAURAMOS LA CS CON OTRO NOMBRE
RESTORE DATABASE NWPARALELO from NWCOPIA
with file=1,
MOVE 'Northwind' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO.mdf',
MOVE 'Northwind_log' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO_log.ldf',
replace

--VERIFICAMOS LA COPIA
use NWPARALELO
select*from Orders

--CREAR 3 DISPOSITIVOS DE COPIA
 sp_helpdb NWPARALELO
 sp_dropdevice NWP1
 sp_dropdevice NWP2
 sp_dropdevice NWP3

--CREAR LOS DISPOSITIVOS 
sp_addumpdevice 'disk', NWP1,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\NWP1.BAK'

sp_addumpdevice 'disk', NWP2,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\NWP2.BAK'

sp_addumpdevice 'disk', NWP3,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\NWP3.BAK'

--COPIA DE SEGURIDAD EN PARALELO
backup database NWPARALELO to NWP1, NWP2, NWP3 WITH format, init, Name='CSC',
description='CSC PARALELO'

--REVISAMOS LA BD
dbcc checkdb('NWPARALELO')
sp_helpdb NWPARALELO

--BUSCAR Y VERIFICAR LA CS EN EL RESPALDO
restore headeronly from NWP1
restore headeronly from NWP2
restore headeronly from NWP3

--RESTAURAMOS LA CS CON OTRO NOMBRE
RESTORE DATABASE NWPARALELO from NWP1,NWP2,NWP3
with file=1,
MOVE 'Northwind' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO.mdf',
MOVE 'Northwind_log' to
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\DATA\NWPARALELO_log.ldf',
replace, RECOVERY

use NWPARALELO
select*from [Order Details]


/*6.- REALIZAR LA SIGUIENTE SECUENCIA DE CAMBIO DE LA BASE DE DATOS NORTHWIND:
CSC: DENTRO DE UNA TRANSACCION EXPLICITA HACERLE UNA MARCA, MODIFICAR EL NOMBRE DE LOS EMPLEADOS SIN 
PONERLE LA CLAUSULA WHERE.
CSRT: DENTRO DE UNA TRANSACCION EXPLICITA HACERLE UNA MARCA, MODIFICAR LA CANTIDAD DE PIEZAS VENDIDAS 
DE LA TABLA DETALLES DEL PEDIDO SIN PONERLE LA CLAUSULA DONDE.
*/
--
--restore database Northwind with recovery  (CASO DE BUGG)
--sp_dropdevice NorthwindMarca

--REQUERIMPS COPIA COMPLETA
ALTER DATABASE Northwind SET RECOVERY FULL

--CREAMOS DISPOSITIVO
sp_addumpdevice 'disk', NorthwindMarca,
'C:\Program Files\Microsoft SQL Server\MSSQL15.ADMINBD\MSSQL\Backup\NorthwindMarca.bak'

--REVISAMOS LA BD
dbcc checkdb('Northwind')
sp_helpdb Northwind

--SE REALIZAR LA CS COMPLETA DE LA BD NORTHWINDNEW
BACKUP DATABASE Northwind to NorthwindMarca
with format, init, name='CSC', description='CSC CON MARCA'

--SE REALIZA UNA TRANSACCION Y SE MARCA
use Northwind
begin transaction ActualizaNombre with MARK 'ActualizaNombre';
      update Employees set FirstName='Clemente'
commit transaction ActualizaNombre;

--SE REALIZA LA CSRT
backup log Northwind to NorthwindMarca
with noinit, noformat, name='CSRT MARCA', description='CSRT CON MARCA'

--SE REALIZA UNA TRANSACCION Y SE MARCA
use Northwind
begin transaction ActualizaPieza with MARK 'ActualizaPieza';
      update [Order Details] set Quantity=100
commit transaction ActualizaPieza;

--BUSCAR Y VERIFICAR LA CS EN EL RESPALDO
restore headeronly from NorthwindMarca
restore verifyonly from NorthwindMarca with file=1
restore verifyonly from NorthwindMarca with file=2

--CASO 1 REALIZA LA RESTAURACION ANTES DE LA MARCA
use master
restore database Northwind from NorthwindMarca with file=1, replace, norecovery

--SE REALIZA LA CSRT ANTES DE LA MARCA
restore log Northwind from NorthwindMarca with file=2, recovery,
stopbeforemark= 'ActualizaNombre'

--VERIFICAR LOS DATOS DE LAS TABLAS EMPLOYEES
use Northwind
select*from Employees
select*from [Order Details]

--CASO 2 SE REALIZA LA RESTAURACION DESPUES DE LA MARCA
use master
restore database Northwind from NorthwindMarca with file=1, replace, norecovery

--SE REALIZA LA CSRT ANTES DE LA MARCA
restore log Northwind from NorthwindMarca with file=2, recovery,
stopatmark= 'ActualizaPieza'

--VERIFICAR LOS DATOS DE LAS TABLAS ORDER DETAILS
use Northwind
select*from Employees
select*from [Order Details]






