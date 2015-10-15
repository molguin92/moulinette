package cc3001.tarea1.sepulveda_simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class parte3 {
	
	
	public static int calcula_maximo(int valores[]) {
        int maximo = 0;
        int indice;
        
        for (indice = 0;indice < valores.length; indice++) {
            if(valores[indice]>maximo) {
                maximo = valores[indice];
            }
        }        
        
        return maximo;
    }
	
	
	public static  int BusquedaSecuencial(int vector[], int Elem){
        for (int i = 0; i < vector.length; ++i)
            if (vector[i] == Elem)
                return i;
        return -1;
    }
	
	
	public static String[] CRIPTOANALISIS(String D, String T){
		String dic[] = D.split(" ");
		String cod[] = T.split(" ");
		String respuesta = "";
		String resultado[] = new String[2];
		int puntos[] = new int[26];
		int puntaje = 0;
		int maximo = 0;
		int buscar = 0;
		
		for(int i = 0; i<=25; i++){
			puntaje = parte2.SCORE(parte1.ROT(i, D), T);
			puntos[i] = puntaje;
		}
		maximo = calcula_maximo(puntos);
		int desplazamiento = BusquedaSecuencial(puntos, maximo);
		resultado[0] = Integer.toString(desplazamiento);
		String traduccion[] = parte1.ROT(desplazamiento, D).split(" ");

	
		
		if(cod.length != 1){
			bucle1:
			for(int y = 0; y < traduccion.length; ++y){
				if(traduccion[y].equals(cod[0])){
					buscar = y;
					respuesta += dic[buscar];
					for(int lugar = 1; lugar < cod.length; ++lugar){
						if(buscar + lugar > dic.length){
							break bucle1;
						}
						if(cod[lugar].equals(traduccion[buscar + lugar])){
							respuesta += " " + dic[buscar + lugar];
						}
					}
				}
				if(respuesta.split(" ").length == cod.length){
					break bucle1;
					
				}else{
					respuesta = "";
					continue bucle1;
				}
				
				
			}
		}else{
			for(String e : traduccion){
				if(e.equals(cod[0])){
					respuesta += parte1.ROT(26 - desplazamiento, e);
				}
			}
		}
		
		
		if(respuesta == ""){
			respuesta = T;
		}
		resultado[1] = respuesta;
		
		return resultado;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		String salida[] = new String[2];
		while((input = in.readLine()) != null){
			salida = CRIPTOANALISIS(input.split("\\|")[0], input.split("\\|")[1]);
			output += salida[0] + " " + salida[1] + "\n";
		}
		System.out.print(output);
		System.out.flush();
		in.close();
		
	}
}
