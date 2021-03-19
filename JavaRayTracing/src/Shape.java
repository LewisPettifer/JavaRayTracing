
public abstract class Shape {
	
	protected Colour colour;
	
	public abstract Boolean intersect(Intersection inter);
	public Colour getColor() {
		return this.colour;
	}
	
}
