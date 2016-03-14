package lb.edu.cmps.exporting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import lb.edu.aub.cmps.GeoLocation;
import lb.edu.aub.cmps.GeoLocationWithOptions;

public class ExportToCSV implements ExportI {

	private String csv_name;
	private FileWriter writer;
	
	public ExportToCSV(String filename){
		csv_name = filename;
		try {
			writer = new FileWriter(csv_name);
		} catch (IOException e) {
			System.out.println("The file is not found");
		}
		
	}

	public void export(GeoLocationWithOptions[] locations) throws IOException {
		writer.append("Location Name,");
		writer.append("Country,");
		writer.append("X,");
		writer.append("Y,");
		writer.append("Annotations\n");
		
		for(GeoLocationWithOptions loc: locations){
			Set<String> countries = new HashSet<String>();
			if(loc != null){
				String name = loc.getLocation_name();
				for(GeoLocation l: loc.getGeoLocations()){
					System.out.println(l.getCountry());
					if(!countries.contains(l.getCountry().toLowerCase())){
						countries.add(l.getCountry().toLowerCase());
						writer.append(name + ",");
						writer.append(l.getCountry()+",");
						writer.append(l.getX()+",");
						writer.append(l.getY()+"\n");
						//writer.append(l.ge)
					}
					else System.out.println("hello");
				}
				System.out.println();
			}
		}
		
	}

}
