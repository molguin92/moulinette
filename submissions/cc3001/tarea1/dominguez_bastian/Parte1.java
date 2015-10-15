package cc3001.tarea1.dominguez_bastian;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Parte1 {
	
	public static String ROT( int n , String texto )
	{
		//Se crea una variable de tipo String que comenzará vacío
		String textoRotado="";
		while (n>=26){
			//La rotación es de período 26, por ejemplo, rotar 28 caracteres es lo mismo que rotar 2.
			n= n - 26;
		}
		int i=0;
		while (i < texto.length()) {
			//Se crea una variable de tipo char que irá recorriendo todos los caracteres del texto
			char c=texto.charAt(i);
			//Se debe verificar que si el caracter en la posición i corresponde a una letra mayúsucula, minúscula o a un carácter especial
			if (c >= 'A' && c <='Z'){
				//En este caso el carácter corresponde a una letra mayúscula
				if ( c + n >'Z'){
					//Si al sumar se excede de la letra Z, se debe devolver al principio y continuar la rotación
					 c -= (26 - n);
					
				} else {
					//Si al sumar no se excede de la letra Z, simplemente rotar la cantidad indicada
					c +=n;
				}
			}else{
				if (c >= 'a' && c <= 'z');{
					//En este caso el carácter corresponde a una letra minúscula
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
