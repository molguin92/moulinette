package cc3001.tarea1.eduardo_soto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte2 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		
		// se lee una linea completa a la vez:
		//System.out.println ("escribe algo o escribe fin " ); // TEST 
		while ((input =in.readLine())!= null){
			/*if(input.equals("fin")){ // test
	            break; // test
	        } */// test
			String[] parts = input.split("\\|",2); //divide el string en 2 partes, divisor: "|"
			String part1 = parts[0]; // string 1 aqui.
			String part2 = parts[1]; //resto del string aqui.
			
			
			//se junta todo el output en un string
			output += SCORE(part1, part2)+"\n";
			
		}
		
		//luego se imprime todo junto.
		System.out.print(output);
		System.out.flush();
		in.close();

	}
	
	public static int SCORE(String Di, String Tex){  
		int resultado =0; //inicializo resultado contador
		
		String Diccionario[]= Di.split(" ");
		String Texto[]=Tex.split(" ");


		for (int i=0; i<Texto.length;i++){ //recorre las palabras del texto ingresado.
			for (int j=0; j<Diccionario.length; j++){ //recorre las palabras del diccionario.

				if (Texto[i].equals(Diccionario[j])){ //caso en que encuentra palabra del texto en diccionario.
					resultado=resultado+1; //suma 1 a el contador.
					break; //rompe el ultimo for para que no busque mas.
				}
			}	
		}
		
		return resultado; //retorno el resultado entero.
	}
}
	