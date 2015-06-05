package lb.edu.aub.cmps;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WorldCountries {

	//OVERVIEW: this class will provide one method that returns all the countries in the world
	//by simply reading them from a file than filling them in an array
	
	public static String[] countries(){
		String[] countries= new String[258];
		try {
			Scanner sc= new Scanner (new File("Files/WorldCountries.txt"));
			int i=0;
			while(sc.hasNextLine()){
				countries[i]= sc.nextLine();
				i++;
			}
			
			sc.close();
		} catch (FileNotFoundException e) {	
		}
		
		return countries;
	}
}
