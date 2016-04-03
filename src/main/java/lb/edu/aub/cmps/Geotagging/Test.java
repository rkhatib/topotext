package lb.edu.aub.cmps.Geotagging;

import java.util.Set;

import lb.edu.aub.cmps.GeoLocationWithOptions;
import lb.edu.aub.cmps.ReadNovelImp;
import lb.edu.aub.cmps.ReadNovelInterface;
import lb.edu.cmps.exporting.ExportI;
import lb.edu.cmps.exporting.ExportToCSV;

public class Test {

	public static void main(String[] args) throws Exception{
		
		System.out.println("Reading novel...");
		ReadNovelInterface read_novel = new ReadNovelImp("Jack Kerouac_On the Road.txt");
		Set<String> locations = read_novel.getLocations();
		String[] locations_array = new String[locations.size()];
		int i = 0;
		for(String loc: locations){
			locations_array[i] = loc;
			System.out.println("loc" + loc);
			i++;
		}
		System.out.println("Generating geo coordinates..");
		long start = System.currentTimeMillis();
		GenerateGeoCoordinates generate_geo_coordinates = new GenerateGeoCoordinatesGeoNames();
		GeoLocationWithOptions[] geo_locations_with_options = generate_geo_coordinates.generateGeoLocations(locations_array);
		long end = System.currentTimeMillis();
		ExportI export = new ExportToCSV("Outputs\\output.csv");
		System.out.println("Exporting...");
		System.out.println(geo_locations_with_options.length);
		export.export(geo_locations_with_options);
		System.out.println("The time is: " + (end - start)/1000);
	}
}
