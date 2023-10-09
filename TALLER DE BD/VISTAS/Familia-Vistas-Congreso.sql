use CONGRESO

--NOMBRE                           TABLAS UTILIZADAS
----------------------------------------------------------------------------------
--vw_eventos                       eventos, expositores
--vw_estudiantes                   estudiantes, escuelas, municipios
--vw_registros                     registros, congresos, vw_estudiantes
--vw_EventosxReg                   eventosxreg, vw_eventos, vw_registros
----------------------------------------------------------------------------------
--VISTA EVENTOS
create view vw_eventos as
select
e.evecosto, e.evedescripcion, e.evefecha, e.eveid, e.evelugar, e.evenombre,

ex.expapellidos, ex.expcelular, ex.expcorreo, ex.expid, ex.expnombre 

from eventos e
inner join expositores ex on e.expid= ex.expid
go
select*from vw_eventos 
--VISTA ESTUDIANTES
create view vw_estudiantes as
select
e.estapellidos, e.estcelular, e.estcorreo, e.estdomicilio, e.estid, e.estnombre,

esc.escdomicilio, esc.escid, esc.escnombre,

m.munid, m.munnombre

from estudiantes e
inner join escuelas esc on e.escid= esc.escid 
inner join municipios m on esc.munid= esc.munid
go
select*from vw_estudiantes
--VISTA REGISTRO
create view vw_registros as
select
r.fecha, r.folio, e.*,

c.condescripcion, c.confechaini, c.confechafin, c.conid, c.conlugar, c.connombre 

from registro r
inner join congreso c on r.conid= c.conid
inner join vw_estudiantes e on r.estid= e.estid
go 
select*from vw_registros
--VISTA EVENTOSXREG
create view vw_EventosxReg as
select

from eventosxreg exr
inner join eventos e on exr.eveid= e.eveid
inner join registro r on exr.folio= r.folio
go
select*from vw_EventosxReg