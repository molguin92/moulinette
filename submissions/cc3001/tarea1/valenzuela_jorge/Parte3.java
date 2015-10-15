package cc3001.tarea1.valenzuela_jorge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	
	public static String[] CRIPTOANALISIS(String D, String T)

	{
		int[] ints = new int[26];
		String[] Strings = new String[26];
		
		//usar estos arrays de int y String para guardar los resultados
		//de SCORE y ROT aplicados a los elementos de la función
		
		for (int i=0 ; i <26; i++)
		{
			Strings[i]=Parte1.ROT(i, T);
		}
		
		for (int j=0 ; j<26; j++)
		{
			ints[j]=Parte2.SCORE(D, Strings[j]);
		}
		
		//Teniendo ambos arrays sólo queda encontrar el máximo int n y
		//se deberá retornar un array con n y el string ROTn(T)
		
		int max;
		max = ints[0];
		int valorArrayMax=0;
		
		for (int k=0; k<(ints.length-1) ; k++)
		{
			if (max < ints[k+1])
			{
				max = ints[k+1];
				valorArrayMax = k+1;
			}
		}
		
		String StringMax = String.valueOf(valorArrayMax);
		
		String[] ReturnArray = {StringMax,Strings[valorArrayMax]};
		return ReturnArray;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		
		while ((input = in.readLine())!=null)
		{
			String[] inputParts = input.split("\\|");
			String D = inputParts[0];
			String Talt = inputParts[1];
			String ArrayResultados[] = CRIPTOANALISIS(D,Talt);
			output = ArrayResultados[0]+" "+ArrayResultados[1];
			System.out.println(output);
			System.out.flush();
		}
		in.close();
	}

}
