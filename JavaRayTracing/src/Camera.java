
public abstract class Camera {
	
	protected Vector3D position;
	
	public abstract Ray makeRay(Vector3D screenCoord);
	
}
