package cc3001.tarea1.martin_castillo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import cc3001.tarea1.martin_castillo.Parte1;
import cc3001.tarea1.martin_castillo.Parte2;

public class Parte3 
{
	public static String CRIPTOANALISIS( String D, String T)
	{
		String output = "";
		int n = 0;

		int puntos = 0;
		
		for ( int k=0;k<26;k++ )
		{
			if (Parte2.SCORE(D,Parte1.ROT(26-k,T)) > puntos)
			{
				puntos = Parte2.SCORE(D,Parte1.ROT(26-k,T));
				n = k;
			}
		}
		output = +n+" "+Parte1.ROT(26-n,T);
		return output;
	}
	
	
	public static void main(String[] args) throws IOException
	{
		System.out.println(CRIPTOANALISIS("UNIVERSIDAD DE CHILE DEPARTAMENTO DE CIENCIAS DE LA COMPUTACIÓN ALGORITMOS Y ESTRUCTURAS DE DATOS","PVRAPVNF QR YN PBZCHGNPVÓA"));
	
		System.out.println("Ponga la entrada:");	
		BufferedReader in = new BufferedReader ( new InputStreamReader(System.in ) );
        String input;
        while ( ( input = in.readLine () ) != null )
        {  	
    		if(input.equals("fin"))
    		{
                break;
            }	
    		System.out.println(CRIPTOANALISIS(input.substring(0,input.indexOf("|")),input.substring(input.indexOf("|")+1,input.length())));
    		
        }
	}

}
