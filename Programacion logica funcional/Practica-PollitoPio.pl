% POLLITO PIO

/*
En la radio, hay un pollito
En la radio, hay un pollito
El pollito pío, el pollito pío
El pollito pío, el pollito pío
El pollito pío, el pollito pío

En la radio, hay una gallina
En la radio, hay una gallina
Y la gallina coo, y el pollito pío
Y el pollito pío, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay también un gallo
En la radio, hay también un gallo
Y el gallo corococo, y la gallina coo
Y el pollito pío, el pollito pío
El pollito pío, el pollito pío

En la radio, hay un pavo
En la radio, hay un pavo
Y el pavo glugluglu, y el gallo corococo
Y la gallina coo, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay una paloma
En la radio, hay una paloma
Y la paloma ruuu, el pavo glugluglu
El gallo corococo, y la gallina coo
El pollito pío, el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay también un gato
En la radio, hay también un gato
Y el gato miao, la paloma ruuu
El pavo glugluglu, el gallo corococo
Y la gallina coo, y el pollito pío
El pollito pío, y el pollito pío

En la radio, hay también un perro
En la radio, hay también un perro
Y el perro guau guau, el gato miao
La paloma ruu, el pavo glugluglu
El gallo cocoroco, y la gallina coo
Y el pollito pío, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay una cabra
En la radio, hay una cabra
Y la cabra mee, el perro guau guau
El gato miao, y la paloma ruu
El pavo glugluglu, el gallo cocoroco
Y la gallina coo, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay un cordero
En la radio, hay un cordero
Y el cordero bee, y la cabra mee
El perro guau guau, el gato miao
La paloma ruu, el pavo glugluglu
El gallo cocoroco, y la gallina coo
Y el pollito pío, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay una vaca
En la radio, hay una vaca
Y la vaca moo, y el cordero bee
Y la cabra mee, el perro guau guau
El gato miao, y la paloma ruu
El pavo glugluglu, el gallo cocoroco
Y la gallina coo, y el pollito pío
Y el pollito pío, y el pollito pío
Y el pollito pío, y el pollito pío

En la radio, hay también un toro
En la radio, hay también un toro
Y el toro muu, la vaca moo
El cordero bee, la cabra mee
El perro guau guau, el gato miao
La paloma ruu, el pavo glugluglu
El gallo cocoroco, Y la gallina coo
Y el pollito pío, el pollito pío
El pollito pío, el pollito pío

En la radio, hay un tractor
En la radio, hay un tractor
Y el tractor brum, y el tractor brum
Y el tractor brum y el pollito oh-oh (cambia el coro en este)
*/

% BASE DE CONOCIMIENTO
% granja(orden,artículo,animal,sonido)
granja(1, el, pollito, pio). 
granja(2, la, gallina, coo).
granja(3, el, gallo, cocoroco).
granja(4, el, pavo, glugluglu).
granja(5, la, paloma, ruu).
granja(6, el, gato, miao).
granja(7, el, perro, guauguau).
granja(8, la, cabra, mee).
granja(9, el, cordero, bee).
granja(10, la, vaca, moo).
granja(11, el, toro, muu).
granja(12, un, tractor, brum).

cantar(13).

cantar(N) :-
    granja(N, Articulo, Animal, _),
    concatenar(["En la radio, hay también ",
                 Articulo, " ", Animal], String),
    write(String), nl, write(String), nl,
    sonidos(N),
    N1 is N+1,
    cantar(N1).

concatenar(Lista, Cadena) :-
    maplist(atom_chars, Lista, Lists),
    append(Lists, List),
    atom_chars(Cadena,List).

imprime(N) :-
    granja(N, Articulo, Animal, Sonido),
    concatenar([Articulo, " ", Animal, " ", Sonido], String),
    write(String), nl.

sonidos(12) :- %prrr
    imprime(12), imprime(12),
    write("Pollito prrr").

sonidos(1) :-
    imprime(1), imprime(1), imprime(1).

sonidos(N) :-
    imprime(N),
    N1 is N-1,
    sonidos(N1).

cancion :- cantar(1).