import java.util.ArrayList;

public class Scene {
	
	private ArrayList<Shape> objects;
	private ArrayList<Light> lights;
	private Camera camera;
	
	public Scene() {
		objects = new ArrayList<Shape>();
		lights = new ArrayList<Light>();
		setCamera(new PerspectiveCamera(new Vector3D(0.0, 0.0, -5.0), new Vector3D(0,0,0), new Vector3D(0.0, 1.0, 0.0), 25.0 * Math.PI / 180.0, 500/500));
	}
	
	public Scene(ArrayList<Shape> objects, ArrayList<Light> lights, PerspectiveCamera camera) {
		this.objects = objects;
		this.lights = lights;
		this.setCamera(camera);
	}
	
	public void addObject(Shape object) {
		this.objects.add(object);
	}
	
	public void addLight(Light light) {
		this.lights.add(light);
	}
	
	public void removeObject(Shape shape) {
		objects.remove(shape);
	}
	
	public void removeLight(Light light) {
		lights.remove(light);
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		this.camera = camera;
	}
	
	public Colour getPixelColour(Vector3D screenCord) {
		
		Ray ray = camera.makeRay(screenCord);
		Intersection intersection = new Intersection(ray);
		Colour colour = new Colour(0,0,0);
		double tNear = Double.POSITIVE_INFINITY;
		Shape closest = new Sphere();
		
		for (int i = 0; i < objects.size(); i++) {
			
			//System.out.println("Object #" + i);
			
			Boolean doesIntersect = objects.get(i).intersect(intersection);
			double t = intersection.getT();
			
			//System.out.println("tNear: " + tNear);
			//System.out.println("t: " + t);
			
			if(doesIntersect && t < tNear) {
				//System.out.println("New closest!");
				tNear = t;
				closest = objects.get(i);
			}else {
				//System.out.println("Not new cloest!");
			}
		}
		
		closest.intersect(intersection);
		
		/*ArrayList<Shape> shadowList = new ArrayList<>();
		
		for(int i = 0; i < objects.size(); i++) {
			if (!(closest == objects.get(i))) {
				shadowList.add(objects.get(i));
			}
		}
		
		Vector3D shadowRayOrigin = intersection.intersectionPoint().sub(closest.getNormal(intersection).multi(0.0001));
		Vector3D shadowRayDirection = lights.get(0).getPosition().sub(shadowRayOrigin);
		
		Ray shadowRay = new Ray(shadowRayOrigin, shadowRayDirection);
		Intersection shadowIntersection = new Intersection(shadowRay);
		
		for (int i = 0; i < shadowList.size(); i++) {
			
			colour = closest.intersectionColour(intersection, lights.get(0));;
			
			if (shadowList.get(i).intersect(shadowIntersection)) {
				//System.out.print("Shadow!");
				colour = new Colour(0,0,0);
				
			}
			
		}*/
		colour = closest.intersectionColour(intersection, lights.get(0));
		
		//System.out.println(" Colour: " + colour.getR() + " " + colour.getG() + " " + colour.getB());
		
		return colour;
	}
}
