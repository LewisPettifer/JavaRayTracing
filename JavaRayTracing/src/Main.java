import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
		
		int width = 400;
		int height = 400;
		Sphere sphere = new Sphere(new Vector3D(0.0, 1.0, 0.0), 1, 255, 0, 0);
		
		Camera cam = new Camera(new Vector3D(-5.0, 1.0, 0.0), sphere.getCentre(), new Vector3D(0.0, 1.0, 0.0), 25.0 * Math.PI / 180.0, width/height);
		
		File output = new File("output.png");
		BufferedImage theImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		for(int i = 0; i < width; i++) {
			for(int j = 0; j < height; j++) {
				
				Vector3D coord = new Vector3D((2.0*i) / width - 1.0, (-2.0*j) / height + 1.0, 0);
				Ray ray = cam.makeRay(coord);
				
				Intersection inter = new Intersection(ray);
				
				int a = 255;
				int r = 0;
				int g = 0;
				int b = 0;
				
				if (sphere.intersect(inter)) {
					r = 255;
					g = 0;
					b = 0;
				}
				
				int p = (a<<24) | (r<<16) | (g<<8) | b;
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
