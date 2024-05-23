/* FACTORIAL    factorial(3,X).*/

factorial(1,1).
factorial(X,Y):- X>1, X1 is X-1, factorial(X1,Y1), Y is X*Y1.

/* FIBONNACI    fibonaci(6,X).*/
fibonaci(0,0).
fibonaci(1,1).
fibonaci(X,Y):- N>1, N1 is N-1, fibonaci(N1,X1), N2 is N-2, fibonaci(N2,X2), X is X1+X2.

/* SUMATORIA*/
sumatoria(0,0).
sumatoria(N,Resultado):- N=<1, Resultado is 1.

sumatoria(N, Resultado):- N>1, sumatoria(N-1, ResultadoAux), Resultado is ResultadoAux+N.

