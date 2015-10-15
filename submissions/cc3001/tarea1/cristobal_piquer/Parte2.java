package cc3001.tarea1.cristobal_piquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	private static boolean Busca(String palabra, String D){
		int i=0;
		int n=D.length();
		int indiceD;
		String Dprima;

		
		while (i<n){
			if (D.indexOf(" ",i)!=-1){
				indiceD=D.indexOf(" ",i);
				Dprima=D.substring(i, indiceD);
				i=indiceD+1;
				if (Dprima.equals(palabra)){
					return true;	
				}
			}
			else{Dprima=D.substring(i);
			i=n;
				if (Dprima.equals(palabra)){
					return true;
			
			}
		}
		
	}	
return false;
		
}

	public static int SCORE(String D, String T) {
		int i=0;
		int n=T.length();
		int valor;
		String Tprima;
		int count = 0;
		
		while (i<n){
		if (T.indexOf(" ", i)!=-1){ 
			valor=T.indexOf(" ",i);
			Tprima=T.substring(i, valor);
			i=valor+1;
			//System.out.println("palabra = " + Tprima + ";");

		
			if (Busca(Tprima, D)){
				count++;
			}
		}
		else{Tprima=T.substring(i);
		i=n;
		//System.out.println("palabra = "+ Tprima + ";");
		if (Busca(Tprima, D)){
			count++;
		}
		}
		}


return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader( System.in ) );
		String input;
		String[] valores = new String[2];
		
		while ( ( input = in.readLine () ) != null ){
			valores=input.split("\\|", 2);
			
			System.out.println(SCORE(valores[0], valores[1]));
		}
	}
}
