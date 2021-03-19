
public class Intersection {
	
	private Ray ray;
	private double t;
	private Colour colour;
	
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
	
	public Colour intersectionColour(Colour colour, Vector3D light, Sphere sphere) {
		
		Vector3D intersection = intersectionPoint();
		Vector3D normal = intersection.sub(sphere.getCentre());
		Vector3D lightVector = intersection.sub(light);
		
		double dot = normal.dotProduct(lightVector);
		
		
		
		if ( dot <= 0.0) {
			return new Colour(0, 0, 0);
		}else if (dot > 1) {
			dot = 1.0;
		}
		
		System.out.println(colour.getR() * dot);
		System.out.println(colour.getG() * dot);
		System.out.println(colour.getB() * dot);
		return new Colour(colour.getR() * dot, colour.getG() * dot, colour.getB() * dot);
	}
	
}
