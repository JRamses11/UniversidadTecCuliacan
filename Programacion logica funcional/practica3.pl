/*
Se encontraron por la calle Einstein [al pobre hombre lo metemos 
en todos los acertijos ;-)] y un amigo. Hacía bastante tiempo 
que no se veían y Einstein le preguntó:

- ¿Tienes hijos?.
- Tengo tres hijas -respondió el amigo.
- ¿Y de qué edades? -volvió a preguntar el físico.
- Te voy a contestar con un acertijo -dijo el amigo-: 
  La multiplicación de sus edades es igual a 36, y la 
  suma de ellas es igual al número de tu portal.

Einstein se quedó pensando un momento y le contestó:
- Sí, pero me falta un dato.
- Tienes razón -replicó el amigo-. La mayor toca el piano.

Einstein lo acertó en 1 minuto. ¿Cuál es la solución?.
*/

edades(6,2,3).
edades(9,2,2).
edades(36,1,1).
edades(9,4,1).
edades(18,2,1).
edades(12,3,1).
edades(4,3,3).

edades(1,2,3).
edades(3,2,2).

portal(Num, A, B, C):- edades(A,B,C), 36 is A*B*C, Num is A+B+C.

/*
Problema: Dos cabreros se encuentran en un cruce y se produce
el siguiente diálogo:
- Dame una cabra, para que tengamos las mismas
- Mejor dame tú una a mí, para que tenga yo el doble que tú
¿Cuántas cabras tiene cada cabrero?...
Solución: existe A y B pertenece N+ tales que:
B-1 = A+1 ∧
2*(A-1) = B+1
*/
% Definición de las restricciones
restricciones(A, B) :-
    B is A + 1,          % "Dame una cabra, para que tengamos las mismas"
    2 * (A - 1) =:= B + 1.  % "Mejor dame tú una a mí, para que tenga yo el doble que tú"

% Predicado principal para encontrar las soluciones
encuentra_cabras(A, B) :-
    restricciones(A, B),  % Aplicar las restricciones
    A >= 0, B >= 0,       % Asegurar que no haya cabras negativas
    integer(A), integer(B). % Asegurar que A y B sean enteros

% Ejemplo de uso:
% ?- encuentra_cabras(A, B).
% Output: A = 3, B = 4.

/*
Crear un sistema de alertas que cuando se consume un insumo, 
chequea en la base de datos cuánta reserva queda de ese insumo 
y, si la reserva está por debajo de un mínimo, devuelve un 
mensaje diciendo que hay que comprar más de ese insumo.
*/
%producto(Nombre, Minimo, Existencia)
producto(chocolates, 5, 10).
producto(bombones,     12, 24).
producto(paletas,    10, 20).
 
venta(Nombre, Cantidad):-
    producto(Nombre, Minimo, Existencia),
    Queda is  Existencia - Cantidad,
    Queda =< Minimo,
    write("Reabastece este producto").

/* Elaborar un predicado que al Proporcionar mes y día de nacimiento,
nos diga nuestro signo zodiacal
*/
signo(aries,21, marzo,19,abril).
signo(tauro,20, abril,20,mayo).
signo(geminis,21, mayo, 20, junio).
 
signo(Mes, Dia, Signo):-
    signo(Signo, DiaIni, MesIni, DiaFin, MesFin),
    (     (Mes == MesFin, Dia =< DiaFin   );
        (Mes == MesIni, Dia >= DiaIni  )).
