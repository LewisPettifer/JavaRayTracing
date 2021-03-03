
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
	}

}
