
public class Camera {
	
	private Vector3D origin;
	private Vector3D forward;
	private Vector3D up;
	private Vector3D right;
	double h;
	double w;
	
	public Camera(Vector3D origin, Vector3D target, Vector3D up2, double fov, double aspectRatio) {
		this.origin = origin;
		this.right = up2.crossProduct(forward).normalised();
		this.up = right.crossProduct(forward);
		
		h = Math.tan(fov);
		w = h * aspectRatio;
	}
	
}
