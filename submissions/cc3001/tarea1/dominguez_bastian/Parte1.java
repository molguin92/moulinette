package cc3001.tarea1.dominguez_bastian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parte1 {
	
	public static String ROT( int n , String texto )
	{
		//Se crea una variable de tipo String que comenzar� vac�o
		String textoRotado="";
		while (n>=26){
			//La rotaci�n es de per�odo 26, por ejemplo, rotar 28 caracteres es lo mismo que rotar 2.
			n= n - 26;
		}
		int i=0;
		while (i < texto.length()) {
			//Se crea una variable de tipo char que ir� recorriendo todos los caracteres del texto
			char c=texto.charAt(i);
			//Se debe verificar que si el caracter en la posici�n i corresponde a una letra may�sucula, min�scula o a un car�cter especial
			if (c >= 'A' && c <='Z'){
				//En este caso el car�cter corresponde a una letra may�scula
				if ( c + n >'Z'){
					//Si al sumar se excede de la letra Z, se debe devolver al principio y continuar la rotaci�n
					 c -= (26 - n);
					
				} else {
					//Si al sumar no se excede de la letra Z, simplemente rotar la cantidad indicada
					c +=n;
				}
			}else{
				if (c >= 'a' && c <= 'z');{
					//En este caso el car�cter corresponde a una letra min�scula
					if ( c + n > 'z'){
						c -= (26 - n);
					} else {
						c  += n;
					}
				}
			//se agrega el caracter codificado a textoRotado
			textoRotado += c;
			i=i+1;
			}
		}
		//finalmente se imprime el textoRotado
		return textoRotado;
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
    		output += ROT(Integer.parseInt(input.split(" ")[0]), input.split(" ")[1] ) + "\n";
    	}
    	
    	//luego lo imprimimos todo de una
    	System.out.print( output );
    	System.out.flush ();
    	in.close ();
    }
}
