package cc3001.tarea1.campos_roberto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte1 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese número entero y palabra a codificar:");
		String entrada;
		while ((entrada=in.readLine())!=null) {
			int numero = sacaNumero(entrada);
			if(numero<0){
	        	break;
	        }
	        String palabra = sacaPalabra(entrada);
	        String resultado = rot(numero,palabra);
	        System.out.println(resultado);
	        System.out.print("Ingrese número entero y palabra a codificar:");
		}
		System.exit(0);
	}
	
	public static int sacaNumero(String T) {
		int posicion = T.indexOf(' ');
		if(posicion<1) return -1;
		String numero = T.substring(0,posicion);
		int n= Integer.parseInt(numero);
		return n;
	}
	
	public static String sacaPalabra(String T) {
		int largo = T.length();
		int posicion = T.indexOf(' ');
		String palabra = T.substring(posicion,largo);
		String Pal = palabra.trim();
		return Pal;
	}
	
	public static String rot(int n,String palabra) {
		char[] arregloPalabra = palabra.toCharArray(); //paso la cadena de texto de palabra a un arreglo.
		char[] abc = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};//se le puede agregar la ñ
		char[] ABC = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};//se le puede agregar la ñ
		char[] aux = new char[palabra.length()];
		for(int i =0;i<palabra.length();i++) {
			for(int j = 0; j < 26;j++) {
				if(arregloPalabra[i]==abc[j]) {aux[i]=abc[circular(j,n,26)];break;}
				else if(arregloPalabra[i]==ABC[j]) {aux[i]=ABC[circular(j,n,26)];break;}
				else {aux[i]=arregloPalabra[i];} //En ninguno de los otros casos, solo dejar igual, no cambiar lo ingresado.
			}
		}
		String aux2 = String.valueOf(aux);
		return aux2.trim(); //limpio de espacios y saltos al inicio y final.
	}
	
	static int circular( int n, int incremento, int limite ) { //Método para recorrer el abecedario
		if(n+incremento < limite) return n+incremento;
		return n+incremento-limite;
	}
}
	
