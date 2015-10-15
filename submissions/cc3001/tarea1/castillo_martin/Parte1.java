package cc3001.tarea1.martin_castillo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 
{
	public static String ROT( int n, String T)
	{
		String output = "";
		for (int i=0;i<T.length();i++)
		{
			if (Character.getNumericValue(T.charAt(i))>9  )
			{
				if (Character.toString(T.charAt(i)).toUpperCase().equals(Character.toString(T.charAt(i))))
				{
					output +=  Character.toString(Character.forDigit( ((Character.getNumericValue(T.charAt(i))-10+n) % 26)+10, 36) ).toUpperCase();
				}
				else
				{
					output += Character.toString(Character.forDigit( ((Character.getNumericValue(T.charAt(i))-10+n) % 26)+10, 36) );
				}
			}
			else
			{
				output += T.charAt(i);
			}
		}
		return output;
	}
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Ponga la entrada:");	
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in ) );
        String input;
        while ( ( input = in.readLine () ) != null )
        {  	
    		if(input.equals("fin"))
    		{
                break;
            }	
        	if (Character.getNumericValue(input.charAt(1)) >= 0)
        	{
            System.out.println ( ROT(Character.getNumericValue(input.charAt(0))*10+Character.getNumericValue(input.charAt(1)),input.substring(3,input.length())) );
        	}
        	else
        	{
        		System.out.println ( ROT(Character.getNumericValue(input.charAt(0)),input.substring(2,input.length())) );
        	}
        }
	}
}
