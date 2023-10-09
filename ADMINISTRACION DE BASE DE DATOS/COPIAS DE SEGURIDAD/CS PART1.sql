--VERIFICAR QUE OPCION DE USUARIO TIENE LA BD
sp_helpdb Northwind

--HACEMOS QUE LA BD ESTE EN MODO DE UN SOLO USUARIO 2008
exec sp_dboption 'Northwind', 'single user', 'TRUE'

--CAMBIOS PARA 2012
ALTER DATABASE Northwind SET SINGLE_USER

--GENERAMOS LA COMPROBACION DE LA BD
dbcc checkDB (Northwind, repair_rebuild)

--VOLVER HACE LA BD MULTISUSUARIO
--PARA 2008
exec sp_dboption 'Northwind', 'single user', 'FALSE'

--CAMBIO PARA 2012
ALTER DATABASE Northwind SET MULTI_USER

sp_who

kill 57

