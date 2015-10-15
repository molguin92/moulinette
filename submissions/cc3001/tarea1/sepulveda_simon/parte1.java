package cc3001.tarea1.sepulveda_simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class parte1 {
	
	static String abecedario = "abcdefghijklmnopqrstuvwxyz";
	
	
	public static String ROT(int n, String T){
		String resultado = "";
		int largo = T.length();
		boolean mayuscula;
		char traduc;
		String excepciones = "áéíóúñüÁÉÍÓÚÑÜ";
		for (int i = 0; i < largo; i++){
			char c = T.charAt (i);
			if(Character.isLetter(c) && excepciones.indexOf(c) == -1){
				mayuscula = !Character.isLowerCase(c);
				c = Character.toLowerCase(c);
				int lugar = abecedario.indexOf(c);
				if(lugar + n + 1 > abecedario.length()){
					lugar =  (lugar + n) % abecedario.length();
					traduc = abecedario.charAt(lugar);
				}else{
					traduc = abecedario.charAt(lugar + n);
				}
				if(mayuscula){
					traduc = Character.toUpperCase(traduc);
				}
				resultado = resultado + traduc;
			}else{
				resultado = resultado + c;
			}
		}
	    return resultado;
	}

	public static void main(String[] args) throws IOException {
		
			BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
			String input;
			String output = "";
			while((input = in.readLine()) != null){
				String dato[] = input.split(" ");
				int primero = Integer.parseInt(input.split(" ")[0]);
				String segundo = "";
				for(int k = 1; k < dato.length; k++){
					segundo += dato[k] + " ";
				}
				output += ROT(primero, segundo) + "\n";
			}
			System.out.print(output);
			System.out.flush();
			in.close();
			
		//System.out.println(ROT(15, "elevado de vagones"));
	}

}
