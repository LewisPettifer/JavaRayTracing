import java.util.ArrayList;

public class TriangleMesh extends Shape{

	private ArrayList<Triangle> triangles;
	
	public TriangleMesh(ArrayList<Triangle> t) {
		this.triangles = t;
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

	@Override
	public Colour intersectionColour(Intersection inter, Vector3D light) {
		// TODO Auto-generated method stub
		return new Colour();
	}
	
}
