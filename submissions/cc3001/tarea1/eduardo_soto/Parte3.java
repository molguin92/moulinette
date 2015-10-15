package cc3001.tarea1.eduardo_soto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parte3 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		
		// se lee una linea completa a la vez:
		//System.out.println ("escribe algo o escribe fin " ); // TEST 
		while ((input =in.readLine())!= null){
			/*if(input.equals("fin")){ // test
	            break; // test
	        } */ // test
			String[] parts = input.split("\\|",2); //divide el string en 2 partes, divisor: "|"
			String part1 = parts[0]; // string 1 aqui.
			String part2 = parts[1]; //resto del string aqui.
			
			
			//se junta todo el output en un string
			String numero= CRIPTOANALISIS(part1, part2)[0];
			String resto= CRIPTOANALISIS(part1, part2)[1];
			int numeroF = Integer.parseInt(numero);
			output += numeroF+" "+resto+"\n";
			
		}
		
		//luego se imprime todo junto.
		System.out.print(output);
		System.out.flush();
		in.close();

	}
	
	static char [] ABE = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'}; 
	// crea lista abecedario en MAYUS, indices de 0 a 25 (26 letras)

	static char [] abe = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'}; 
	// crea lista abecedario en minus, indices de 0 a 25 (26 letras)
	
	public static String[] CRIPTOANALISIS(String Di, String TexCod){ 
		int n=0;
		String Diccionario[]= Di.split(" ");
		String TextoCod[]=TexCod.split(" ");
		int NumPalTex= TextoCod.length; //guarda el numero de palabras que contiene el texto codificado.
		int NumPalDi = Diccionario.length; // guarda numero de palabras del diccionario.
		char [] textoINV = new char [TexCod.length()]; 
		// se crea un arreglo donde se guardara el resultado de la rotacion de caracteres.
		
		int posicion=0;
		int posiciont=0;
		int posiciond=0;
		
		char [] texto = TexCod.toCharArray(); // se crea el arreglo texto en base al string TexCod
		//char [] dic = Di.toCharArray(); // se crea el arreglo texto en base al string TexCod
		

		//int test = Diccionario[indiceDiccionario].length();
		
		if (NumPalDi>=NumPalTex){ //caso en que es posible que el texto ingresado este en el diccionario.
			
			for (int i=0; i<NumPalDi-NumPalTex+1;i++){
				String cadenaDi="";

				int contador=0; // contador
				for(int j=0; j<NumPalTex;j++){
					if(Diccionario[j+i].length()==TextoCod[j].length()){ 
						//entra ssi los largos de las palabras coinciden.
						
						contador=contador+1;
					}
					if (contador==NumPalTex){ //condicion de que todas las palabras tienen el mismo largo.
						// se procede a encontrar N:
						int n1=0;
						
						char [] dic = Diccionario[i].toCharArray(); // se crea el arreglo texto en base al string TexCod
						if (Character.isUpperCase(texto[0])==Character.isUpperCase(dic[0]) || Character.isLowerCase(texto[0])==Character.isLowerCase(dic[0])){
							//condicion de que al menos la primera letra estan ambas en mayuscula o ambas en minuscula.
							posiciont= entregarPosicion(texto); //posicion de 1er caracter de texto en abecedario.
							posiciond=entregarPosicion(dic);//posicion de 1er caracter de dic en abecedario.
							
							if(posiciont>=posiciond){
								n1=26-(posiciont-posiciond);
							}else{
								n1=posiciond-posiciont;
							} //n1= la cantidad de veces minima que se rota para llegar a letras iguales.
						}//llamar a funcion rot de la clase Parte1:
						Parte1 cls = new Parte1();
						textoINV=cls.ROT(n1,TexCod).toCharArray(); //consigue el texto convertido y lo pasa a un arreglo de caracteres.
						for (int g=0; g<NumPalTex;g++){
							if (g==NumPalTex-1){
								cadenaDi=cadenaDi+Diccionario[i+g];
							}else{
							cadenaDi=cadenaDi+Diccionario[i+g]+" ";
							}
						}
						String resultado = new String(textoINV); //convierte el arreglo de texto a string.
						
						//ahora se compara el resultado obtenido con las palabras del diccionario.
						/*if(n1==26){
							n1=0;
							}*/
						if (resultado.equals(cadenaDi)){
							int nf=0;
							nf=Math.abs(n1-26);
							String nfinal = Integer.toString(nf);
								return new String[] {nfinal,resultado};
							}
						}
					}
				}
			}
		else { n=0; //caso en que el texto ingresado no quepa en el diccionario.
		
			}
		String nfinal1 = Integer.toString(n);
		return new String[] {nfinal1,TexCod}; //retorna arreglo con 2 strings
	}
	
	
	
	
	static int entregarPosicion(char[] texto){
		// funcion que entrega la posicion en el abecedario del primer caracter de texto.
		int pos=0;

		if (Character.isUpperCase(texto[0])){ //entra ssi el caracter esta en mayuscula.
	
			for (int m=0; m< ABE.length ; m++){ //recorre el arreglo ABE (mayus)
		
				if(ABE[m]==texto[0]){ // condicion de que los caracteres son iguales.
			
					pos = m; 
					//indica la posicion final del primer caracter del texto en el ABECEDARIO.
			
			}
		}
	}

		else { // caso en que el caracter esta en minuscula.
	
			for (int m=0; m< abe.length ; m++){ //recorre el arreglo abe (minus)
		
				if(abe[m]==texto[0]){ // condicion de que los caracteres son iguales.
			
					pos = m; 
					//indica la posicion final del primer caracter del texto en el ABECEDARIO.
			
			
			}
		}
	}
		return pos; //retorna la posicion del caracter en el abecedario.
	}
	
}
