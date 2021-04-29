
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
		
		//Calculate the denominator
		double denominator = inter.getRay().getDirection().dotProduct(normal);
		
		//test if the ray and plane are parallel
		if (denominator != 0) {
			double t = (centre.sub(inter.getRay().getOrigin())).dotProduct(normal) / denominator;
			if ( t >= 0) {
				inter.setT(t);
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Vector3D getNormal(Intersection inter) {
		return normal;
	}
	
}
