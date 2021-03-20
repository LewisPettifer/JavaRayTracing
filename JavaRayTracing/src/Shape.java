
public abstract class Shape {
	
	protected Colour colour;
	
	public Colour getColor() {
		return this.colour;
	}
	
	public abstract Boolean intersect(Intersection inter);
	public abstract Colour intersectionColour(Intersection inter, Vector3D light);
}
