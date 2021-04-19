
public class PerspectiveCamera extends Camera {

	private Vector3D forward;
	private Vector3D up;
	private Vector3D right;
	double h;
	double w;
	
	public PerspectiveCamera(Vector3D origin, Vector3D target, Vector3D up2, double fov, double aspectRatio) {
		this.position = origin;
		this.forward = (target.sub(origin)).normalised();
		this.right = (forward.crossProduct(up2)).normalised();
		this.up = right.crossProduct(forward);
		
		h = Math.tan(fov);
		w = h * aspectRatio;
	}
	
	public Ray makeRay(Vector3D point2D) {
		Vector3D rightTemp = right.multi(point2D.getX() * w / 3);
		Vector3D upTemp = up.multi(point2D.getY() * h);
		Vector3D direction = forward.add(rightTemp).add(upTemp);
		
		return new Ray(position, direction.normalised());
	}
	
}
