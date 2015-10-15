package cc3001.Tarea1.Ruiz_Mario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	
	public static int comparar(String D, String t)
	{
		int k;
		int j;
		int aux=0;
		int x=0;
		Parte1 p=new Parte1();
		for(k=1;k<=D.length();k++)
		{
			if (p.letra(k,D).equals(" "))
			{
				if(t.length()==k-aux-1)
				{
					for(j=1;j<=t.length();j++)
					{
						if(p.letra(j,t).equals(p.letra(aux+j,D)))
						{
							if(j==t.length())
								x=x+1;
						}
						else
							break;
					}
				}
				aux=k;
			}
			
			else if (k==D.length())
			{
				if(t.length()==k-aux)
				{
					for(j=1;j<=t.length();j++)
					{
						if(p.letra(j,t).equals(p.letra(aux+j,D)))
						{
							if(j==t.length())
								x=x+1;
						}
						else
							break;
					}
				}	
			}
		}
		return x;
	}
	
	public static int SCORE( String D, String T)
	{
		int k;
		int h=0;
		int nn=0;
		String aux="";
		Parte1 p=new Parte1();
		for(k=1;k<=T.length();k++)
		{
			if(!p.letra(k,T).equals(" "))
				aux=aux.concat(p.letra(k,T));
			if(p.letra(k,T).equals(" "))
			{
				h=comparar(D,aux);
				nn=nn+h;
				h=0;
				aux="";
			}
			if (k==T.length())
			{
				h=comparar(D,aux);
				nn=nn+h;
				h=0;
				aux="";
			}
		}
		return nn;
	}

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String input;
		String output="";
		while((input=in.readLine())!=null)
		{
			String parts[] = input.split("\\|");
			output+=Parte2.SCORE(parts[0],parts[1])+"\n";
		}
		System.out.print(output);
		System.out.flush();
		in.close();
	}

}
