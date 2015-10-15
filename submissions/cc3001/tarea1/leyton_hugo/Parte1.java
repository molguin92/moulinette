package cc3001.tarea1.leyton_hugo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1
{
	public static String ROT(int n,String T){
	    String D  =  "abcdefghijklmnopqrstuvwxyz";
		String DD =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String U = "";
    	while(n<0){                            //Si n negativo, le sumamos 27 hasta que sea positivo.
    		n=n+D.length();}
		for (int i = 0; i < D.length(); i++){//Buscamos cada letra en el abecedario y guardamos el valor si esta en él
			int f=i+n;
	        if (D.charAt(i) == T.charAt(0)) {
	        	for(int k=1;n+i-k*(D.length())>=0;){
	        		f=n+i-k*D.length();
	        		k++;}
	            U += D.charAt(f);    }
	        if (DD.charAt(i) == T.charAt(0)) {
	        	for(int k=1;n+i-k*(D.length())>=0;){
	        		f=n+i-k*DD.length();
	        		k++;}
	        	U += DD.charAt(f);   }
	        }
		if (U==""){ //Si no esta en los diccionarios, escribimos el anterior, ejemplo, si tenia tilde ETC...
	       	U+=T.charAt(0);}
		if(T.length()==1){// si era una sola letra, la retornamos codificada
			return U;}
		if(T.length()>1){// Si vienen mas letras, llamamos recursivamente para seguir la operacion con la proxima.
			U += ROT(n,T.substring(1,T.length()));
			return U;}
		return U;}				
		//Con lo de abajo hacia las pruebas
	public static void main ( String [ ] args ) throws IOException { 
		BufferedReader in = new BufferedReader ( new InputStreamReader ( System . in ) ); 
		String input ; 
		String output = "" ;
		while ( (input = in.readLine())!= null){
			if (input.equals("")){break ;}
			int n=Integer.parseInt(input.split(" ")[0]);
			String T=input.split(" ")[1];		
			output = output + ROT(n,T) + "\n" ; }
		System . out . print ( output ); System . out . flush (); in . close ();
		}
	}
