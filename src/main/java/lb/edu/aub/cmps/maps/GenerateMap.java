package lb.edu.aub.cmps.maps;

import java.io.FileNotFoundException;
import java.util.List;

import lb.edu.aub.cmps.GeoLocation;

public interface GenerateMap {

	public void generateMap(String path, List<GeoLocation> locs, String title) throws FileNotFoundException;
}
