package cc3001.tarea1.leon_alvaro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Parte3 {	
	public static String CRIPTOANALISIS(String D,String TC)
	{

		int m=0;
		int x=0;
		String c="";
					
	for(int i=26; i>=0; i--)           	
		{
		String t= Parte1.ROT(i, TC);
		int a=Parte2.SCORE(D,t);
		if(a>m)
			{
			m=i;
			c=t;
			x=26-i;
			}
		}
	if (x==0) return "0 "+D;
	return x+" "+c;
	}
	
	public static void main ( String [ ] args ) throws IOException {
	    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
	    String input ;
	    String output = "" ;

	    while ((input = in.readLine ()) != null )
	    	{
			String xd= input.replace("|", "ñ");
	        output += CRIPTOANALISIS(xd.split("ñ")[0],(xd+"ñ").split("ñ")[1]) + "\n";
	    	}
	    System.out.print ( output );
	    System.out.flush ();
	    in.close ();
	    }
}


