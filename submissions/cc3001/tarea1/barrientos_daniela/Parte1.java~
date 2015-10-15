package cc3001.tarea1.barrientos_daniela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Parte1{



public static String ROT(int n, String T){
int l=T.length()-1;
String f="";
for(int i=0;i<=l;i++){
	int car=T.charAt(i);
	if(car>=65 && car<=90 || car>=97 && car<=122){
	if(car>=97 && car<=122-(n%26) || car>=65 && car<=90-(n%26))
	f+=Character.toString ((char)(car+(n%26)));
	else
	f+=Character.toString ((char)(car+(n%26)-26));
	}
	else
	f+=Character.toString ((char)car);
}

return f;
}//ROT




public static void main(String[] args)throws IOException{
BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
String input;
String output="";
while((input=in.readLine())!=null){
	String [] i=input.split(" "); 
	String r="";
	for(int j=1;j<i.length;j++) r+=i[j]+" ";
	output+=ROT(Integer.parseInt(i[0]),r)+"\n";
	}
System.out.print(output);
System.out.flush();
in.close();
}//main



}//Parte 1

