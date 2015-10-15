package cc3001.tarea1.cristobal_piquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {
	public static String ROT(int n, String T) {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder Tprima=new StringBuilder(T);
		int i=0;
		while(i<Tprima.length()){
			int pos=abc.indexOf(Tprima.charAt(i));
			if (pos != -1){
				pos=(pos+n)%abc.length();
				Tprima.setCharAt(i, abc.charAt(pos));
			}
			pos=ABC.indexOf(Tprima.charAt(i));
			if (pos != -1){
				pos=(pos+n)%ABC.length();
				Tprima.setCharAt(i, ABC.charAt(pos));
			}
			i++;
		}
		return Tprima.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader( System.in ) );
		String input;
		String[] valores = new String[2];
		
		while ( ( input = in.readLine () ) != null ){
			valores=input.split(" ", 2);
			int M = Integer.parseInt(valores[0]);
			System.out.println(ROT(M, valores[1]));

		}
	}

}
