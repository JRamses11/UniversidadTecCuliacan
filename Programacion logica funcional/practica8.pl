% 1. Reemplaza un elemento X por otro Y en una lista.
reemplaza(_, _, [], []).
reemplaza(X, Y, [X|T], [Y|T2]) :- reemplaza(X, Y, T, T2).
reemplaza(X, Y, [H|T], [H|T2]) :- dif(H, X), reemplaza(X, Y, T, T2).

% 2. Calcula el mayor elemento de una lista.
maximo([X], X).
maximo([H|T], R) :- maximo(T, R1), R is max(H, R1).

% 3. Determina si dos listas son iguales.
compara([], []).
compara([H1|T1], [H2|T2]) :- H1 = H2, compara(T1, T2).

% 7. Calcula la potencia de un número.
potencia(N, N1, R) :- R is N**N1.
 
% 9. Indica todos los elementos de una lista y el número de veces que aparece repetido cada uno de ellos.
numerodeveces([], []).
numerodeveces([H|T], [[H, N]|R]) :- aparece(H, [H|T], N), select(H, [H|T], Rest), numerodeveces(Rest, R).


?- reemplaza(1, 5, [3,1,1,1,1,3,5,2,1,4], R).
R = [3, 5, 5, 5, 5, 3, 5, 2, 5, 4].

?- maximo([4,2,7,34,6,23], R).
R = 34.

?- compara([1,2,3,4,5], [1,2,3,4,5]).
true.

?- potencia(2, 2, R).
R = 4.

?- numerodeveces([1,2,3,2,3,1,2], R).
R = [[1, 2], [2, 3], [3, 2]].
