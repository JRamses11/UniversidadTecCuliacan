isDigesting(X,Y):- justAte(X,Y).
isDigesting(X,Y):- justAte(X,Z), isDigesting(Z,Y).

justAte(mosquito, blood(john)).
justAte(frog, mosquito).
justAte(stork, frog).

/* */

child(anna, bridget).
child(bridget, caroline).
child(caroline, donna).
child(donna, emily).

descend(X,Y):- child(X,Y).
descend(X,Y):- child(X,Z), descend(Z,Y).

/* */

matryoshka(olga, katarina).
matryoshka(natasha, olga).
matryoshka(irina, natasha).

encima(X,Y):- matryoshka(X,Y).
encima(Dentro, Fuera):- matryoshka(Dentro, Aux), encima(Aux, Fuera).

/* */

pokemon(bulbasur, huevo).
pokemon(ivysaur, bulbasur).
pokemon(venusaur, ivysaur).

evolucion(X,Y):- pokemon(X,Y).
evolucion(Evoluciona, Donde):- pokemon(Evoluciona, Aux), evolucion(Aux, Donde).

/* */
actor(dr_drake_ramoray, joey_tribbiani).
actor(joey_tribbiani, matt_leblanc).

presenta(X,Y):- actor(X,Y).
presenta(Actua, De):- actor(Actua, Aux), presenta(Aux, De). 

/* */
dentroDe(pollito, sinNombre).
dentroDe(sinRostro, pollito).
dentroDe(bo, sinRostro).
dentroDe(susuwatae, bo).

cambia(X,Y):- dentroDe(X,Y).
cambia(Dentro, De):- dentroDe(Dentro, Aux), cambia(Aux, De).














          
          
          
          
          
          
          
          
