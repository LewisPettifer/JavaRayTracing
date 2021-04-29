import java.util.ArrayList;

public class TriangleMesh extends Shape{

	private ArrayList<Triangle> triangles;
	
	public TriangleMesh() {
		triangles = new ArrayList<Triangle>();
	}
	
	public TriangleMesh(ArrayList<Triangle> t) {
		this.triangles = t;
	}
	
	public void addTriangle(Triangle t) {
		triangles.add(t);
	}
	
	@Override
	public Boolean intersect(Intersection inter) {
		
		int triangleCount = triangles.size();
		for(int i = 0; i < triangleCount; i++) {
			if (triangles.get(i).intersect(inter)) {
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return triangles.size();
	}
	
	@Override
	public Vector3D getNormal(Intersection inter) {
		return new Vector3D();
	}
}
