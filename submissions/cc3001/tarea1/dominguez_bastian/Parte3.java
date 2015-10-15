package cc3001.tarea1.dominguez_bastian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parte3 {
	
	public static String CRIPTOANALISIS( String diccionario , String texto )
	{
		
	}
	
    public static void main ( String[] args ) throws IOException
    {
    	//Pretty Standard IO routine
    	BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
    	String input;
    	String output = "";
    	
    	//leemos una linea completa a la vez
    	while ( ( input=in.readLine () ) !=null)
    	{
    		//juntamos todo el output en un string
    		output += CRIPTOANALISIS(input.split("\\|")[0], input.split("\\|")[1]) + "\n";
    	}
    	
    	//luego lo imprimimos todo de una
    	System.out.print( output );
    	System.out.flush ();
    	in.close ();
    }
}

