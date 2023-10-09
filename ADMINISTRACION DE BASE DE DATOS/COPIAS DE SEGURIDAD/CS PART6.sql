--EJERCICIO DE RESTAURACION
--RESTAURACION LAS 2 PRIMERAS COPIAS DE SEGURIDAD
restore labelonly from respaldonw

--AQUI VERIFICAMOS NOMBRE DB, TIPO DE CS Y LA POSICION
restore headeronly from respaldonw

--VERIFICAR CADA CS DEL DISPOSITIVO
restore verifyonly from respaldonw with file=1
restore verifyonly from respaldonw with file=3
restore verifyonly from respaldonw with file=4

--CASO 1 
--REALIZAR LA RESTAURACION DE LA CSC
use master
restore database NorthwindNew from respaldonw with file=1, recovery --,replace

--NO EXISTEN LAS TABLAS
use NorthwindNew
select*from categoriesCS
select*from TablaNuevaProd

--CASO 2
--REALIZAR LA RESTAURACION DE LA CSC Y DEJARALA PREPARADA PARA AGREGAR LA CSD
use master
restore database NorthwindNew from respaldonw with file=1, norecovery--,replace
--REALIZAR LA RESTAURACION DE LA CSD Y DEJARLA EN OPERACION
restore database NorthwindNew from respaldonw with file=3, recovery

--SI EXISTE
Use NorthwindNew
select*from categoriesCS
--NO EXISTE
select*from TablaNuevaProd 

--CASO 3
--REALIZAR LA RESTAURACION DE LA CSC Y DEJARALA PREPARADA PARA AGREGAR LA CSD
use master
restore database NorthwindNew from respaldonw with file=1, norecovery--,replace
--REALIZAR LA RESTAURACION DE LA CSD Y DEJARLA EN OPERACION
restore database NorthwindNew from respaldonw with file=4, recovery

--SI EXISTE
Use NorthwindNew
select*from categoriesCS
--SI EXISTE
select*from TablaNuevaProd 



