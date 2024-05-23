woman(mia).
woman(jody).
woman(yolanda).

loves(vicent, mia).
loves(marsellus, mia).
loves(pumpkin, honey_bunny).
loves(honey_bunny, pumpkin).
loves(rafa, pumpkin).

celoso(X,Y):- loves(X,mia), loves(Y,mia), X\=Y.
celoso(X,Y,Z):- loves(X,Z), loves(Y,Z), X\=Y.
celoso2(X,Y):- loves(X,Z), loves(Y,Z), X\=Y.
/*VARIABLES EN MAYUSCULAS (X,Z,Y)
 * PREDICADOS EN MINUSCULAS
 * :- SI
 */ 