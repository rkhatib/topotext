package lb.edu.cmps.exporting;

import java.io.IOException;

import lb.edu.aub.cmps.GeoLocationWithOptions;

public interface ExportI {

	public void export(GeoLocationWithOptions[] locations) throws IOException;
}
