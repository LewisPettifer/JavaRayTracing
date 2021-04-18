
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
		
		double denominator = inter.getRay().getDirection().dotProduct(normal);
		
		if (denominator != 0) {
			double t = (centre.sub(inter.getRay().getOrigin())).dotProduct(normal) / denominator;
			if ( t > 0) {
				inter.setT(t);
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Colour intersectionColour(Intersection inter, Light light) {
		
		Vector3D lightVector = (inter.intersectionPoint().sub(light.getPosition())).normalised();
		Vector3D normaledNorm = normal.normalised();
		
		double lightAngle =  lightVector.dotProduct(normaledNorm) / (normaledNorm.lengthsqrt() * lightVector.lengthsqrt());
		
		int lr = (int) (colour.getR()* light.getIntensity() * Math.max(0.0 , lightAngle));
		int lg = (int) (colour.getG()* light.getIntensity() * Math.max(0.0 , lightAngle));
		int lb = (int) (colour.getB()* light.getIntensity() * Math.max(0.0 , lightAngle));
		
		return new Colour(lr, lg, lb);
	}
	
}
