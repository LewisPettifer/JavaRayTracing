import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		Vector3D test = new Vector3D(1.0,1.0,1.0);
		Vector3D test2 = test;
		System.out.println(test);
		System.out.println(test2);
		Vector3D squareroot = new Vector3D(3.0,4.0,0.0);
		System.out.println(squareroot.length());
		
		int width = 1920;
		int height = 1080;
		Colour red = new Colour(255, 0, 0);
		Sphere sphere = new Sphere(new Vector3D(0.0, 1.0, 0.0), 3, 255, 255, 255);
		Plane planeGrass = new Plane(new Vector3D(0.0, -5.0, 0), new Vector3D(0,-1,0), 76, 153, 0);
		Plane planeSky = new Plane(new Vector3D(0.0, 0.0, -5), new Vector3D(0, 0, 5), 0, 102, 204);
		TriangleMesh strip = new TriangleMesh();
		Triangle t1 = new Triangle(new Vector3D(0, 0, 0.0), new Vector3D(1, 1, 0), new Vector3D(0,1,1), red);
		
		Light light = new Light();
		
		strip.addTriangle(t1);
		
		ArrayList<Shape> shapeList = new ArrayList<Shape>();

		shapeList.add(planeSky);
		shapeList.add(planeGrass);
		shapeList.add(sphere);
		//shapeList.add(strip);
		
		Camera cam = new Camera(new Vector3D(0.0, 0.0, -5.0), new Vector3D(0,0,0), new Vector3D(0.0, 1.0, 0.0), 25.0 * Math.PI / 180.0, width/height);
		
		File output = new File("output4.png");
		BufferedImage theImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				
				Vector3D coord = new Vector3D((2.0*i) / width - 1.0, (-2.0*j) / height + 1.0, 0);
				Ray ray = cam.makeRay(coord);
				
				Intersection inter = new Intersection(ray);
				
				int a = 255;
				Colour colour = new Colour(0.0, 0.0, 0.0);
				
				for(int k = 0; k < shapeList.size(); k++) {
					
					if (shapeList.get(k).intersect(inter)) {
						colour = shapeList.get(k).intersectionColour(inter, light);
					}
					
				}
				
				int p = (a<<24) | ((int)colour.getR()<<16) | ((int)colour.getG()<<8) | (int)colour.getB();
				theImage.setRGB(i, j, p);
				
			}
		}
		
		try {
			ImageIO.write(theImage, "png", output);
		} catch (IOException e) {
			System.out.println("Failed to save image.");
			e.printStackTrace();
		}
	}

}
