package lb.edu.aub.cmps.importing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lb.edu.aub.cmps.GeoLocation;

public class ImportFromCSV implements ImportFromCSVI {

	public List<GeoLocation> importGeoLocations(String csvfile) throws FileNotFoundException {
		List<GeoLocation> locs = new LinkedList<GeoLocation>();
		Set<String> locset = new HashSet<String>();
		Scanner scan = new Scanner(new File(csvfile));
		scan.nextLine();
		
		while(scan.hasNextLine()){
			String line = scan.nextLine();
			String[] parts = line.split(",");
			String locname = parts[0];
			if(!locset.contains(locname)){
				try{
					GeoLocation geoloc= new GeoLocation(locname, Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), parts[1], Integer.parseInt(parts[4]));
					if(parts.length > 5)
						geoloc.setAnnotation(parts[5]);
					else
						geoloc.setAnnotation("");
					locset.add(locname);
					locs.add(geoloc);
					System.out.println("added");
					}catch(IndexOutOfBoundsException e){ e.printStackTrace();}
			}
			
		}
		scan.close();
		System.out.println("...." +locs.size());
		return locs;
	}

	public static void main(String[] args) throws FileNotFoundException{
		ImportFromCSV imp = new ImportFromCSV();
		imp.importGeoLocations("C:\\Users\\Lenovo\\Julia\\topo text\\output-all-countries.csv");
	}
}
