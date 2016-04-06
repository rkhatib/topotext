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
		}
		
	}

	public void export(GeoLocationWithOptions[] locations) throws IOException {
		writer.append("Location Name,");
		writer.append("Country,");
		writer.append("X,");
		writer.append("Y,");
		writer.append("Alternative name");
		Set<String> countries = new HashSet<String>();

		for(GeoLocationWithOptions loc: locations){
			if(loc != null){
				String name = loc.getLocation_name();
				for(GeoLocation l: loc.getGeoLocations()){
					if(!countries.contains(l.getCountry().toLowerCase())){
						countries.add(l.getCountry().toLowerCase());
						writer.append(name + ",");
						writer.append(l.getCountry()+",");
						writer.append(l.getX()+",");
						writer.append(l.getY()+"\n");
					}
					
				}
			}
		}
		writer.flush();
		writer.close();
		
	}

}
