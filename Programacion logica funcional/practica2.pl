/*
EJERCICIO 1
A partir de la siguiente base de conocimiento en Prolog, 
crear las reglas necesarias para que el intérprete nos 
diga qué alimento puede comer cada animal:
*/
herbivoro(vaca).
herbivoro(oveja).
carnivoro(león).
hortaliza(tomate).
hortaliza(zanahoria).
fruta(manzana).
pescado(besugo).
carne(salchicha).
fideos(spaghetti).

comeCarne(Quien,Que):-carnivoro(Quien),( pescado(Que) ; carne(Que) ). 
noComeCarne(Quien,Que):-herbivoro(Quien),( hortaliza(Que) ; fruta(Que) ; fideos(Que)).

% EJERCICIO 2
% 1) Las algas usan medias rojas.
usaMediasRojas(algas).
 
%2) Todo objeto o animal o persona 
% que usa  desodorante sabe tocar el saxo.
objeto(piedra).        
objeto(bat).      
animal(perro).        
animal(gato).
persona(hugo).        
persona(paco).    
persona(luis).
usaDesodorante(luis).        
usaDesodorante(gato).
usaDesodorante(paco).        
usaDesodorante(bagoneta).

%3) Todo lo que eche humo usa desodorante.
usaDesodorante(X):- echaHumo(X).
 
tocaSax(X):- usaDesodorante(X), (  objeto(X); animal(X); persona(X) ).
% 4) Nada ni nadie que usa medias rojas 
% puede tocar el saxo.
tocaSax(X):- usaMediasRojas(X), not(persona(X)), not(objeto(X)).
 
% 5) Todas las personas  pueden usar un objeto
usaObjeto(X):- persona(X).
 
% 6) Si una persona usa desodorante no hara la tarea
noHaraTarea(X):- usaDesodorante(X), persona(X).
 
% 7) Si usa desodorante y puede usar un objeto echa humo
echaHumo(X):- usaDesodorante(X), usaObjeto(X).
 
% 8)Cualquier animal que corre es feliz
corre(perro).    
corre(luis).

esFeliz(X):- animal(X), corre(X).
esFeliz(hugo).
 
% 9) Los hippies son felices y pueden tocar el saxo
%hippie(X):- esFeliz(X), persona(X), tocaSax(X).
hippie(hugo).
tocaSax2(S):- hippie(S), esFeliz(S).

% 10) Los perros ladran cuando son felices 
ladra(X):- esFeliz(X), corre(X).