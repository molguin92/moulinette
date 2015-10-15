package cc3001.tarea1.olivares_felipe;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {
	
	public static String ROT (int n, String T){
		//inicializar
		int t=T.length(); //Largo de t
		String abc = "abcdefghijklmnopqrstuvwxyz"; //abecedario
		String ABC = abc.toUpperCase(); //ABECEDARIO
		char[] abcarray = abc.toCharArray(); //Arreglo de abecedario
		char[] ABCarray = ABC.toCharArray(); //Arreglo de ABECEDARIO
		char[] Tarray=T.toCharArray(); //Arreglo del string T
		char[] Tpa = new char[t]; //Arreglo de T prima
		//CICLO PARA RECORRER PALABRA
		int i=0; //contador del ciclo
		int p=0; //indiceabc
		while (i<t){
			//comprobar espacio
			if (Tarray[i]==' '){
				Tpa[i] = ' ';
			}
			else{
				//comprobar si es o no mayuscula
				if (T.toLowerCase().toCharArray()[i]==Tarray[i]){
					p=indiceabc(Tarray[i]);
					int u=p+n;
					
					while (u>=26){
						u=u-26;
					}
					Tpa[i]=abcarray[u];
				}
				else{
					p=indiceabc(T.toLowerCase().toCharArray()[i]);
					int u=p+n;
					while (u>=26){
						u=u-26;
					}
					Tpa[i]=ABCarray[u];
				}
			}
			
			i++;
		}
		return String.valueOf(Tpa);
		
	}
	
	public static int indiceabc (char arg){
		
		String abc = "abcdefghijklmnopqrstuvwxyz";
		char[] abcarray = abc.toCharArray();

		int k=0;
		while (k<26){
			
			if (arg==abcarray[k]){
				return k;
			}
			else{
				k++;
			}
			
		}
		return -1;
		
	}
	// METODO PARA QUITAR UN ELEMENTO DE UN ARRAY
	public static String[] removeElements(String[] input, String deleteMe) {
	    List result = new LinkedList();

	    for(String item : input)
	        if(!deleteMe.equals(item))
	            result.add(item);

	    return (String[]) result.toArray(input);
	}
	
	public static void main ( String [] args ) throws IOException {
	    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
	    String output = "" ;
	    //leemos una linea completa a la vez
	    System.out.println ("escribe algo" );
	    output = in.readLine(); // INPUT DE LA PALABRA....CURIOSAMENTE LLADAMO OUTPUT

	    String[] array = output.split(" ");
		String numero = array[0];
		StringBuffer cadena = new StringBuffer();
		String[] array2 = removeElements(array,numero); // REMOVER EL NUMERO
		for (int x=0;x<array2.length-1;x++){
			   cadena =cadena.append(array2[x]);
			   cadena = cadena.append(" ");
		}
		//
		int number = Integer.parseInt(numero);
		System.out.println(ROT(number,cadena.toString())); // PRINTEAR EN PANTALLA TEXTO CODIFICADO
	    }
	}
	

