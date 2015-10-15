package cc3001.tarea1.cristobal_piquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	public static String ROT(int n, String T) {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		String ABC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder Tprima=new StringBuilder(T);
		int i=0;
		
		while(i<Tprima.length()){
			int pos=abc.indexOf(Tprima.charAt(i));
			if (pos != -1){
				pos=(pos+n)%abc.length();
				Tprima.setCharAt(i, abc.charAt(pos));
			}
			pos=ABC.indexOf(Tprima.charAt(i));
			if (pos != -1){
				pos=(pos+n)%ABC.length();
				Tprima.setCharAt(i, ABC.charAt(pos));
			}
			i++;
		}
		return Tprima.toString();
	}

	private static boolean Busca(String palabra, String D){
		int i=0;
		int n=D.length();
		int indiceD;
		String Dprima;
		
		while (i<n){
			if (D.indexOf(" ",i)!=-1){
				indiceD=D.indexOf(" ",i);
				Dprima=D.substring(i, indiceD);
				i=indiceD+1;
				if (Dprima.equals(palabra)){
					return true;
				}
			}
			else{Dprima=D.substring(i);
			i=n;
			if (Dprima.equals(palabra)){
				return true;
			}
		}
	}
	return false;
	}
	
	public static int SCORE(String D, String T) {
		int i=0;
		int n=T.length();
		int valor;
		String Tprima;
		int count = 0;
		
		while (i<n){
			if (T.indexOf(" ", i)!=-1){
				valor=T.indexOf(" ",i);
				Tprima=T.substring(i, valor);
				i=valor+1;
				//System.out.println("palabra = " + Tprima + ";");

			
				if (Busca(Tprima, D)){
					count++;
				}
			}
			else{Tprima=T.substring(i);
			i=n;
			//System.out.println("palabra = "+ Tprima + ";");
			if (Busca(Tprima, D)){
				count++;
			}
			}
			}
	return count;
	}
	




//------------------------------------------------------------------------------------------------




	public static Object[] CRIPTOANALISIS(String Dic, String Tex){
		int i=0;
		int maxscore=0;
		int nmax=0;
		int Sc;
		String Texto;
		Object results[]=new Object[2];
		
		while(i<26){
			Sc=SCORE(Tex, ROT(i, Dic));
			if (Sc>maxscore){
				maxscore=Sc;
				nmax=i;				
			}
			i++;
			
		}
		
		Texto=ROT(26-nmax,Tex);

		results[0] = new Integer(nmax); 
		results[1] = Texto; 
		return results;

}

	//------------------------------------------------------------------------------------------------
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader ( new InputStreamReader( System.in ) );
		String input;
		String[] valores = new String[2];
		Object res[];
		
		while ( ( input = in.readLine () ) != null ){
			valores=input.split("\\|", 2);
			
			res = CRIPTOANALISIS(valores[0],valores[1]);
			System.out.println((Integer)res[0]+" "+(String)res[1]);

	
		}
	}
}
	







