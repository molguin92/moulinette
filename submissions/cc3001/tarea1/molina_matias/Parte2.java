package cc3001.tarea1.molina_matias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {

	public static void main(String[] args)throws IOException
	{
	// Pretty standard IO routine
	BufferedReader in = new BufferedReader (new InputStreamReader (System.in) );
	String input;
	String output="";
	String [] param;
	// leemos una linea completa a la vez
	while (( input = in.readLine()) !=null)
	{
	// juntamos todo el output en un string
		param=input.split("\\|",2);
		output += Integer.toString(Score(param[0],param[1]))+ "\n";
		}
	// luego lo imprimimos todo de una
	System.out.print(output);
	System.out.flush();
	in.close();

	}
	
	public static int Score(String d, String t){
		// TODO Auto-generated method stub
		int found=0;
		// va a ser nuestro contador de exito que por default parte en 0
		int m;//nuestra variable que nos va a servir para recorrer el string
		int pos; //nos va a permitir saber en que posicion estamos
		String dictionary; //variable auxiliar		
		String[] texto=t.split(" ");
		//dividimos nuestro texto en caso de que sea con varias palabras de lo contrario queda con un arreglo con solo un valor
		for(int i=0; i<texto.length; i++){
			t = texto[i];
			dictionary = d.substring(0);
			pos = 0;
			while (pos<=dictionary.length()){
				m=dictionary.indexOf(t);//me dira en que posicion esta la palabra
				if(m>=0){
					found=found+1;
					pos=m+t.length();
					//dado que la encontre avanzo en el texto el largo de la encontrada, ya que la encontre
					dictionary = dictionary.substring(pos);
					//el dictionary auxiliar ahora sera mas enano
				}
				else
					pos=d.length()+1;//desde aca se puede buscar otra caracter parecido
		}
	}
		return found;
}
}

	