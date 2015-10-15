/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cc3001.tarea1.welch_javier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author javierwelch
 */
public class Parte3 {
    
    public static String[] CRIPTOANALISIS(String D, String T){
        
        String[] decoded = new String[2];
        String currentDecode;
        int maxN = 0;
        int maxScore = 0;
        
        //Para todos los cambios de índice
        for (int x = 0; x<27; x++){
            
            //Cifrar T
            currentDecode = Parte1.ROT(x,T);
            
            //Si el SCORE es mejor, se cambial SCORE y N
            if (maxScore < Parte2.SCORE(D, currentDecode)){
                maxScore = Parte2.SCORE(D, currentDecode);
                maxN = x;
            }
            //Si el SCORE es igual, se elige el N más chico
            else if( maxScore == Parte2.SCORE(D, currentDecode)){
                if( maxN < x){
                    maxN = x;
                }
            }
        }
        
        // Se devuelve 26 - maxN porque es el N usado para codificar el texto original
        decoded[0] = Integer.toString(26 - maxN);
        decoded[1] = Parte1.ROT( maxN, T);
        
        return decoded;
        
    }
    
    //Sacada del enunciado de la tarea
    public static void main(String[] args) throws IOException {
   
        //Pretty standard IO routine
        BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
        
        String input;
        String output = "";
        String[] result = new String[2];
        //Leemos una linea completa a la vez
        while ( ( input = in.readLine () ) != null ){
            if (input.contains("|")){
                String params[] = input.split( "\\|" );
                result = CRIPTOANALISIS( params[0], params[1] );
                output += result[0] + " " + result[1] + "\n";
            }
        }
        
        //Luego lo imprimimos todo de una
        System.out.print ( output );
        System.out.flush ();
        in.close ();
    }
}
