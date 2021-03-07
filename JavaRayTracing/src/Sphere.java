
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
	
	public Boolean intersect(Intersection inter) {
	
		//local ray
		Ray localRay = inter.getRay();
		localRay.setOrigin(localRay.getOrigin().sub(centre));
		
		//calculate quad
		double a = localRay.getDirection().length();
		double b = 2 * localRay.getDirection().dotProduct(localRay.getOrigin());
		double c = localRay.getOrigin().length() - (radius * radius);
		
		//check if we intersect
		double intersect = (b*b) - 4 * a * c;
		if (intersect < 0.0) {
			return false;
		}
		
		//points of intersection
		double t1 = (-b - Math.sqrt(intersect)) / (2 * a);
		double t2 = (-b + Math.sqrt(intersect)) / (2 * a);
		
		//test if either points are valid
		if (t1 > 0.0001 && t1 < inter.getT()) {
			inter.setT(t1);
		} else if (t2 > 0.0001 && t2 < inter.getT()) {
			inter.setT(t2);
		} else {
			return false; //Both failed
		}
		
		return true;
	}
	
	
}
