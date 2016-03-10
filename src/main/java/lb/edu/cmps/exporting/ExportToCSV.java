package lb.edu.cmps.exporting;

import java.io.FileWriter;
import java.io.IOException;

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
			if(loc != null){
				String name = loc.getLocation_name();
				for(GeoLocation l: loc.getGeoLocations()){
					writer.append(name + ",");
					writer.append(l.getCountry()+",");
					writer.append(l.getX()+",");
					writer.append(l.getY()+"\n");
					//writer.append(l.ge)
				}
				System.out.println();
			}
		}
		
	}

}
