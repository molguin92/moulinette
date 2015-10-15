package cc3001.tarea1.olivares_felipe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Parte3 {
	
	public static int CRIPTOANALISIS (String D, String T){
		
	    //iNICIAR SCORE
	    int scoremax = SCORE(D,T);
	    int nmin=0;
		
		int i=0; //contador
		//CICLO
		while (i<26){
			if (SCORE(D,ROT(i,T))>=scoremax){
				scoremax = SCORE(D,ROT(i,T));
				if (nmin<i){
					nmin = i;
				}
				nmin = i;
			}
			i++;
		}
		if (26-nmin==26){
			return 0;
		}
		else{
			return 26-nmin;
		}
		
		
		
		
	}
	
	//ROT
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
	//FIN ROT
	//SCORE
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
	//FIN SCORE

	
	//public static void main (String[] args){
		//System.out.println(CRIPTOANALISIS("UNIVERSIDAD DE CHILE DEPARTAMENTO DE CIENCIAS DE LA COMPUTACION ALGORITMOS Y ESTRUCTURAS DE DATOS","NYTBEVGZBF L RFGEHPGHENF QR QNGBF"));
	//}

	//METODO PARA QUITAR UN ELEMENTO DE UN ARRAY
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
	    System.out.println(output);
	    String[] array = output.split("|");
		String D = array[0];
		System.out.println(D);//ACOMPROBACION
		
		String T = array[1];
		System.out.println(T);//COMPROBACION
		
		String numero = Integer.toString(CRIPTOANALISIS(D,T));
		int rotnummero = 26-CRIPTOANALISIS(D,T);

		System.out.println(numero+" "+ROT(rotnumero,T)); // PRINTEAR EN PANTALLA TEXTO CODIFICADO
	    }
	}


