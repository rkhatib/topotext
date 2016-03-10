 package lb.edu.aub.cmps;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DrawMap implements DrawMapInterface {
	private PrintStream html;
	
	/*
	 * requires: locations_names not null
	 * effects: initializes this
	 * */
	public boolean drawMap(Set<String> locations_names){

		XYCoordinates coord= new XYCoordinates(locations_names);
		Set<GoogleGeoLocation> locations=coord.getLocations();
		return createHTMLFile(locations);
	}
	
	/*
	 * requires: locations_names not null and country not null
	 * effects: initializes this
	 * */
	public boolean drawMapInCountry(Set<String> locations_names, String country){
		XYCoordinates coord= new XYCoordinates(locations_names, country);
		Set<GoogleGeoLocation> locations=coord.getLocations();
		return createHTMLFile(locations);
	}
	/*
	 * requires: locations not null
	 * 
	 * effects: creates an html file holding a map 
	 * 			automatically opens the browser to show the map
	 * 			along with the marker on the given locations 
	 **/
	private boolean createHTMLFile(Set<GoogleGeoLocation> locations){
		if(locations.isEmpty()) return false;
		try {
			Scanner sc = new Scanner(new File("Files/startHtml.html"));
			String text="";
			while(sc.hasNextLine())
				text+=(sc.nextLine())+"\n";
			sc.close();
			html= new PrintStream(new File("Files/map.html"));
			html.print(text);
			printInitializationFunction(locations);
			
			Scanner sc2 = new Scanner(new File("Files/endHtml.html"));
			String text2="";
			while(sc2.hasNextLine())
				text2+=(sc2.nextLine())+"\n";
			sc2.close();
			html.print(text2);
			html.close();
			
			//creating the html file
			File htmlToOPen = new File("Files/map.html");
			
			//opening the browser
			Desktop.getDesktop().browse(htmlToOPen.toURI());
			return true;
			
		} catch (FileNotFoundException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

	}
	/**
	 * requires: locations not null
	 * effects: prints the initialization function of the map
	 * 			on the html file to be opened later
	 * 			showing the markers on the given locations
	 */
	private boolean printInitializationFunction(Set<GoogleGeoLocation> locations){
		try{
			html.print("\tfunction initialize() {\n");
			html.print("\t\tlats= new Array(");
			
			Iterator<GoogleGeoLocation> it= locations.iterator();
			html.print(it.next().getX());
			while(it.hasNext())
				html.print(", "+it.next().getX());
			html.println(");");
			
			html.print("\t\tlngs= new Array(");
			
			Iterator<GoogleGeoLocation> it2= locations.iterator();
			html.print(it2.next().getY());
			while(it2.hasNext())
				html.print(", "+it2.next().getY());
			html.println(");");
			
			html.print("\t\tnames= new Array(");
	
			Iterator<GoogleGeoLocation> it3= locations.iterator();
			html.print("'"+it3.next().getLocation_name()+"'");
			while(it3.hasNext())
				html.print(", '"+it3.next().getLocation_name()+"'");
			html.println(");");
			return true;
		}
		catch(Exception e){
			return false;
		}
			
		
	}
		



}
