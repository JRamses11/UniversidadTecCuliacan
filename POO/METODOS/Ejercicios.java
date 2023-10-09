package METODOS;

//Clase Ejercicios para metodos
//Jose Ramses Aldama Cazares
//8:00-9:00

public class  Ejercicios{
     // Esta clase toma un valor y regresa si es positivo o negativo
	      public String checasigno (int num){
		         if (num>0)
					 return "Positivo";			 
				     if (num<0)
					     return "Negativo";
				         else
						     return "0";
                                          }
                      
		// Esta clase toma dos valores y regresa como resultado cual es el numero mayor
		public String Mayor2 (int a, int b){
	          if (a>b)
			      return "El primer valor es mayor";
				  if (a<b)
				      return "El segundo valor es mayor";
					  else
					      return "Los valores son iguales";
						                   }
      // Esta clase toma 3 valores y te dice cual de ellos es el mayor 
		public String Mayor3 (int x, int y, int z){
	          if (x>y && x>z)
			     return "El primer valor es el mayor";
				 if (y>x && y>z)
				     return "El segundo valor es el mayor";
					 if (z>x && z>y)
					     return "El tercer valor es el mayor";
					     else
							return "No hay numeros mayores";
	                                              }
		//Esta clase recibe un numero entero y regresa si es numero par o impar
      public boolean ParImpar (int a){
		       return a%2==0;
		                              }
					
		/*Este metodo CalculaCosto recibe la duracion de una llamada telefonica en minutos
		retorna el costo de la llamada que dura tres minutos o menos tiene costo de $5 
		y cada minuto adicional a eso cuesta $3											  
		*/					
       public int CalculaCosto (int llamada){
			    int restante=3;
              if (llamada<=3)
                  return 5;
                  else
                      return (llamada-restante)*3+5;			
		                                                      }				
											
		/* Metodo AreaTriangulo recibe las longirudes de los tres lados de un triangulo (L1, L2, L3)
		Retorna el area del mismo de acuerdo con la siguiente formula:
		Area=( T( T-L1) (T-L2) (T-L3)) ^0.5
		donde: T= (L1+L2+L3)/2
		*/
		public double AreaTriangulo(int L1, int L2, int L3){
			   double area;
			   int T;
			   int At;
			   T= (L1+L2+L3)/2;
			   At=(T*(T-L1)*(T-L2)*(T-L3));
			   area=Math.pow(At, 0.5);
			   return area;             
		}			   
		//Se requiere optener la suma de los primeros N numeros naturales
		public String SumNaturales(int num){
			       int suma=0;
			       for (int i=0; i<=num; i++){
				   suma=suma+i;
				   }
				   return "Sumatoria de los primeros " +num +" Es " +suma;
		                                  }	
		/* Metodo CostoVehiculo el costo de un automovil nuevo para el consumidor es:
		-La suma del total del costo del vehiculo
		-Mas el porcentaje de ganancia del vendedor
		-Mas los impuestos locales o estatales aplicables (Sobre el precio de la venta)
		-Supongamos una ganancia del vendedor del 12% en todas las unidades
		-Y un impuesto del 6%
		-Retorna el costo final para el consumidor
      */			
		public double CostoVehiculo (double ValAuto){
			   double costF;
			   ValAuto=ValAuto+(ValAuto*0.12);
			   costF=ValAuto+(ValAuto*0.6);
			   return costF;
		}
		//Sacar el factorial de un numero
		public int Factorial (int r){
			   int dec=1;
			   for (int i=1; i<=r; i++){
				   dec=dec*i;
			   }
			   return dec;
		}
		                                       
		/*Capturar las calificaciones obtenidas por un estudiantes en tres examenes parciales
      e imprimir su promedio final seguido el mensaje correspondiente de acuerdo a la siguiente tabla:
		100 Excelente
		99-90 Muy bien
		89-80 Bien
		79-70 Hay que Mejorar
		-69 Reprobado
		*/
		public String Calificaciones (int cal1, int cal2, int cal3){
			   double promedio=0;
			   promedio=(cal1+cal2+cal3)/3;
			   if (promedio==100)
				   return promedio +" Excelente";
			       if (promedio<=99 && promedio>=90)
					   return promedio +" Muy bien";
				       if (promedio<=89 && promedio>=80)
						   return promedio +" Bien";
					       if (promedio<=79 && promedio>=70)
							   return promedio +" Hay que mejorar";
						       else
								   return promedio +" Reprobado"; 
								   }
		
      /*Este metodo Promedio recibe 5 numeros de parametros retorna el promedio
		considerando lo siguiente: elimine el numero mayor y menor y promedie los 
		3 restantes */
		

		/*Leer las Longitudes de los tres lados del triangulo (L1, L2, L3)
		y determinar que tipo de triangulo es, de acuerdo a los siguiente casos
		suponiendo que A es el mayor de los lados L1, l2, L3
		y que B y C corresponden a los otros dos entonces
		-SI A>= (B+C) No se forma un triangulo
		-SI A2 = B2+C2 Se forman un triangulo rectangulo
		-SI A2> B2+C2 Se forman un triangulo obtusangulo
		-SI A2< B2+C2 Se forman un triangulo acutangulo
		*/		

      /* Metodo PagoVendedor Recibe: numero de autos vendidos al mes. retorna el sueldo bruto,
		el impuesto y sueldo neto. en un String basandose en lo siguiente. El pago base es de $350 
		mas una comision de $15 por cada auto vendido y un bono de $40 si vendio mas de 15 autos. 
		el impuesto a pagar es el 25% del pago total, sueldo neto es el bruto menos el impuesto 
		*/
		public String PagoVendedor (int ven){
			   int base=350;
			   int sueldoB=0;
			   double sueldoN=0;
			   double imp=0;
		       if (ven<15){
				   sueldoB=base+(ven*15);
				   imp=(sueldoB*0.25);
			       sueldoN=sueldoB-imp;
			     }
                     if(ven>15){			
					   sueldoB=base+(ven*15)+40;
				       imp=(sueldoB*0.25);
			           sueldoN=sueldoB-imp;
					 }
			   return "El sueldo bruto es " +sueldoB +" El impuesto es "+imp +" El sueldo neto es " +sueldoN;
		                                    }
		
		/* Un distribuidor de juguetes ha hecho una excelente compra de 10,000 juguetes en cajas
         rectangulares de diversos tamaños. El distribuidor desea poner las cajas en esferas
         plásticas de brillantes colores y sellarlas como paquetes sorpresa. Las esferas son de
         cuatro diámetros diferentes : 4, 6, 8 y 10 pulgadas, por lo que para realizar todo en
         orden desea saber cuántas esferas de cada diámetro debe comprar. Puesto que la
         diagonal de una caja rectangular cuyas dimensiones son A, B y C está dada por
         D = \ A2+B2+C2
         y es, además, la dimensión mayor, el distribuidor debe calcular las longitudes de las
         diagonales de las cajas y determinar el número de las que son de 4 pulgadas o menos,
         las comprendidas entre 4 y 6 pulgadas, etc. Diseñe un algoritmo en diagrama de flujo
         que lea las dimensiones de cada caja, calcule la longitud de sus diagonales e imprima
         el número de esferas de cada tamaño que necesita comprar para empacar los juguetes
		*/
		
		/*Una compañía ha tenido un excelente año y desea premiar a sus empleados con un
        aumento de salarios. Los sueldos deben ajustarse a la siguiente forma :
        Sueldo actual Aumentohasta 
		  $9,000 20 %
        $9,001 - $13,000 17 %
        $13,001 - $ 18,000 12 %
        Sobre $18,000 6 %
        La compañía tiene 50 empleados. Diseñe un algoritmo en diagrama de flujo que lea el
        nombre de cada empleado y su sueldo actual, y que imprima el nombre, el sueldo actual
        y el sueldo aumentado. Al final de la lista debe proporcionar también , el monto total de
        la nómina actual y el monto total de la nueva nómina que incluye los aumentos
        mencionados. */
		  public double Bonos (int pagos){
				 double nuevo=0;
					 if (pagos==9000){
					     nuevo=pagos+(pagos*0.20); 
						 }
					     if (pagos>9001 && pagos<=13000) {
						     nuevo=pagos+(pagos*0.17);
							 }
						     if (pagos>13001 && pagos<=18000) { 
							     nuevo=pagos+(pagos*0.12); 
								 }
                               if (pagos>18000){
								 nuevo=pagos+(pagos*0.06); 
								 }
	        return nuevo;
		  }
	   
	   
}