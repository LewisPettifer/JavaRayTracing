
public class Light {
	
	private Vector3D position;
	private Colour colour;
	
	public Light() {
		setPosition(new Vector3D());
		colour = new Colour(255, 255, 204);
	}

	public Light(double x, double y, double z) {
		setPosition(x,y,z);
		colour = new Colour(255, 255, 204);
	}

	public Vector3D getPosition() {
		return position;
	}

	public void setPosition(double x, double y, double z) {
		this.position = new Vector3D(x,y,z);
	}
	
	public void setPosition(Vector3D position) {
		this.position = position;
	}

	public Colour getColour() {
		return colour;
	}

}
