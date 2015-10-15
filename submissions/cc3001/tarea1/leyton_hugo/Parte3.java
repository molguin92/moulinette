package cc3001.tarea1.leyton_hugo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	public static String CRIPTOANALISIS(String D,String T){
		String d  =  "abcdefghijklmnopqrstuvwxyz";
		int u=0;
		String uu="";
		for(int i=0;i<d.length(); i++){
			if(0<Parte2.SCORE(D,Parte1.ROT(-i,T))){
				if(u==0 && Parte2.SCORE(D,Parte1.ROT(-i,T))!=0){
					u=i;
					uu=Parte1.ROT(-i,T);}
				if(u>Parte2.SCORE(D,Parte1.ROT(-i,T))){
					u=i;
					uu=Parte1.ROT(-i,T);}}}
		String uuu=Integer.toString(u);
		if(uu==""){
			if(u==0){
				uu=T;}}
		return uuu+" "+uu;
		}
public static void main ( String [ ] args ) throws IOException { 
	BufferedReader in = new BufferedReader ( new InputStreamReader ( System . in ) ); 
	String input; 
	String output = "" ;
	while ( (input = in.readLine())!= null){
		if (input.equals("")){break ;}
		String D=input.split("\\|")[0];
		String T=input.split("\\|")[1];		
		output = output + CRIPTOANALISIS(D,T)+"\n" ; }
	System . out . print ( output ); System.out.flush (); in . close ();
	}
}