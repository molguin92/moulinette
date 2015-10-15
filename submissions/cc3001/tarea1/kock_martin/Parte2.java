package cc3001.tarea1.kock_martin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Parte2 {
	
	public static String [] sacarEspacios(String [] lista){
		for (String t : lista){
			t=t.replaceAll("\\s","");	
	}
		return lista;
	}
	
	public static int SCORE(String D, String T) {
		
		String [] palabrasT= T.split(" ");
		String [] palabrasD= D.split(" ");
		int repeticionD=0;
		palabrasT=sacarEspacios(palabrasT);
		palabrasD=sacarEspacios(palabrasD);
		for (String t : palabrasT){
			for (String d : palabrasD){
				if (t.equals(d))
		    		repeticionD+=1;
			}	
		}
		//System.out.println(repeticionD);
	
		return repeticionD;
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
	        output += SCORE(input.split(Pattern.quote("|"))[0],input.split(Pattern.quote("|"))[1]) + "\n";
	        //output += input + "\n";
	        System.out.println (SCORE(input.split(Pattern.quote("|"))[0],input.split(Pattern.quote("|"))[1]) + "\n");
	        System.out.println ("escribe algo o escribe fin " );
	    }
	    //luego lo imprimimos todo de una
	    System.out.print ( output );
	    System.out.flush ();
	    in.close ();
	    System.out.println("termine");
	    }

	
}
