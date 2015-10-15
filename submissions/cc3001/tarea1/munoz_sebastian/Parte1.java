package cc3001.tarea1.Sebastián_Muñoz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {
	public static String ROT(  int m , String S)
	{
	int n = S.length() - 1 ;
	char[] coso = new char[n] ;
	coso = S.toCharArray() ; //crear arreglo del string, la idea es dado que tengo esto
	for (int i = 0 ; i <= n ; i++) //cambiar letra por letra y retornar el string cambiado
	{
		int N = coso[i] ;
		if ('a' <= N && N <= 'z')
		{
			if (N + m <= 'z') //separar los casos en torno a si se excede
			{
				char C = (char)( N + m ) ;
				coso[i] = C ;
			}
			if ( N + m > 'z')
			{
				int M = N + m - 'z' ;
				char C = (char)( 'a' + M - 1 ) ;
				coso[i] = C ;
			}
		}
		if ('A' <= N && N <= 'Z')
		{
			if (N + m <= 'Z')
			{
				char C = (char)( N + m ) ;
				coso[i] = C ;
			}
			if ( N + m > 'Z')
			{
				int M = N + m - 'Z' ;
				char C = (char)( 'A' + M - 1 ) ;
				coso[i] = C ;
			}
		}
	}
	String Coso = new String( coso ) ;
	return Coso ;
	}
	public static void main (String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)) ;
		String input ;
		String output = "" ;
		while ( (input = in.readLine()) != null )
		{
			if (input.equals("")) break;
			String[] S = input.split(" ") ;
			int s = S.length - 1 ;
			int N = Integer.parseInt(S[0]) ;
			String SS = S[1] ;
			if (s > 1)
			{
				for (int i = 2 ; i<= s ; i++)
				{
					SS += " " + S[i] ;
				}
			}
			output += ROT(N,SS) + "\n" ;
		}
		System.out.print(output) ;
		System.out.flush() ;
		in.close() ;
	}
}