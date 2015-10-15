package cc3001.tarea1.Sebastián_Muñoz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	public static int SCORE( String D , String T)
	{
		int i = 0 ; //nuestro contador
		String[] d = D.split(" ") ;
		String[] t = T.split(" ") ;
		int nd = d.length - 1;
		int nt = t.length - 1;
		for (int j = 0 ; j <= nd ; j++)
		{
			for (int k = 0 ; k <= nt ; k++)
			{
				if ( (d[j]).equals(t[k]) )
				{
					i++ ;
				}
			}
		}
		return i ;
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
			output += SCORE(S[0],S[1]) + "\n" ;
		}
		System.out.print(output) ;
		System.out.flush() ;
		in.close() ;
	}
}