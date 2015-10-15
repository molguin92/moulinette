package cc3001.Tarea1.Ruiz_Mario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {
	
	public static String letra(int posicion, String palabra)
	{
		String subpalabra=palabra.substring(posicion-1,posicion);
		return subpalabra;
	}
		
	public static String ROT(int n, String T)
	{
		if(n>26)
		{
			while(true)
			{
				n=n-26;
				if (n<=26)
					break;
				
			}
		}
		String abc="abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		String ABC="ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String aux="";
		int largo=T.length();
		int k=1;
		while(k<=largo)
		{
			int j=1;
			while (j<=abc.length()/2)
			{
				if(letra(k,T).equals(letra(j,abc)))
					aux=aux.concat(letra(j+n,abc));
				else if(letra(k,T).equals(letra(j,ABC)))
					aux=aux.concat(letra(j+n,ABC));
				else if(j==abc.length()/2 && aux.length()!=k)
					aux=aux.concat(letra(k,T));
				j=j+1;
			}
			k=k+1;
		}
		return aux;
	}

	public static void main( String[] args)throws IOException {
		BufferedReader in=new BufferedReader( new InputStreamReader(System.in));
		String input;
		String output="";
		while((input=in.readLine())!=null)//control d
		{
			int pos=input.indexOf(" ");
			int sub1=Integer.parseInt(input.substring(0,pos));
			String sub2=input.substring(pos+1);
			output+=Parte1.ROT(sub1,sub2)+"\n";
		}
		System.out.print(output);
		System.out.flush();
		in.close();
	}

}
