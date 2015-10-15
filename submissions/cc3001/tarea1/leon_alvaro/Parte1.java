package cc3001.tarea1.leon_alvaro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {	
	public static String ROT(int n, String t)
		{
		String a="abcdefghijklmnopqrstuvwxyz";
		String b="";
		String m= a.toUpperCase();
		
		int k= t.length();   						//k para recorrer string de entrada
		int r= a.length();
		
		for(int i=0; i<k; i++)
			{
			int e=b.length();
			for( int j = 0; j<r; j++)				// entrada						
				{	
				int s=(n+j)%r;
				if(t.charAt(i)==a.charAt(j))		b+=a.charAt(s);

				if(t.charAt(i)==m.charAt(j))		b+=m.charAt(s);
				}
			if (e==b.length())						b+=t.charAt(i);
			}
		return b;
		}

public static void main ( String [ ] args ) throws IOException {
    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
    String input ;
    String output = "" ;

    while ((input = in.readLine ()) != null )
    	{
        output += ROT(Integer.parseInt(input.split(" ")[0]),(input+" ").split(" ")[1]) + "\n";
    	}
    System.out.print ( output );
    System.out.flush ();
    in.close ();
    }
}



