
package cc3001.tarea1.welch_javier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author javierwelch
 */
public class Parte2 {

    private static boolean isInArray(String[] array, String current){
        for (String array1 : array) {
            if (array1.equals(current)) {
                return true;
            }
        }
        
        return false;
    }
    
    private static String[] deleteDuplicates(String[] array){
        String words = array[0];
        for (int j = 1; j < array.length; j++){
            String[] aux = words.split(" ");
            if( !isInArray( aux, array[j])){
                words+= " " + array[j];
            }
        }
        
        String[] filtered = words.split(" ");
        return filtered;
    }
    
    public static int SCORE(String D, String T){
        
        String[] dict = D.split(" ");
        String[] dictionary = deleteDuplicates(dict);
        String[] words = T.split(" ");
        int count = 0;
        
        //Compara cada palabra objetivo con las palabras en el diccionario, si son iguales suma 1
        for(String word : words){
            for(String dictionaryElement : dictionary){
                if (dictionaryElement.equals(word)) count++;
            }
        }
        
        return count;
    }
    
    //Sacado del enunciado de la tarea
    public static void main(String[] args) throws IOException {
   
        //Pretty standard IO routine
        BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
        
        String input;
        String output = "";
        
        //Leemos una linea cmpleta a la vez
        while ( ( input = in.readLine () ) != null ){
            if (input.contains("|")){
                String params[] = input.split( "\\|" );
                output += SCORE( params[0], params[1] ) + "\n";
            }
        }
        
        //Luego lo imprimimos todo de una
        System.out.print ( output );
        System.out.flush ();
        in.close ();
    }
    
}