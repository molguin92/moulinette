package cc3001.tarea1.barrientos_daniela;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Parte2{


public static int SCORE(String D, String T){
String[] dic=D.split(" ");
String[] en=T.split(" ");
int res=0;
for(int i=0; i<en.length;i++){
	if(en[i].compareTo(dic[0])==0) {res++;}
	for(int j=1;j<dic.length && en[i].compareTo(dic[j-1] )!=0;j++){
		if(en[i].compareTo(dic[j])==0) {res++;}
		}
	}

return res;

}//SCORE


public static void main(String[] args)throws IOException{
BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
String input;
String output="";
while((input=in.readLine())!=null){
	String [] i=input.split("\\|");
	output+=SCORE(i[0],i[1])+"\n";
	}
System.out.print(output);
System.out.flush();
in.close();
}//main


}//Parte2