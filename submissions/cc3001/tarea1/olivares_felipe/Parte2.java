package cc3001.tarea1.olivares_felipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Parte2 {
	
	public static int SCORE (String D, String T){
		
		//transformar en array
		String[] Tarray = T.split(" ");
	    String[] Darray = D.split(" ");
	    
	    int k=0; //contador
		int i=0;
		while (i<Tarray.length){

			int p=0;
			while (p<Darray.length){
				if (Tarray[i].equals(Darray[p])){
					k++;
					break;
				}
				p++;
			}
			i++;
		}
		return k;
		
	}
	// METODO PARA QUITAR UN ELEMENTO DE UN ARRAY
		public static String[] removeElements(String[] input, String deleteMe) {
		    List result = new LinkedList();

		    for(String item : input)
		        if(!deleteMe.equals(item))
		            result.add(item);

		    return (String[]) result.toArray(input);
		}
	
	//public static void main (String[] args){
		//System.out.println(SCORE("AB CD EF GH", "CD GH IJ"));
	//}
	public static void main ( String [] args ) throws IOException {
	    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
	    String output = "" ;
	    //leemos una linea completa a la vez
	    System.out.println ("escribe algo" );
	    output = in.readLine(); // INPUT DE LA PALABRA....CURIOSAMENTE LLADAMO OUTPUT
	    System.out.println(output);
	    String[] array = output.split("|");
		String D = array[0];
		System.out.println(D);//ACOMPROBACION
		
		String T = array[1];
		System.out.println(T);//COMPROBACION

		System.out.println(SCORE(D,T)); // PRINTEAR EN PANTALLA TEXTO CODIFICADO
	    }
	}
	



