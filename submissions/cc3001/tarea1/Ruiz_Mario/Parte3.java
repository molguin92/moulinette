package cc3001.Tarea1.Ruiz_Mario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	public static String CRIPTOANALISIS(String D, String T)
	{
		int k;
		int j=0;
		int m=0;
		int n=0;
		String aux;
		Parte1 p1=new Parte1();
		Parte2 p2=new Parte2();
		for(k=1;k<26;k++)
		{
			aux=p1.ROT(k, D);
			j=p2.SCORE(T,aux);
			if(j>m)
			{
				m=j;
				n=k;
			}
		}
		aux=n+" "+p1.ROT(26-n, T);
		return aux;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String input;
		String output="";
		while((input=in.readLine())!=null)
		{
			String[] parts = input.split("\\|");
			output+=Parte3.CRIPTOANALISIS(parts[0],parts[1])+"\n";
		}
		System.out.print(output);
		System.out.flush();
		in.close();
	}

}
