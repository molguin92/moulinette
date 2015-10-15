package cc3001.tarea1.campos_roberto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese texto, el separador '|', y texto codificado a buscar:");
		String input;
		while ((input=in.readLine())!=null) {
			String aux=input;
			int posicion = aux.indexOf("|");
			int largo = aux.length();
			if (largo==0) {break;}
			String aux2 = aux.substring(0,posicion);
			String aux3 = aux.substring(posicion+1,largo);
			String entradaD = aux2.trim();
			String entradaT = aux3.trim();
			String resulta[] = criptoanalisis(entradaD,entradaT);
			System.out.println("["+resulta[0]+","+resulta[1]+"]");
			System.out.print("Ingrese texto, el separador '|', y texto codificado a buscar:");
		}
		System.exit(0);
	}
	
	static String[] criptoanalisis(String D,String T) {
		int contTemp=0,cont=0;
		int cantidadPalabras = score(T,T);
		String resTemp;
		String resultado = T;
		for (int i=1;i<26;i++) {
			String rotado = rot(i,T);
			if (cantidadPalabras==score(D,rotado)) {
				contTemp=26-i;
				resTemp = rotado;
				if( cont == 0 || contTemp<cont ){
					cont=contTemp;
					resultado=resTemp;
				}
			}	
		}
		String retorno[]= {""+cont,resultado};
		return retorno;
	}
	
	public static String rot(int n,String palabra) {
		char[] arregloPalabra = palabra.toCharArray(); //paso la cadena de texto de palabra a un arreglo.
		char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; //se le puede agregar la ñ
		char[] ABC = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; //se le puede agregar la ñ
		char[] aux = new char[palabra.length()];
		for(int i =0;i<palabra.length();i++) {
			for(int j = 0; j < abc.length;j++) {
				if(arregloPalabra[i]==abc[j]) {aux[i]=abc[circular(j,n,abc.length)];break;}
				else if(arregloPalabra[i]==ABC[j]) {aux[i]=ABC[circular(j,n,ABC.length)];break;}
				else {aux[i]=arregloPalabra[i];} //En ninguno de los otros casos, solo dejar igual, no cambiar lo ingresado.
			}
		}
		String aux2 = String.valueOf(aux);
		return aux2.trim(); //limpio de espacios y saltos al inicio y final.
	}
	
	public static int circular( int n, int incremento, int limite ) { //Método para recorrer el abecedario
		if(n+incremento < limite) return n+incremento;
		return n+incremento-limite;
	}
	
	public static int score(String D, String T) {
		String arregloD[] = D.split(" ");
		String arregloT[] = T.split(" ");
		int cont=0;
		for(int i=0;i<arregloT.length;i++) {
			for(int j=0;j<arregloD.length;j++) {
				if (arregloT[i].equals(arregloD[j])) {cont++; break;}
			}
		}
		return cont;	
	}
}
