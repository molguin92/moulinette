package cc3001.tarea1.barrientos_daniela;
import cc3001.tarea1.barrientos_daniela.Parte1;
import cc3001.tarea1.barrientos_daniela.Parte2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3{



public static String CRIPTOANALISIS(String D,String T){
int n=0;
int max=0;
Parte2 S=new Parte2();
Parte1 R=new Parte1();
for(int i=0; i<26;i++){

	if(S.SCORE(R.ROT(i,D),T)>max) {
		max=S.SCORE(R.ROT(i,D),T);
		n=i;
		}

	}
if(n!=0)
return n+" "+R.ROT(26-n,T);
return "0 "+D;
}//CRIPTO



public static void main(String[] args)throws IOException{
BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
String input;
String output="";
while((input=in.readLine())!=null){
	String [] i=input.split("\\|");
	output+=CRIPTOANALISIS(i[0],i[1])+"\n";
	}
System.out.print(output);
System.out.flush();
in.close();
}//main


}//Parte3
