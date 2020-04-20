package teamProject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Creates a Receipt Object with the ItemList, gratuity, subtotoal, and total price as params,
 * and prints a receipt to a file using FileI/O.
 * 
 * @author Thomas Olvera and Chad Zuniga
 */
public class Receipt {
    static String receipt = "receipts/receiptTest";
    static int count = 0;
    
//    public static void main(String[] args) {
//        List<Item> items = new ArrayList<Item>(Arrays.asList(new Item("Item1",20.00), new Item("Item1",20.00), new Item("Item1",20.00)));
//        printReceipt(items,15.00,100.00,115.00);
//    }
    
    //Possibly remove constructor and just have printReceipt() method and use lambda exp
    //to call the method. 
    
    public static String[] printReceipt(List<Item> itemList, double gratuity, double subtotal, double totalPrice) {
        //TODO add date and time to receipt
        String[] result = new String[] {"",""};
        count++;
        try(PrintWriter writer = new PrintWriter("receipts/receipt"+count)) {
            writer.printf("Receipt   #0000%d  \n\n",count);
            for(Item el:itemList) {
                writer.printf("%s          %.2f%n",el.getName(),el.getPrice());
            }
            writer.println();
            writer.printf("SubTotal:      %.2f%n", subtotal);
            writer.printf("Gratuity:      %.2f%n", gratuity);
            writer.printf("Total:         %.2f%n", totalPrice);
            result[0] = "Receipt printed successfully...";
            result[1] = ""+count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            result[0] = "Receipt failed to print...";
        }
        System.out.println(result[0]);

        return result;
    }
}