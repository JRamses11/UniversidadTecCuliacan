use Northwind

----CONSULTAS SELF JOIN AUTOCOMBINACIONES
--CONSULTA EL NOMBRE DEL EMPLEADO Y EL NOMBRE DE SU JEFE
SELECT 
ClaveEmp= e.employeeid, empleado=E.firstname +''+ E.Lastname,
Clavejefe= e.reportsto, Jefe=J.firstname+''+ J.LastName
from employees J
inner join employees E on E.reportsto=J.employeeid

--MEDIANTE UNA COMBINACION EXTERNA SE PUEDE MOSTRAR TODOS LOS EMPLEADOS AUNQUE NO TENGAN JEFE
SELECT
ClaveEmp=e.employeeid, empleado=E.firstname+''+E.lastname,
ClaveJefe=e.reportsto, Jefe=J.firstname+''+J.lastname
from employees j right outer join employees e on e.reportsto=j.employeeid
from employees e left outer join employees j on e.reportsto=j.employeeid
