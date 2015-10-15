package cc3001.tarea1.kock_martin;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Parte1 {
	public static String ROT(int N,String T){
		//String bucky[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		
		String abecedario = "abcdefghijklmnopqrstuvwxyz";
		String abecedarioM = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String acentuados = "·ÈÌÛ˙¡…Õ”⁄";
		char letraRot = ' ';
		String palabraRot = "";
		
		for (char c : T.toCharArray()) {
			if (c == ' '){ //si es espacio
				letraRot = ' ';
				palabraRot=palabraRot+Character.toString(letraRot);
			}
			else if (acentuados.indexOf(c)!=-1){
				letraRot = c;
				palabraRot=palabraRot+Character.toString(letraRot);
			}
			else{ 
				int ind = abecedario.indexOf(c) ;
				int indM = abecedarioM.indexOf(c) ;	
				if (Character.isLowerCase(c)) // The character is lowercase
					
				{	
					if (N+ind<=25){
						letraRot=abecedario.charAt(N+ind);
						palabraRot=palabraRot+Character.toString(letraRot);
					}
					else{
						int dif=(N+ind)%26;
						letraRot=abecedario.charAt(dif);
						palabraRot=palabraRot+Character.toString(letraRot);
					}
				 
				}
				else if (Character.isUpperCase(c)){ // si c es mayuscula
					if (N+indM<=25){
						letraRot=abecedarioM.charAt(N+indM);
						palabraRot=palabraRot+Character.toString(letraRot);
					}
					else{
						int dif=(N+indM)%26;
						letraRot=abecedarioM.charAt(dif);
						palabraRot=palabraRot+Character.toString(letraRot);
					}
				}
				
				else {
					letraRot=c;
					palabraRot=palabraRot+Character.toString(letraRot);
					//System.out.println("·");
				}
				
				}
				}
			
			return palabraRot;	
			}
			
	public static void main (	String [ ]	args )throws IOException {
	    BufferedReader in = new BufferedReader ( new InputStreamReader ( System.in ) );
	    String input ;
	    String output = "" ;
	    //leemos una linea completa a la vez
	    System.out.println ("escribe algo o escribe fin " );
	    while ((input = in.readLine ()) != null ) {
	        if(input.equals("fin")){
	            break;
	        }
	        output += ROT(Integer.parseInt(input.split(" ")[0]),input.substring(2)) + "\n";
	        //output += input + "\n";
	        System.out.println (ROT(Integer.parseInt(input.split(" ")[0]),input.substring(2)) + "\n" );
	        System.out.println ("escribe algo o escribe fin " );
	    }
	    //luego lo imprimimos todo de una
	    System.out.print ( output );
	    System.out.flush ();
	    in.close ();
	    System.out.println("termine");
	    }
	}

