
public class Ray {

	private Vector3D origin;
	private Vector3D direction;
	private double tMax = Double.MAX_VALUE;
	
	public Ray() {
		this.origin = new Vector3D(0.0, 0.0, 0.0);
		this.direction = new Vector3D();
	}
	
	public Ray(Vector3D origin, Vector3D direction) {
		this.origin = origin;
		this.direction = direction;
	}
	
	public Ray(Vector3D origin, Vector3D direction, double tMax) {
		this.origin = origin;
		this.direction = direction;
		this.tMax = tMax;
	}
	
	public Vector3D calculateT(double t) {
		return (origin.add(direction)).multi(t);
	}
	
}
