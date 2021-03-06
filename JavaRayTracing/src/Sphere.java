
public class Sphere {

	private Vector3D centre;
	private double radius;
	private int r;
	private int g;
	private int b;
	
	public Sphere() {
		this.centre = new Vector3D();
		this.radius = 1.0;
		this.r = 255;
		this.g = 0;
		this.b = 0;
	}
	
	public Sphere(Vector3D centre, double radius) {
		this.centre = centre;
		this.radius = radius;
		this.r = 255;
		this.g = 0;
		this.b = 0;
	}
	
	public Sphere(Vector3D centre, double radius, int r, int g, int b) {
		this.centre = centre;
		this.radius = radius;
		this.r = r;
		this.g = g;
		this.b = b;
	}
}
