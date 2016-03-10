package lb.edu.aub.cmps;

public class GeoLocation {

	private String location_name;
	private double x; 
	private double y;
	private String country;
	public GeoLocation(String location_name, double x, double y, String country) {
		super();
		this.location_name = location_name;
		this.x = x;
		this.y = y;
		this.country = country;
	}
	public String getLocation_name() {
		return location_name;
	}
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String toString(){
		return "("+x+", "+y+")  _>  "+country;
	}
}
