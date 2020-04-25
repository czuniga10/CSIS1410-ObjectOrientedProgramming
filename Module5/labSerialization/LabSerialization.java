package labSerialization;

import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * LabSerialization demonstrates how to serialize and deserialize
 * a custom object that references other objects on the heap.
 * Author(s): Starter Code + Chad Z
 */
public class LabSerialization {
    public static void main(String[] args) {
        ListVsSetDemo demo = new ListVsSetDemo(
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(6, Color.BLUE),
                new ColoredSquare(4, Color.RED),
                new ColoredSquare(8, Color.YELLOW));
        
        		  serialize(demo,"src/labSerialization/Demo.ser");
        		  ListVsSetDemo newDemo = deserialize("src/labSerialization/Demo.ser");
        		  
                displayListAndSet(newDemo);

    };

    /**
     * Displays the elements of the list and the set.
     */
    private static void displayListAndSet(ListVsSetDemo demo) {
        System.out.println("List:");
        System.out.println(demo.getListElements());
        System.out.println("Set:");
        System.out.println(demo.getSetElements());
    }
    
    private static void serialize(ListVsSetDemo demo, String filename) {
    	try(ObjectOutputStream serializer = new ObjectOutputStream(new FileOutputStream(filename))) {
    		serializer.writeObject(demo);
    		System.out.println("Serialization complete...");
    	} catch (Exception e) {
			e.printStackTrace();
		} 
    }

    private static ListVsSetDemo deserialize(String filename) {
    	ListVsSetDemo demo = null;
    	try(ObjectInputStream deserializer = new ObjectInputStream(new FileInputStream(filename))) {
    		demo = (ListVsSetDemo) deserializer.readObject();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
		return demo;
    }
}
