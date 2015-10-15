package cc3001.tarea1.sepulveda_simon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class parte2 {

	public static int SCORE(String D, String T){
		String des[] = D.split(" ");
		Set<String> mySet = new HashSet<String>(Arrays.asList(des));
		String tes[] = T.split(" ");
		int count = 0;
		for(String prim: mySet){
			for(String sec: tes){
				if(sec.equals(prim)){
					count = count + 1;
				}
				
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
		String input;
		String output = "";
		while((input = in.readLine()) != null){
			output += String.valueOf(SCORE(input.split("\\|")[0], input.split("\\|")[1])) + "\n";
		}
		System.out.print(output);
		System.out.flush();
		in.close();

	}

}
