
public class Triangle extends Shape{
	
	private Vector3D x;
	private Vector3D y;
	private Vector3D z;
	
	public Triangle() {
		this.x = new Vector3D();
		this.y = new Vector3D();
		this.z = new Vector3D();
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, int r, int g, int b) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
		this.colour = new Colour(r, g, b);
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, Colour colour) {
		this.x = p1;
		this.y = p2;
		this.z = p3;
		this.colour = colour;
	}
	
	@Override
	public Boolean intersect(Intersection inter) {
		
		Ray localRay = inter.getRay();
		
		//Triangle normal
		Vector3D xy = y.sub(x);
		Vector3D xz = z.sub(x);
		Vector3D normal = xy.crossProduct(xz);
		
		//System.out.println("xy x:"+xy.getX()+" y:"+xy.getY()+" z:"+xy.getZ());
		//System.out.println("xz x:"+xz.getX()+" y:"+xz.getY()+" z:"+xz.getZ());
		
		//System.out.println("Normal x:"+normal.getX()+" y:"+normal.getY()+" z:"+normal.getZ());
		
		//Test if parallel
		double denom = localRay.getDirection().dotProduct(normal);
		if (denom == 0) {
			//System.out.println("first false: t: " + denom);
			return false;
		}
		
		double d = normal.dotProduct(x);
		//System.out.println("d: "+d);
		
		//calculate t
		double t = ((normal.dotProduct(localRay.getOrigin())) + d) / denom;
		//System.out.println("t: " + t);
		inter.setT(t);
		
		if (t < 0) {
			System.out.println("second false: t: " + t);
			return false; //Triangle is behind
		}
		
		Vector3D point = inter.intersectionPoint();
		
		//System.out.println("Point x:"+point.getX()+" y:"+point.getY()+" z:"+point.getZ());
		
		//inside out tests
		Vector3D c;
		Vector3D edge;
		Vector3D edgeInt;
		
		//edge 1
		edge = y.sub(x);
		edgeInt = point.sub(x);
		c = edge.crossProduct(edgeInt);
		if(normal.dotProduct(c) < 0) {
			System.out.println("third false: t: " + t);
			return false;
		}
		
		//edge 2
		edge = z.sub(y);
		edgeInt = point.sub(y);
		c = edge.crossProduct(edgeInt);
		if(c.dotProduct(normal) < 0) {
			System.out.println("forth false: t: " + t);
			return false;
		}
		
		//edge 3
		edge = x.sub(z);
		edgeInt = point.sub(z);
		c = edge.crossProduct(edgeInt);
		if(normal.dotProduct(c) < 0) {
			System.out.println("fith false: t: " + t);
			return false;
		}
		
		System.out.println("Hit!");
		return true;
	}

	@Override
	public Colour intersectionColour(Intersection inter, Light light) {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public Vector3D getNormal(Intersection inter) {
		return new Vector3D();
	}
}
