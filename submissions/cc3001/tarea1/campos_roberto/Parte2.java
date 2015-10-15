package cc3001.tarea1.campos_roberto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("Ingrese texto donde se buscarán palabras, el separador '|', y palabras a buscar:");
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
			int cont = score(entradaD,entradaT);
			System.out.println(cont);
			System.out.print("Ingrese texto donde se buscarán palabras, el separador '|', y palabras a buscar:");
		}
		System.exit(0);
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
