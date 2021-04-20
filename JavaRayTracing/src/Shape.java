
public abstract class Shape {
	
	protected Colour colour;
	
	public Colour getColor() {
		return this.colour;
	}
	
	public abstract Boolean intersect(Intersection inter);
	public abstract Colour intersectionColour(Intersection inter, Light light);
	public abstract Vector3D getNormal(Intersection inter);
}
