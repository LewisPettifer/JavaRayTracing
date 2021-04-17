import java.util.ArrayList;

public class Scene {
	
	private ArrayList<Shape> objects;
	private ArrayList<Light> lights;
	private Camera camera;
	
	public Scene() {
		objects = new ArrayList<Shape>();
		lights = new ArrayList<Light>();
		camera = new Camera(new Vector3D(0.0, 0.0, -5.0), new Vector3D(0,0,0), new Vector3D(0.0, 1.0, 0.0), 25.0 * Math.PI / 180.0, 500/500);
	}
	
	public Scene(ArrayList<Shape> objects, ArrayList<Light> lights, Camera camera) {
		this.objects = objects;
		this.lights = lights;
		this.camera = camera;
	}
	
	
}
