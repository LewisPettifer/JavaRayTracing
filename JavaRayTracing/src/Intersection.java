
public class Intersection {
	
	private Ray ray;
	private double t;
	
	public Intersection() {
		ray = new Ray();
		t = Double.MAX_VALUE;
	}
	
	public Intersection(Ray ray, double t) {
		this.ray = ray;
		this.t = t;
	}

}
