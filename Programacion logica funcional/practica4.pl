/*EJERCICIO 1:
Sobre líquidos venenosos

El Sr. Ido, el químico, tiene seis frascos llenos de líquidos coloreados. Hay uno de cada color: rojo, anaranjado, amarillo, verde, azul y violeta. El señor Ido sabe que algunos de esos líquidos son tóxicos, pero no recuerda cuales...

Sin embargo, sí recuerda algunos datos. En cada uno de los siguientes pares de frascos hay uno con veneno y otro no:

a) los frascos violeta y azul
b) los frascos rojo y amarillo
c) los frascos azul y anaranjado

El Sr. Ido recuerda también que en estos otros pares de frascos hay uno sin veneno:

d) el violeta y el amarillo
e) el rojo y el anaranjado
f) el verde y el azul

¡Ah! Casi lo olvido, añade el Sr. Ido, el líquido del frasco rojo no es venenoso. 

¿Qué frascos tienen veneno?
*/

/*EJERCICIO 2:
Encuentra la ocupación de cada mujer:

(a) Clara es violentamente alérgica a las plantas.
(b) Luisa y la florista comparten el departamento
(c) A María y Luisa les gusta solamente la música rock
(d) La jardinera, la diseñadora de modas y Nélida no se conocen entre sí.
e) una mujer no puede tener una ocupación que esté relacionada con algo a lo que es alérgica:
f) cada mujer tiene un solo trabajo, y  cada trabajo es ocupado por una sola mujer las cuatro mujeres elegidas y las cuatro ocupaciones  deben ser diferentes entre sí.

  	?- respuesta(X).
	X=[[clara,diseñadora],[luisa,jardinera],
	   [maria,florista],[nelida,directora_de_orquesta]]
	Yes
*/

/*EJERCICIO 3:
ALUMNO DESPISTADO:

”Un alumno de ISC del ITC, debido al nerviosismo del primer día de clase, 
ha anotado el nombre de sus profesores (Elisa, Fernando y Carlos), las 
asignaturas que se imparten (Lógica, Programación y Matemáticas) y el día
de la semana de las distintas clases (lunes, miércoles y viernes), pero 
sólo recuerda que:

- La clase de Programación, impartida por Elisa, es posterior a la de Lógica
- A Carlos no le gusta trabajar los lunes, día en el que no se imparte Lógica

Ayúdale a relacionar cada profesor con su asignatura, así como el día de la 
semana que se imparte

(Sabemos que cada profesor imparte una única asignatura y que las clases se dan 
en días diferentes)”
*/
profesor(elisa).
profesor(fernando).
profesor(carlos).

asignatura(logica).
asignatura(programacion).
asignatura(matematicas).

dia(lunes).
dia(miercoles).
dia(viernes).

%imparte(Materia, Maestro)
imparte(programacion, elisa).
imparte(Materia, Maestro):- asignatura(Materia), profesor(Maestro), 
    Materia\=programacion, Maestro\=elisa.

%trabaja(Maestro, Dia)
trabaja(carlos, Dia):- dia(Dia), Dia\=lunes.
trabaja(Maestro, Dia):-profesor(Maestro), dia(Dia), Maestro\=carlos.

%horario(Materia, Dia)
horario(logica, Dia):- dia(Dia), Dia \=lunes.
horario(Materia, Dia):- asignatura(Materia), dia(Dia), Materia\=logica.

respuesta([Profe1, Materia1, Dia1], 
          [Profe2, Materia2, Dia2],
          [Profe3, Materia3, Dia3]):-
    profesor(Profe1), profesor(Profe2), profesor(Profe3),
    asignatura(Materia1), asignatura(Materia2), asignatura(Materia3),
    dia(Dia1), dia(Dia2), dia(Dia3),
    diferentes(Profe1, Profe2, Profe3),
    diferentes(Materia1, Materia2, Materia3),
    diferentes(Dia1, Dia2, Dia3),
    imparte(Materia1, Profe1), imparte(Materia2, Profe2), imparte(Materia3, Profe3),
    trabaja(Profe1, Dia1), trabaja(Profe2, Dia2), trabaja(Profe3, Dia3),
    horario(Materia1, Dia1), horario(Materia2, Dia2), horario(Materia3, Dia3).

diferentes(A,B,C):- A\=B, A\=C, B\=C.
    
    











