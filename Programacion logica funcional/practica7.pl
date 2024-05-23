% Predicado para multiplicar dos números
multiplicar(0, _, 0).  % Si el primer número es 0, el resultado es 0
multiplicar(_, 0, 0).  % Si el segundo número es 0, el resultado es 0
multiplicar(X, Y, Resultado) :-
    X > 0,
    X1 is X - 1,        % Reducimos X en 1 en cada llamada recursiva
    multiplicar(X1, Y, Temp),
    Resultado is Temp + Y.  % Sumamos Y a Temp en cada llamada recursiva

% Predicado para dividir dos números
dividir(Dividendo, Divisor, Cociente) :-
    dividir(Dividendo, Divisor, 0, Cociente).

dividir(Dividendo, Divisor, CocienteParcial, Cociente) :-
    Dividendo >= Divisor,
    DividendoNuevo is Dividendo - Divisor,
    CocienteParcialNuevo is CocienteParcial + 1,
    dividir(DividendoNuevo, Divisor, CocienteParcialNuevo, Cociente).

dividir(Dividendo, _, Cociente, Cociente).

% Predicado para calcular el exponente de un número
exponente(Base, 0, 1).
exponente(Base, Exponente, Resultado) :-
    Exponente > 0,
    ExponenteAnterior is Exponente - 1,
    exponente(Base, ExponenteAnterior, ResultadoAnterior),
    Resultado is ResultadoAnterior * Base.
