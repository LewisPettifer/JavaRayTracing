import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ModelCreator {
	
	private String vertexPath;
	private String trianglePath;

	public ModelCreator(String vertexPath, String trianglePath) {
		this.vertexPath = vertexPath;
		this.trianglePath = trianglePath;
	}
	
	public ArrayList<Vector3D> readVertices(){
		ArrayList<Vector3D> out = new ArrayList<>();
		ArrayList<Double> temp;
		try {
			File vertexFile = new File(vertexPath);
			Scanner sc = new Scanner(vertexFile);

				while (sc.hasNextDouble()) {
					//System.out.println("Doubles!");
					out.add( new Vector3D(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
					sc.nextDouble();
					sc.nextDouble();
				}

			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file.");
			e.printStackTrace();
		}
		return out;
	}
	
	public ArrayList<ArrayList<Integer>> readTriangles(){
		ArrayList<ArrayList<Integer>> out = new ArrayList<>();
		ArrayList<Integer> temp;
		
		try {
			File triangleFile = new File(trianglePath);
			Scanner sc = new Scanner(triangleFile);
			
			
			while(sc.hasNextInt()) {
				sc.nextInt();
				temp = new ArrayList<>();
				temp.add(sc.nextInt());
				temp.add(sc.nextInt());
				temp.add(sc.nextInt());
				out.add(temp);
			}
			
			/*while(sc.hasNextLine()) {
				ArrayList<Integer> temp = new ArrayList<>();
				while(sc.hasNextInt()) {
					temp.add(sc.nextInt());
					//System.out.println(sc.nextInt());
				}
				
				System.out.println("tri:" + temp.get(1) + " : " + temp.get(2) + " : " + temp.get(3));
				out.add(temp);
			}*/
			
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not open file.");
			e.printStackTrace();
		}
		
		return out;
	}
	
	
	public TriangleMesh makeTriangles() {
		TriangleMesh tm = new TriangleMesh();
		
		ArrayList<Vector3D> vl = readVertices();
		ArrayList<ArrayList<Integer>> tl = readTriangles();
		
		//System.out.println(tl.size());
		
		for (int i = 0; i < tl.size(); i++) {
			//System.out.println(i);
			ArrayList<Integer> temp = tl.get(i);
			Triangle t = new Triangle(vl.get(temp.get(0)), vl.get(temp.get(1)), vl.get(temp.get(2)), new Colour(220,220,220));
			tm.addTriangle(t);
		}
		
		return tm;
	}
}
