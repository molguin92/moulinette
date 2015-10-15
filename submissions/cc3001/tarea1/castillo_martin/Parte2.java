package cc3001.tarea1.martin_castillo;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Parte2 
{
	public static int SCORE( String D, String T)
	{
		List<Integer> dd = new ArrayList<Integer>();
		List<Integer> tt = new ArrayList<Integer>();
		tt.add(-1);
		dd.add(-1);
		
		for (int i=0;i<D.length();i++)
		{
			if (Character.toString(D.charAt(i)).equals(" "))
			{
				dd.add(i);
			}
		}
		
		for (int i=0;i<T.length();i++)
		{
			if (Character.toString(T.charAt(i)).equals(" "))
			{
				tt.add(i);
			}
		}

		dd.add(D.length());
		tt.add(T.length());
		
		
		int contador = 0;
		
		for (int i=1;i<dd.size();i++)
		{
			int aux = 0;
			
			for (int j=1;j<tt.size();j++)
			{
				if ( D.substring(dd.get(i-1)+1,dd.get(i)).equals(T.substring(tt.get(j-1)+1,tt.get(j)) ) )
				{
					aux = 1;
				}
			}
			contador = contador + aux;
		}
		
		
		//System.out.println(dd);
		//System.out.println(tt);
		
		return contador;
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
    		System.out.println(SCORE(input.substring(0,input.indexOf("|")),input.substring(input.indexOf("|")+1,input.length())));
    		
        }
	}

}
