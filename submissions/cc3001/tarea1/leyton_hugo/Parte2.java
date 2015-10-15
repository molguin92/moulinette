package cc3001.tarea1.leyton_hugo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {
	public static int SCORE(String D,String T){
		//Insertar en la matriz los indices de los espacios de T y D
		String[] DD=D.split(" ");
		String[] TT=T.split(" ");
		int a=0;
		for(int i=0;i< DD.length;i++){
			for(int j=0;j< TT.length;j++){
				if((DD[i]).equals(TT[j]))
					a++;}} 
		return a;
		}
		
public static void main ( String [ ] args ) throws IOException { 
	BufferedReader in = new BufferedReader ( new InputStreamReader ( System . in ) ); 
	String input ; 
	String output = "" ;
	while ( (input = in.readLine())!= null){
		if (input.equals("")){break ;}
		String D=input.split("\\|")[0];
		String T=input.split("\\|")[1];		
		output = output + Integer.toString(SCORE(D,T)) + "\n" ; }
	System . out . print ( output ); System.out.flush (); in . close ();
	}
}