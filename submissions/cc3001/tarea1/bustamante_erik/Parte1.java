package cc3001.tarea1.bustamante_erik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {

	/**
	 * @param args
	 */
	public static String ROT(int n, String T)
	{
		char[] alfabetominus = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] alfabetomayus = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		Boolean cambiar;
		String output="";
		char[] palabra = T.toCharArray();
		for(int i=0; i< palabra.length; i++)
		{
			cambiar = false;
			for(int k=0; k<26; k++)
			{
				if(palabra[i]==alfabetominus[k])
				{
					if(k+n>25)
						{
						if(n/25==0)
						{
							output = output + alfabetominus[k+n-(25+1)];
						}
						else
						{
							output = output + alfabetominus[k+n-(n/25)*(25+1)];
						}
						cambiar = true;
						k=25;
						}
					else
					{
						if(k+n<0)
						{
							output = output + alfabetominus[25+(k+n+1)];
						}
						else
						{
							output = output + alfabetominus[k+n];
						}
						cambiar = true;
						k=25;
					}
				}
				if(palabra[i]==alfabetomayus[k])
				{
					if(k+n>25)
						{
						if(n/25==0)
						{
							output = output + alfabetomayus[k+n-(25+1)];
						}
						else
						{
							output = output + alfabetomayus[k+n-(n/25)*(25+1)];
						}
						cambiar = true;
						k=25;
						}
					else
					{
						if(k+n<0)
						{
							output = output + alfabetomayus[25+(k+n+1)];
						}
						else
						{
							output = output + alfabetomayus[k+n];
						}
						cambiar = true;
						k=25;
					}
				}
			}
			if(cambiar==false)
				{
					output = output + palabra[i];
				}
		}
		return output;
	}
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		// Pretty standard IOroutine
		
		String input = "" ;
		String output = "" ;
		String temp[];
		String temp2[];
		String delimiter=" ";
		int n=0;
		int pasos=0;
		int largo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// leemos una linea completa a la vez
		while ((input = br.readLine()) != null )
		{
			if (n==0)
			{
				temp = input.split(delimiter,2);
				pasos= Integer.parseInt(temp[0]);
				temp2 = temp[1].split(delimiter);
				largo = temp2.length;
				for(int i =0; i < largo ; i++)
				{
					if(i<largo-1)
					{
						output += ROT (pasos, temp2[i] ) + " " ;
					}
					else
					{
						output += ROT (pasos, temp2[i] );	
					}
				}
				n=n+1;
			}
			else
			{
				temp2 = input.split(delimiter);
				largo=temp2.length;
				output=output + "\n";
				for(int i =0; i < largo ; i++)
				{
					if(i<largo -1)
					{
						output += ROT (pasos, temp2[i] ) + " " ;
					}
					else
					{
						output += ROT (pasos, temp2[i] );	
					}
				}
			}
		// juntamos todo el output en un string
		}
		// luego lo imprimimos todo de una
		System.out.print(output);
		System.out.flush( );
		br.close();
	}

}
