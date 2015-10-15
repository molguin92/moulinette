package cc3001.tarea1.Sebastián_Muñoz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	public static String[] CRIPTOANALISIS ( String D , String T )
	{
		String[] M = new String[2] ;
		M[0] = "0" ; M[1] = T ; int n = 0 ; //guardamos el mínimo n
		for (char a = 'a' ; a <= 'z' ; ++a) // no sé cuántas letras son... just in case
		{
		int l = a - 'a' ;
		int k = Parte2.SCORE(T,Parte1.ROT(l,D)) ;
		if (k > n)
		{
			n = k ;
			String L = Integer.toString(l) ;
			M[0] = L ;
			int J = 'z' - 'a' - l + 1 ;
			M[1] = Parte1.ROT(J,T) ;
			a = 'z' + 1 ;
		}
		}
		return M ;
	}
	public static void main (String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		String input ;
		String output = "" ;
		while ( (input = in.readLine()) != null )
		{
			if (input.equals("")) break;
			String[] S = input.split("\\|") ;
			String[] SS = CRIPTOANALISIS(S[0],S[1]) ;
			output += SS[0] + " " + SS[1] + "\n" ;
		}
		System.out.print(output) ;
		System.out.flush() ;
		in.close() ;
	}
}
// UNIVERSIDAD DE CHILE DEPARTAMENTO DE CIENCIAS DE LA COMPUTACIÓN ALGORITMOS Y ESTRUCTURAS DE DATOS|NYTBEVGZBF L RFGEHPGHENF QR QNGBF