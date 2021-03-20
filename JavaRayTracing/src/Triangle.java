
public class Triangle extends Shape{
	
	private Vector3D point1;
	private Vector3D point2;
	private Vector3D point3;
	
	public Triangle() {
		this.point1 = new Vector3D();
		this.point2 = new Vector3D();
		this.point3 = new Vector3D();
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3) {
		this.point1 = p1;
		this.point2 = p2;
		this.point3 = p3;
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, int r, int g, int b) {
		this.point1 = p1;
		this.point2 = p2;
		this.point3 = p3;
		this.colour = new Colour(r, g, b);
	}
	
	public Triangle(Vector3D p1, Vector3D p2, Vector3D p3, Colour colour) {
		this.point1 = p1;
		this.point2 = p2;
		this.point3 = p3;
		this.colour = colour;
	}
	
	@Override
	public Boolean intersect(Intersection inter) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Colour intersectionColour(Intersection inter, Vector3D light) {
		// TODO Auto-generated method stub
		return colour;
	}

}
