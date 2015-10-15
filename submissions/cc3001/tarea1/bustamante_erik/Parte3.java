package cc3001.tarea1.bustamante_erik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Parte3 {
	public static String CRIPTOANALISIS(String D, String T)
	{
		String output="";
		int num=0;
		String temp[];
		String temp2[];
		String delimiter = " ";
		temp = D.split(delimiter);
		temp2 = T.split(delimiter);
		for(int i=0; i<temp.length;i++)
		{
			for(int k=0; k<temp2.length; k++)
			{
				for(int n=0; n<26;n++)
				{
					if(temp2[k].equals(Parte1.ROT(n, temp[i])))
					{
						num=n;
						n=26;
						k=temp2.length;
					}
				}
			}
		}
		output=output + num;
		for(int i=0; i<temp2.length;i++)
		{
			output=output + " " + Parte1.ROT(-num, temp2[i]);
		}
		return output;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String input;
		String output="";
		String temp[];
		String delimiter=Pattern.quote("|");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// leemos una linea completa a la vez
		while ((input = br.readLine()) != null )
		{
			temp = input.split(delimiter,2);
			output = output + CRIPTOANALISIS(temp[0],temp[1]);
		}
		System.out.print(output);
		System.out.flush( );
		br.close();
	}

}
