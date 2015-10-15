package cc3001.tarea1.kock_martin;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
public class Parte3 {
	
	public static boolean isROTcStringInDString(String D, String Tc){
		for (int i=0; i<26; i++){
			String sc = Parte1.ROT(i, Tc);
			if(D.contains(sc)){
				return true;
				/*
				for (String palabra : D.split(" ")){
					if (palabra.equals(sc)){
						return true;
					}
				}
				*/
					
			}
		}
		return false;
	}
	
	public static int poscMax(int [] lista){
		int pos=0;
		int max=0;
		for (int i=0; i<lista.length;i++){
			if (lista[i]>max){
				max=lista[i];
				pos=i;
			}
		}
		return pos;
	}
	
	public static List<String> CRIPTOANALISIS(String D, String Tc) {
		String [] cripto = new String [2];
		int [] indicesScore = new int [26];
		if (isROTcStringInDString(D,Tc)){
			for (int i=0; i<26; i++){
				String sc = Parte1.ROT(i, D);
				indicesScore[i]=Parte2.SCORE(sc, Tc);
			int pos= poscMax(indicesScore);
			cripto[0] = Integer.toString(pos);
			cripto[1] = Parte1.ROT(Math.abs(pos-26), Tc);
		}		
	}
		else{
			//System.out.println("No existe codificación del texto diccionario");
			cripto[0] = Integer.toString(Math.abs(0));
			cripto[1] = Tc;
		}
		return Arrays.asList(cripto);
	}
		

	public static void main(String[] args) throws IOException {
	    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
	    String input ;
	    String output = "" ;
	    //leemos una linea completa a la vez
	    System.out.println ("escribe algo o escribe fin " );
	    while ((input = in.readLine ()) != null ) {
	        if(input.equals("fin")){
	            break;
	        }
	        output += CRIPTOANALISIS(input.split(Pattern.quote("|"))[0],input.split(Pattern.quote("|"))[1]) + "\n";
	        //output += input + "\n";
	        System.out.println (CRIPTOANALISIS(input.split(Pattern.quote("|"))[0],input.split(Pattern.quote("|"))[1]) + "\n");
	        System.out.println ("escribe algo o escribe fin " );
	    }
	    //luego lo imprimimos todo de una
	    System.out.print ( output );
	    System.out.flush ();
	    in.close ();
	    System.out.println("termine");
	    }



}
