
public class Vector3D {
	
	private double x;
	private double y;
	private double z;

	public Vector3D() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public double getZ() {
		return this.z;
	}
	
	public double lengthsqrt() {
		return Math.sqrt((x*x) + (y*y) + (z*z));
	}
	
	public double length() {
		return (x*x) + (y*y) + (z*z);
	}
	
	public Vector3D add(Vector3D vector) {
		return new Vector3D((this.x + vector.x), (this.y + vector.y), (this.z + vector.z));
	}
	
	public Vector3D sub(Vector3D vector) {
		return new Vector3D((this.x - vector.x), (this.y - vector.y), (this.z - vector.z));
	}
	
	public Vector3D multi(double f) {
		return new Vector3D((this.x * f), (this.y * f), (this.z * f));
	}
	
	public Vector3D div(double f) {
		return new Vector3D((this.x / f), (this.y / f), (this.z / f));
	}
	
	public double dotProduct(Vector3D v) {
		return this.x * v.x + this.y * v.y + this.z * v.z;
	}
	
	public Vector3D crossProduct(Vector3D v) {
		return new Vector3D((this.y * v.z - this.z * v.y), (this.z * v.x - this.x * v.z), (this.x * v.y - this.y * v.x));
		
	}
	
	public double normalise() {
		double l = this.length();
		if (l > 0 ) {
			l = 1 / l;
		}
		this.x *= l;
		this.y *= l;
		this.z *= l;
		return l;
	}
	
	public Vector3D normalised() {
		Vector3D temp = this;
		temp.normalise();
		return temp;
	}
	
	public String toString() {
		return "<" + x + ", " + y + ", " + z + ">";
	}
}
