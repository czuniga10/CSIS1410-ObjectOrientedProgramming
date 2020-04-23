package printWriter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Writing to a file Lab assignment. Nested for loop that prints multiplication tables from 1 to 10
 * [1 - 10] in groups of 2 side by side to a file named TimeTables.txt.
 * 
 * @author Chad Z
 */
public class writingToAFile {
	public static void main(String[] args) {
		String file = "TimeTables.txt";
		try(PrintWriter writer = new PrintWriter(file)) {
			for(var i = 1; i <= 10; i+=2) {
				for(var j = 1; j <= 10; j++) {
					writer.printf("%2d * %d = %-2d%12d * %d = %-2d%n",
							j,i,i*j,j,i+1,j*(i+1));
					if(j == 10) {
						writer.println();
					}
				}
			}
			System.out.printf("Printed Successfully at %s...",file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
