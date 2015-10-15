package cc3001.tarea1.valenzuela_jorge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {
	
	public static String ROT( int n, String T ){
		
		if (T.equals("")) return "";
		
		char[] d={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char[] D={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int lengthT = T.length();
		char[] ROTchar = new char[lengthT];
		boolean verificador = false;
		for(int c=0 ; c<lengthT ; c++)
		{
			char charat = T.charAt(c);
			for(int c2=0 ; c2<26 ; c2++)
			{
				if(c2 == 0)
				{
					verificador = false;
				}
				if( charat == d[c2] ){
					ROTchar[c] = d[(c2+n)%26];
					verificador = true;
				}
				if( charat == D[c2] ){
					ROTchar[c] = D[(c2+n)%26];
					verificador = true;
				}
				if(!verificador)
				{
					ROTchar[c] = charat;
				}
			}
		}
		String M = new String(ROTchar);
		return M;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Pretty standard IO routine
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
				String input;
				String output = "";
				
				while ((input = in.readLine())!=null)
				{
					String[] inputParts = input.split(" ");
					int n = Integer.parseInt(inputParts[0]);
					String Stringoutput = "";
					for (int ii=1 ; ii<inputParts.length ; ii++)
					{
						if (ii==1)
						{
							Stringoutput = inputParts[ii];
						}
						else
						{
							Stringoutput = Stringoutput+" "+inputParts[ii];
						}
					}
					output = ROT(n,Stringoutput)+"\n";
					System.out.println(output);
					System.out.flush();
				}
				in.close();
		
	}
	
}