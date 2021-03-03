
public class Vector3D {
	
	private double x;
	private double y;
	private double z;

	public Vector3D() {
		x = 0;
		y = 0;
		z = 0;
	}
	
	public Vector3D(double d, double e, double f) {
		this.x = d;
		this.y = e;
		this.z = f;
	}
	
	public String toString() {
		return "<" + x + ", " + y + ", " + z + ">";
	}
}
