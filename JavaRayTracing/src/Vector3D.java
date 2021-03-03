
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
	
	public double length() {
		return Math.sqrt( (x*x) + (y*y) + (z*z));
	}
	
	public String toString() {
		return "<" + x + ", " + y + ", " + z + ">";
	}
}
