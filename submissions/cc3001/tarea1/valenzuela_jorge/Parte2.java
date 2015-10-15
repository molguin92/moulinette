package cc3001.tarea1.valenzuela_jorge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	
	public static int SCORE(String D, String T)
	{
		String[] A = new String[(T.length()/2)+1];
		String[] A1 = new String[(D.length()/2)+1];
		char[] B = new char[T.length()];
		char[] B1 = new char[D.length()];
		String StringAuxiliar = new String ("");
		int contadorExterior = 0;
		int c = 0;
		
		for (int d=0; d<T.length(); d++)
		{
			if( T.charAt(d) != ' ') 
			{
				B[contadorExterior] = T.charAt(d);
				StringAuxiliar = new String (B);
				A[c] = StringAuxiliar;
				contadorExterior = contadorExterior+1;
			}
			else
			{
				A[c] = StringAuxiliar;
				contadorExterior = 0;
				B = new char[T.length()];
				c=c+1;
			}
		}
		
		//Con esto se pondrán las palabras de T en un Array (aunque
		//las palabras tendrán caracteres '\u0000' que habría que
		//remover después
		
		contadorExterior = 0;
		c=0;
		
		
		for (int d=0; d<D.length(); d++)
		{
			if( D.charAt(d) != ' ')
			{
				B1[contadorExterior] = D.charAt(d);
				StringAuxiliar = new String (B1);
				A1[c] = StringAuxiliar;
				contadorExterior = contadorExterior+1;
			}
			else
			{
				A1[c] = StringAuxiliar;
				contadorExterior = 0;
				B1 = new char[D.length()];
				c=c+1;
			}
		}
		
		//Con esto se pondrán las palabras de D en un Array (aunque
		//las palabras tendrán caracteres '\u0000' que habría que
		//remover después
		
		for(int k=0; k<A.length && A[k]!= null; k++)
		{
			A[k] = A[k].replace('\u0000', ' ');
			A[k] = A[k].replaceAll(" ", "");
		}
		for(int l=0; l<A.length && A1[l]!= null; l++)
		{
			A1[l] = A1[l].replace('\u0000', ' ');
			A1[l] = A1[l].replaceAll(" ", "");
		}
		
		//A es un array con las palabras de T
		//A1 es un array con las palabras de D
		//queda compararlos y retornar un int la cantidad de elementos que comparten
		
		
		int contadorDePalabras = 0;
		for(int i=0; i<A.length; i++)
		{
			for (int j=0; j<A1.length ; j++)
			{
				if(A[i]!=null && A1[j]!=null)
				{
					if(A1[j].equals(A[i]))
					{
						contadorDePalabras = contadorDePalabras+1;
					}
					
				}
			}
		}
		return contadorDePalabras;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		
		while ((input = in.readLine())!=null)
		{
			String[] inputParts = input.split("\\|");
			int n = SCORE(inputParts[0],inputParts[1]);
			output = String.valueOf(n);
			System.out.println(output);
			System.out.flush();
		}
		in.close();
	}

}
