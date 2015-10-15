package cc3001.tarea1.dominguez_bastian;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parte2 {
	
	public static int SCORE( String diccionario, String texto)
	{
		//se crea una variable de tipo char que recorrera todo el texto
		int i=0;
		int contador=0;
		while (i < texto.length() ){
			String palabra="";
			char c = texto.charAt(i);
			//mientras la cadena de caracteres contenga unicamente letras, se formará una palabra.
			while ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
				palabra +=c;
				i = i+1;
			}
			//ahora que tenemos la palabra debemos ver si la palabra esta en el diccionario
			int k = diccionario.indexOf(palabra);
			//si la palabra esta en el diccionario
			if ( k != -1){
				contador = contador+1;
			}
		}
		
		
		return contador;
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
    		output += SCORE( input.split("\\|")[0] , input.split("\\|")[1] ) + "\n";
    	}
    	
    	//luego lo imprimimos todo de una
    	System.out.print( output );
    	System.out.flush ();
    	in.close ();
    }
}
