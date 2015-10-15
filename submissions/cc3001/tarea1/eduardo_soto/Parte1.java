package cc3001.tarea1.eduardo_soto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		
		// se lee una linea completa a la vez:
		//System.out.println ("escribe algo o escribe fin " ); // TEST 
		while ((input =in.readLine())!= null){
			/* if(input.equals("fin")){ // test
	            break; // test
	        } */ // test
			String[] parts = input.split(" ",2); //divide el string en 2 partes, divisor: " "
			String part1 = parts[0]; // numero aqui.
			int N = Integer.parseInt(part1); //obtiene numero N del primer trozo de string.
			String part2 = parts[1]; //resto del string aqui.
			
			
			//se junta todo el output en un string
			output += ROT(N, part2)+"\n";
			
		}
		
		//luego se imprime todo junto.
		System.out.print(output);
		System.out.flush();
		in.close();

	}
	
	static char [] ABE = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
	// crea lista abecedario en MAYUS, indices de 0 a 25 (26 letras)

	static char [] abe = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	// crea lista abecedario en minus, indices de 0 a 25 (26 letras)

	
	
	public static String ROT(int N, String T) { 
	//dado entero N y string T devuelve version codificada T'
		
		char [] texto = T.toCharArray(); // se crea el arreglo texto en base al string T
	
		int posicion = 0; 
		// se inicializa variable que indica la posicion final(rotada) de la letra en el abecedario. 
		
		char [] textoINV = new char [T.length()]; 
		// se crea un arreglo donde se guardara el resultado de la rotacion de caracteres.
		

		for (int i=0; i < texto.length ; i++){ // se recorre el texto
			
			if (estaEnAbec(texto[i])){ //entra ssi el caracter esta en el abecedario.
			
			if (Character.isUpperCase(texto[i])){ //entra ssi el caracter esta en mayuscula.
				
				for (int j=0; j< ABE.length ; j++){ //recorre el arreglo ABE (mayus)
					
					if(ABE[j]==texto[i]){ // condicion de que los caracteres son iguales.
						
						posicion = Rotar(j,N); 
						//indica la posicion final del caracter en el ABECEDARIO.
						
						textoINV[i]=ABE[posicion]; //se inserta la letra correspondiente al texto rotado.
						}
					}
				}
			
			else { // caso en que el caracter esta en minuscula.
				
				for (int j=0; j< abe.length ; j++){ //recorre el arreglo abe (minus)
					
					if(abe[j]==texto[i]){ // condicion de que los caracteres son iguales.
						
						posicion = Rotar(j,N); 
						// indica la posicion final del caracter en el abecedario.

						textoINV[i]=abe[posicion]; //se inserta la letra correspondiente al texto rotado.
						
						}
					}
				}
			} // } asociado a la comprobacion de letra en abecedario.
			else{ //caso caracter que no esta en el abecedario.
			textoINV[i]=texto[i]; //agrega caracter no encontrado en abecedario al texto final.
				}
			} // } asociado a el for
		
		String resultado = new String(textoINV); //convierte el arreglo de texto a string.
		return resultado; //retorna el string de texto convertido.
		
		} // } asociado a la funcion RoT
		
	
	
	
	static int Rotar(int P, int N){ // funcion que retorna posicion del caracter final.
		// P indica posicion inicial, N indica numero de veces a rotar.
		
		int F=P; //indice de letra en abecedario.
		for (int i=0; i<N ; i++){ //recorre las letras N veces.
			if (F==25){ //caso en que se piensa pasar de 'Z' a 'A' se "devuelve" el indice a 0.
				F=0;
				}
			else{
				F=F+1; // se aumenta el indice en 1.
				}
			}
		
		return F; // retorna posicion final del caracter rotado N veces.
		}
	
	
	static boolean estaEnAbec(char C){ // retorna true si el caracter esta en el abecedario.
		if (Character.isUpperCase(C)){ // caso en que la letra esta en mayuscula
			for (int i=0; i< ABE.length; i++){ // recorre abecedario de MAYUSCULAS.
				if (C==ABE[i]){ //caso en que encuentra el caracter en el abecedario.
					return true;
					}
				}
			}
		else{ //caso letra en minuscula u otro.
			for (int i=0; i< abe.length; i++){ // recorre abecedario de minusculas.
				if (C==abe[i]){ //caso en que encuentra el caracter en el abecedario.
					return true;
					}
				}
			
			}
		return false; //retorna negativo en caso de que no se cumplan las condiciones anteriores.
		}
	}
