
public class Sphere extends Shape{

	private Vector3D centre;
	private double radius;
	
	public Sphere() {
		this.centre = new Vector3D();
		this.radius = 1.0;
		this.colour = new Colour();
	}
	
	public Sphere(Vector3D centre, double radius) {
		this.centre = centre;
		this.radius = radius;
		this.colour = new Colour();
	}
	
	public Sphere(Vector3D centre, double radius, int r, int g, int b) {
		this.centre = centre;
		this.radius = radius;
		this.colour = new Colour(r, g, b);
	}
	
	public Sphere(Vector3D centre, double radius, Colour colour) {
		this.centre = centre;
		this.radius = radius;
		this.colour = colour;
	}
	
	public Vector3D getCentre() {
		return centre;
	}

	public Colour getColour() {
		return colour;
	}

	@Override
	public Boolean intersect(Intersection inter) {
	
		//local ray
		Ray localRay = inter.getRay();
		localRay.setOrigin(localRay.getOrigin().sub(getCentre()));
		
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
		
		//Tests which intersection is closer
		if (t1 > t2) {
			//swap
			double temp = t1;
			t1 = t2;
			t2 = temp;
		}
		
		if (t1 > 0) {
			//t1 is in front of the camera
			inter.setT(t1);
		} else if (t2 > 0) {
			//t2 is infront of the camera
			inter.setT(t2);
		} else {
			//neither are infront of camera
			return false;
		}
		
		/*//test if either points are valid
		if (t1 > 0 && t1 < inter.getT()) {
			inter.setT(t1);
		} else if (t2 > 0 && t2 < inter.getT()) {
			inter.setT(t2);
		} else {
			return false; //Both failed
		}*/
		
		return true;
	}

	@Override
	public Colour intersectionColour(Intersection inter, Light light) {
		
		Vector3D normal = (inter.intersectionPoint().sub(centre)).normalised();
		Vector3D lightVector = (light.getPosition().sub(inter.intersectionPoint())).normalised();
		
		double lightAngle = lightVector.dotProduct(normal) / (normal.lengthsqrt() * lightVector.lengthsqrt());
		
		//System.out.println("Light angle: " +  lightAngle);
		
		int lr = (int) (colour.getR()* light.getIntensity() * Math.max(0.0 , lightAngle));
		int lg = (int) (colour.getG()* light.getIntensity() * Math.max(0.0 , lightAngle));
		int lb = (int) (colour.getB()* light.getIntensity() * Math.max(0.0 , lightAngle));
		
		return new Colour(lr, lg, lb);
	}
	
	@Override
	public Vector3D getNormal(Intersection inter) {
		return inter.intersectionPoint().sub(centre);
	}
}
