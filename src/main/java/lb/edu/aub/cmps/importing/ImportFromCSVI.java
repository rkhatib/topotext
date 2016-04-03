package lb.edu.aub.cmps.importing;

import java.io.FileNotFoundException;
import java.util.List;

import lb.edu.aub.cmps.GeoLocation;

public interface ImportFromCSVI {

	public List<GeoLocation> importGeoLocations(String csvfile) throws FileNotFoundException;
}
