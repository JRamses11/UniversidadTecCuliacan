--PROGRAMACION CON TRANSACT-SQL

--DECLARACION DE VARIABLE
declare @nom_variable tipo_dato

--TIPO_DATO: SON TIPOS DE DATOS VALIDO EN SQL SERVER:
bit, int, numeric, char, varchar, datetime, etc.

--ASIGNACION DE VARIABLE
select @nom_variable= valor;
set @nom_variable= valor;

--LOS VALORES DE CADENA DE CARACTERES Y FECHA LLEVAN COMILLAS PARA SU ASIGNACION
select @nacimiento='01/01-2007'
select @nombre='Juan Perez'

--LOS VALORES NUMERICOS NUMERICOS SE ASIGNAN DE MANERA NORMAL
select @x=12.1

--IMPRESION
print @nom_variable
select @nom_variable

--EJEMPLO
declare @total numeric (7,3)--> -+9999.999
select @total
select @total=9999.999
select @total
select @total=count(*) from Empleados
select @total
go