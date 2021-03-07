
public class Ray {

	private Vector3D origin;
	private Vector3D direction;
	private double tMax = Double.MAX_VALUE;
	
	public Ray() {
		this.setOrigin(new Vector3D(0.0, 0.0, 0.0));
		this.setDirection(new Vector3D());
	}
	
	public Ray(Vector3D origin, Vector3D direction) {
		this.setOrigin(origin);
		this.setDirection(direction);
	}
	
	public Ray(Vector3D origin, Vector3D direction, double tMax) {
		this.setOrigin(origin);
		this.setDirection(direction);
		this.tMax = tMax;
	}
	
	public Vector3D getOrigin() {
		return origin;
	}

	public void setOrigin(Vector3D origin) {
		this.origin = origin;
	}

	public Vector3D getDirection() {
		return direction;
	}

	public void setDirection(Vector3D direction) {
		this.direction = direction;
	}

	public Vector3D calculateT(double t) {
		return (getOrigin().add(getDirection())).multi(t);
	}
	
}
