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
			String locname = scan.next();
			if(!locset.contains(locname)){
				GeoLocation geoloc= new GeoLocation(locname, Double.parseDouble(scan.next()), Double.parseDouble(scan.next()), scan.next());
				geoloc.setAnnotation(scan.next());
				locset.add(locname);
			}
			
		}
		scan.close();	
		return locs;
	}

}
