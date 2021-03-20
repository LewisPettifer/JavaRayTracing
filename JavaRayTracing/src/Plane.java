
public class Plane extends Shape{

	private Vector3D centre;
	private Vector3D normal;
	
	public Plane() {
		this.centre = new Vector3D();
		this.normal = new Vector3D();
		this.colour = new Colour();
	}
	
	public Plane(Vector3D d, Vector3D n) {
		this.centre = d;
		this.normal = n;
		this.colour = new Colour();
	}
	
	public Plane(Vector3D d, Vector3D n, int r, int g, int b) {
		this.centre = d;
		this.normal = n;
		this.colour = new Colour(r, g, b);
	}
	
	public Plane(Vector3D d, Vector3D n, Colour c) {
		this.centre = d;
		this.normal = n;
		this.colour = c;
	}
	
	@Override
	public Boolean intersect(Intersection inter) {
		
		double dotResult = normal.dotProduct(inter.getRay().getDirection());
		
		if (dotResult > 0.00001) {
			Vector3D distOrig = centre.sub(inter.getRay().getOrigin());
			double t = distOrig.dotProduct(normal) / dotResult;
			return (t >= 0);
		}
		
		return false;
	}

	@Override
	public Colour intersectionColour(Intersection inter, Vector3D light) {
		
		return colour;
	}
	
}
