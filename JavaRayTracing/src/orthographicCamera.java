
public class orthographicCamera {
	
	private Vector3D position;
	
	public orthographicCamera() {
		this.position = new Vector3D();
	}
	
	public orthographicCamera(Vector3D position) {
		this.position = position;
	}
	
	public Ray makeRay(Vector3D screenCoord) {
		Vector3D origin = new Vector3D(screenCoord.getX(), screenCoord.getY(), -5);
		Vector3D direction = new Vector3D(0, 0, 5);
		return new Ray(origin, direction);
	}
}
