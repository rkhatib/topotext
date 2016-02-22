package lb.edu.aub.cmps;

public class JSONLocation {

	private String location_name;
	private String global_annotation;
	private String[] local_annotations;
	private GeoLocation[] geoLocations;
	private int weight;

	public JSONLocation(String location_name, String global_nnotation,
			String[] local_annotations, GeoLocation[] geoLocations, int weight) {
		super();
		this.location_name = location_name;
		this.global_annotation = global_nnotation;
		this.local_annotations = local_annotations;
		this.geoLocations = geoLocations;
		this.weight = weight;
	}

	public String getLocation_name() {
		return location_name;
	}

	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}

	public String getGlobal_nnotation() {
		return global_annotation;
	}

	public void setGlobal_nnotation(String global_nnotation) {
		this.global_annotation = global_nnotation;
	}

	public String[] getLocal_annotations() {
		return local_annotations;
	}

	public void setLocal_annotations(String[] local_annotations) {
		this.local_annotations = local_annotations;
	}

	public GeoLocation[] getGeoLocations() {
		return geoLocations;
	}

	public void setGeoLocations(GeoLocation[] geoLocations) {
		this.geoLocations = geoLocations;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
