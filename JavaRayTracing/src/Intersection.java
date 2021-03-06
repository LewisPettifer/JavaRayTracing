
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

	public void setT(double t) {
		this.t = t;
	}
	
	public Vector3D intersectionPoint() {
		return ray.calculateT(t);
	}
	
	public Vector3D intersectionPoint(double t) {
		return ray.calculateT(t);
	}
	
}
