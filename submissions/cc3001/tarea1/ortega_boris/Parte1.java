package cc3001.tarea1.ortega_boris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Parte1 {
	
	
	
	
		public static void main (String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ));
		
		
		String input;
		String output1 = "";
		String output = "";
		String palabras = "";
		
		
		

		char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r','s', 't', 'u', 'v', 'w', 'x','y' ,'z'};
			
		while ( ( input = in.readLine () ) != null ){
				String[] parts = input.split(" ");
				
				int n = Integer.parseInt(parts[0]);
				int size= parts.length;				
				int posicion=0;
				//por palabras
				for (int i=1;i<=(size-1);++i){
				int sizep= parts[i].length();
				// por letras
					for (int j=0;j<sizep;++j){
						//se busca en abc
						for (int k=0;k<26;++k){
							if (parts[i].charAt(j) == abc[k]){
								posicion = k;
								break;
							}
						}
						if (n<=(25-posicion))
							palabras+= abc[posicion+n];
						
							
					}
				output1+= palabras+ " ";
				palabras="";
				}
				output= output1 + "\n";
		}
		

		System.out.print ( output );
		System.out.flush();
		in.close();
		
		}
}
