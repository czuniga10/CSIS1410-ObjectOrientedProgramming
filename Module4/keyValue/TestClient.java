/**
 * 
 */
package keyValue;

/**
 * @author Chad Z
 *
 */
public class TestClient {

	public static void main(String[] args) {
		System.out.println("Part1: \n-------");
		KeyValuePair<String,Integer> p1 = new KeyValuePair<>("SLC",189899);
		KeyValuePair<String,Integer> p2 = new KeyValuePair<>("NY",8244910);
		System.out.println("p1: " + p1);
		System.out.println("p2: " + p2);
		System.out.printf("p1.equals(p2): %b%n%n",p1.equals(p2));
		
		KeyValuePair<String,Integer> p3 = p2;
		System.out.println("p3: " + p3);
		System.out.printf("p2.equals(p3): %b%n",p2.equals(p3));
	}

}
