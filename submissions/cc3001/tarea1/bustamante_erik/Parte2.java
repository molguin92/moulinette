package cc3001.tarea1.bustamante_erik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Parte2 {
	public static int SCORE(String D, String T)
	{
		int total=0;
		boolean sumar;
		String temp[];
		String temp2[];
		String delimiter = " ";
		temp = D.split(delimiter);
		temp2 = T.split(delimiter);
		for(int i=0; i<temp2.length;i++)
		{
			sumar = false;
			for(int k=0; k<temp.length;k++)
			{
				if(temp2[i].equals(temp[k]))
				{
					sumar = true;
				}
			}
			if(sumar==true)
			{
				total = total +1;
			}
		}
		return total;
	}
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		String input;
		int output = 0;
		String temp[];
		String delimiter=Pattern.quote("|");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// leemos una linea completa a la vez
		while ((input = br.readLine()) != null )
		{
			temp = input.split(delimiter,2);
			output = output + SCORE(temp[0],temp[1]);
		}
		System.out.print(output);
		System.out.flush( );
		br.close();
	}

}
