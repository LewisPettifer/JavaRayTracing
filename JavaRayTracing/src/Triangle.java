
public class Triangle extends Shape{
	
	private Vector3D x;
	private Vector3D y;
	private Vector3D z;
	private Vector3D normal;
	
	public Triangle() {
		this.x = new Vector3D();
		this.y = new Vector3D();
		this.z = new Vector3D();
		Vector3D xy = y.sub(x);
		Vector3D xz = z.sub(x);
		this.normal = xy.crossProduct(xz);
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
		Vector3D xy = y.sub(x);
		Vector3D xz = z.sub(x);
		this.normal = xy.crossProduct(xz);
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, int r, int g, int b) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
		Vector3D xy = y.sub(x);
		Vector3D xz = z.sub(x);
		this.normal = xy.crossProduct(xz);
		this.colour = new Colour(r, g, b);
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, Colour colour) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
		Vector3D xy = y.sub(x);
		Vector3D xz = z.sub(x);
		this.normal = xy.crossProduct(xz);
		this.colour = colour;
	}
	
	@Override
	public Boolean intersect(Intersection inter) {
		
		Ray localRay = inter.getRay();
		
		//Test if parallel
		double denom = localRay.getDirection().dotProduct(normal);
		if (denom == 0) {
			return false;
		}
		
		double d = normal.dotProduct(x);
		
		//calculate t
		double t = ((normal.dotProduct(localRay.getOrigin())) + d) / denom;
		inter.setT(t);
		
		if (t < 0) {
			return false; //Triangle is behind
		}
		
		Vector3D point = inter.intersectionPoint();
		
		//inside out tests
		Vector3D c;
		Vector3D edge;
		Vector3D edgeInt;
		
		//edge 1
		edge = y.sub(x);
		edgeInt = point.sub(x);
		c = edge.crossProduct(edgeInt);
		if(normal.dotProduct(c) < 0) {
			return false;
		}
		
		//edge 2
		edge = z.sub(y);
		edgeInt = point.sub(y);
		c = edge.crossProduct(edgeInt);
		if(c.dotProduct(normal) < 0) {
			return false;
		}
		
		//edge 3
		edge = x.sub(z);
		edgeInt = point.sub(z);
		c = edge.crossProduct(edgeInt);
		if(normal.dotProduct(c) < 0) {
			return false;
		}
		
		return true;
	}

	@Override
	public Vector3D getNormal(Intersection inter) {
		return this.normal;
	}
}
