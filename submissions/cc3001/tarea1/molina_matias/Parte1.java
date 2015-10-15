package cc3001.tarea1.molina_matias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {

	public static void main(String[] args)throws IOException
	{
	// Pretty standard IO routine
	BufferedReader in = new BufferedReader (new InputStreamReader (System.in) );
	String input;
	String output="";
	String[] param;
	// leemos una linea completa a la vez
	while (( input = in.readLine()) !=null)
	{
		// juntamos todo el output en un string
		param=input.split(" ",2);
		if( param.length < 2 ) {
			System.out.println("parametros insuficiente");
			System.exit(0);
		}
		if(input.equals("fin")){
            break;
		}
		output += Rot13(Integer.parseInt(param[0]),param[1]) + "\n" ;
		
	}
	// luego lo imprimimos todo de una
	System.out.print(output);
	System.out.flush();
	in.close();
	}

	public static String Rot13(int n, String t){
		// TODO Auto-generated method stub
		// se generan 2 diccionarios
		String minusculas="abcdefghijklmnopqrstuvwxyz";
		String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int pos,k,i,tope;
		String result, dict;
		char letra;
		result = "";
		k=t.length();
		tope=26; // definimos el tope ya que son 26 letras
		n=n%26;//Usamos modulo para saber casos donde el int n es muy grande
		
		for(i=0; i<k; i++){
				dict="";
				letra = t.charAt(i);
				//dejar guardado el caracter en caso de que no este en el diccionario
				if(Character.isLowerCase(letra)){
					dict = minusculas;
					//buscamos en cual de los 2 diccionarios esta
				}
				if(Character.isUpperCase(letra)){
					dict = mayusculas;
				}
				if( !dict.isEmpty() ) {
				// suponemos que no es vacio y corremos el algoritmo
					pos = dict.indexOf(letra);
					//buscamos la posicion de la letra, para saber donde ubicarnos en el texto
					if(pos >= 0){
						pos += n;
						if(pos>=dict.length()){
							pos=pos-tope;
							// la idea es nunca pasar el tope, y si se pasa parte de nuevo con el diccionario
						}
						letra = dict.charAt(pos);
					}
				}
				result=result + letra; //concatenamos las letras finales
		}
		return result;
	}
}
