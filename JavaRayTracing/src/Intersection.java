
public class Intersection {
	
	private Ray ray;
	private double t;
	
	public Intersection() {
		ray = new Ray();
		t = Double.MAX_VALUE;
	}
	
	public Intersection(Ray ray) {
		this.ray = ray;
		this.t = ray.gettMax();
	}
	
	public Intersection(Ray ray, double t) {
		this.ray = ray;
		this.t = t;
	}

	public Ray getRay() {
		return ray;
	}

	public void setT(double t) {
		this.t = t;
	}
	
	public double getT() {
		return t;
	}

	public Vector3D intersectionPoint() {
		return getRay().calculateT(getT());
	}
	
	public Vector3D intersectionPoint(double t) {
		return getRay().calculateT(t);
	}
	
}
