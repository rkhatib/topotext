package lb.edu.aub.cmps.maps;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

import lb.edu.aub.cmps.GeoLocation;

public class LeafletMap implements GenerateMap{

	public void generateMap(String path, List<GeoLocation> locs) throws FileNotFoundException {
		PrintStream out = new PrintStream(new File(path));
		
		//head
		String head = "<!DOCTYPE html><html><head><title>Leaflet Quick Start Guide Example</title> + " +
				"<meta charset=\"utf-8\" />	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"+
				"	<link rel=\"stylesheet\" href=\"http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.css\" />"+
				"</head><body>"+"	<div id=\"map\" style=\"width: 1400px; height: 600px\"></div>"+
				"	<script src=\"http://cdn.leafletjs.com/leaflet/v0.7.7/leaflet.js\"></script>"+
				"<script>"+
				"var map = L.map(\'map\').setView([51.505, -0.09], 2);"+
				"		L.tileLayer(\'https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token=pk.eyJ1IjoibWFwYm94IiwiYSI6ImNpandmbXliNDBjZWd2M2x6bDk3c2ZtOTkifQ._QA7i5Mpkd_m30IGElHziw\', {"+
				"maxZoom: 18 ,"+
				"			attribution: \'Map data &copy; <a href=\"http://openstreetmap.org\">OpenStreetMap</a> contributors, \' +"+
				"				\'<a href=\"http://creativecommons.org/licenses/by-sa/2.0/\">CC-BY-SA</a>, \' +"+
				"				\'Imagery  <a href=\"http://mapbox.com\">Mapbox</a>\',"+
				"			id: \'mapbox.streets\'"+
				"}).addTo(map);";
		out.print(head);
		for(GeoLocation loc: locs){
			double x = loc.getX();
			double y = loc.getY();
			String anno = loc.getAnnotation();
			
			out.print("L.marker(["+x+", "+y+"]).addTo(map).bindPopup("+anno+").openPopup();");
		}
		String tail = "</script></body></html>";
		out.print(tail);
		out.flush();
		out.close();
		
	}

	
}
