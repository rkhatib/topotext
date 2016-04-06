package lb.edu.aub.cmps.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import lb.edu.aub.cmps.GeoLocation;
import lb.edu.aub.cmps.importing.ImportFromCSV;

public class LeafletMap implements GenerateMap{

	public void generateMap(String path, List<GeoLocation> locs) throws FileNotFoundException {
		PrintStream out = new PrintStream(new File(path));
		
		//head
		String head = "<!DOCTYPE html><html><head><title>Leaflet Quick Start Guide Example</title>\n " +
				"<meta charset=\"utf-8\" />	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
				"\n	<link rel=\"stylesheet\" href=\"http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.css\" />"+
				"\n</head><body>"+"	<div id=\"map\" style=\"width: 1400px; height: 600px\"></div>"+
				"	\n<script src=\"http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js\"></script>"+
				"\n<script>"+
				"\nvar map = L.map(\'map\').setView([51.505, -0.09], 2);"+
				"\n		L.tileLayer(\'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw\', {"+
				"\nmaxZoom: 18 ,"+
				"\n			attribution: \'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, \' +"+
				"\n				\'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, \' +"+
				"\n				\'Imagery  <a href=\"http://mapbox.com\">Mapbox</a>\',"+
				"\n			id: \'mapbox.streets\'"+
				"}).addTo(map);";
		out.print(head);
		for(GeoLocation loc: locs){
			System.out.println("hello");
			double x = loc.getX();
			double y = loc.getY();
			String anno = loc.getAnnotation();
			
			out.print("\nL.marker(["+x+", "+y+"]).addTo(map).bindPopup(\""+anno+"\").openPopup();");
		}
		String tail = "\n</script>\n</body>\n</html>";
		out.print(tail);
		out.flush();
		out.close();
		
	}

	public static void main(String[] args) throws FileNotFoundException{
		ImportFromCSV imp = new ImportFromCSV();
		List<GeoLocation> geolocs = imp.importGeoLocations("C:\\Users\\Lenovo\\Julia\\topo text\\output-all-countries.csv");
		System.out.println(geolocs.size());
		LeafletMap map = new LeafletMap();
		String path = "C:\\Users\\Lenovo\\Julia\\topo text\\testmap.html";
		map.generateMap(path, geolocs);
	}
	
}
