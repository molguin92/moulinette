
package cc3001.tarea1.welch_javier;

/**
 *
 * @author javierwelch
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
        
public class Parte1 {
    
    //Revisa si un char pertenece a un char array
    private static boolean isInArray( char[] array , char current){
        for ( char c : array ){
            if( current == c){
                return true;
            }
        }
        return false;
    }
    
    //Entrega el índice de un char dentro de un array, si no lo encuentre devuelve -1
    private static int findIndex( char[] array, char current){
        for (int j = 0; j< array.length; j++ ){
            if(array[j] == current) {
                return j;
            }
        }
        return -1;
    }
    
    public static String ROT( int n, String T){
       
       char[] original = T.toCharArray();
       int length = original.length;
       char[] coded = new char[length];
       char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
       int newIndex;
       int index;
       char c;
       boolean isUpper = false;
       
       //Para todos los caracteres
       for( int j = 0; j<length ; j++){
           //Si es mayúscula se pasa a minúscula
           if( Character.isUpperCase(original[j]) ){
               c = Character.toLowerCase( original[j] );
               isUpper = true; 
           }
           else{
               c = original[j];
           }
           //Si es una letra del alfabeto
           if(isInArray(alphabet, c) ){
                   index = findIndex(alphabet, c);
                   newIndex = index + n;
                   //Si el índice excede el largo del alfabeto se divide hasta que sea menor
                   while (newIndex >= alphabet.length){
                       newIndex = newIndex%alphabet.length;
                   }
                   //Si la letra era mayúscula se vuelve a pasar a mayúscula
                   if ( isUpper ){
                       coded[j] = Character.toUpperCase( alphabet[newIndex] );
                       isUpper = false;
                   }
                   else {
                       coded[j] = alphabet[newIndex];
                   }
           }
           //Si no, se deja igual
           else {
               coded[j] = original[j];
           }
       }
       return new String(coded);
    }
    
    //Sacado del enunciado de la tarea y adaptado para ella
    public static void main(String[] args) throws IOException {
   
        //Pretty standard IO routine
        BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
        
        String input;
        String output = "";
        
        //Leemos una linea completa a la vez
        while ( ( input = in.readLine () ) != null ){
            if (input.contains(" ")){
                String params[] = input.split( " ", 2 );
                int n = Integer.parseInt(params[0]);
                output += ROT( n, params[1] ) + "\n";
            }
        }
        
        //Luego lo imprimimos todo de una
        System.out.print ( output );
        System.out.flush ();
        in.close ();
    }
    
}
