package cc3001.tarea1.leon_alvaro;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	public static int SCORE(String t, String d)
		{			

		if(!t.endsWith(" "))	t+=" ";
		if(!d.endsWith(" "))	d+=" ";
		
		int r=0;
		int a = t.length() - t.replace(" ","").length() -1;
		int b = d.length() - d.replace(" ","").length() -1;
		
						
		for(int i=0; i<=a; i++)           	
		{
			int c=0;
			for(int j=0; j<=b && c==0; j++)							
			{
				String q=t.split("\\s+")[i];
				String w=d.split("\\s+")[j];
				if(q.equals(w)) 
				{
					r+=1;
					c=1;
				}
			}
		}
		return r;
		}

public static void main ( String [ ] args ) throws IOException {
    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
    String input ;
    String output = "" ;

    while ((input = in.readLine ()) != null )
    	{
		String xd= input.replace("|", "ñ");
        output += SCORE(xd.split("ñ")[0],(xd+"ñ").split("ñ")[1]) + "\n";
    	}
    System.out.print ( output );
    System.out.flush ();
    in.close ();
    }
}


