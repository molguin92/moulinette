package cc3001.tarea1.molina_matias;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {

	public static void main(String[] args)throws IOException
	{
	// Pretty standard IO routine
	BufferedReader in = new BufferedReader (new InputStreamReader (System.in) );
	String input="";
	String output="";
	String[] param;
	// leemos una linea completa a la vez
	while ((input = in.readLine()) !=null)
	{
	// juntamos todo el output en un string
		param=input.split("\\|",2);
		String[] temp = Criptoanalisis(param[0],param[1]);
		output += temp[0]+" "+temp[1] + "\n" ;
	}
	// luego lo imprimimos todo de una
	System.out.print(output);
	System.out.flush();
	in.close();
	}
	public static String Rot13(int n, String t){
		// TODO Auto-generated method stub
		String minusculas="abcdefghijklmnopqrstuvwxyz";
		String mayusculas="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		int pos,k,i,tope;
		String result, dict;
		char letra;
		result = "";
		k=t.length();
		tope=26;
		n=n%26;
		//System.out.println(n);
		for(i=0; i<k; i++){
				dict="";
				letra = t.charAt(i);
				//System.out.println(letra);
				if(Character.isLowerCase(letra)){
					dict = minusculas;
					//System.out.println("es minuscula");
				}
				if(Character.isUpperCase(letra)){
					dict = mayusculas;
				}
				if( !dict.isEmpty() ) {
				//	System.out.println("es inuscila");
					pos = dict.indexOf(letra);
					if(pos >= 0){
						pos += n;
						if(pos>=dict.length()){
							pos=pos-tope;
						}
						letra = dict.charAt(pos);
					}
				}
				result=result + letra;
		}
	//	System.out.println(result);
		return result;
	}
	
	public static int Score(String d, String t){
		// TODO Auto-generated method stub
		int found=0;
		int n;
		int pos;
		String dictionary;
				
		String[] texto=t.split(" ");
		for(int i=0; i<texto.length; i++){
			t = texto[i];
			dictionary = d.substring(0);
			pos = 0;
			while (pos<=dictionary.length()){
			
				n=dictionary.indexOf(t);
				// System.out.println( "buscando " + t + pos + " n " + n + " " + dictionary );
				if(n>=0){
					found=found+1;
					pos=n+t.length();
					dictionary = dictionary.substring(pos);
				}
				else
					pos=d.length()+1;
		}
		
	}
		return found;	
}
	
	public static String[] Criptoanalisis(String d, String t){
		String s="";
		int n,temp,best=0,resultado=27;
		int maxscore=0;
		String[] arreglo;
		arreglo=new String[2];
		String mejortexto=d;
		// luego si no existen coincidencias entrega por default el primer String, definido como d
		
		for(int i=0; i<26; i++){
			s=Rot13(i,t);
			n = d.indexOf(s);
			if(n>=0){
				if( resultado > (26 - i) ){
				     resultado = 26 - i;
					if( resultado == 26 ) resultado = 0; 
					//es el peor caso para el algoritmo, ya que usa el texto dado para avanzar
				     temp=Score(d,s);
				     if(temp>=maxscore){
				    	 maxscore=temp;//guardamos siempre el mejor score, ya que es parte del objetivo
				    	 best=resultado;
				    	 mejortexto=s;//se queda con el mejor s, para luego retornarlo en el arreglo
				     }
				}

			}
		}
		if( resultado == 27 ) resultado = 0;
		else
			resultado=best;
		arreglo[0]=Integer.toString(resultado);//guardamos el numero en el arreglo pasandolo de String a int
		arreglo[1]= mejortexto;
		return arreglo;		
	}
}