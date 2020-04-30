package ioURL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * DemoURLAccess lab class. This class reads a text file from a URL, streams it line
 * by line to a new file, and also has a console app that stops the book at after
 * a certain number of pages have been rendered with a prompt for the user. 
 * 
 * @author Chad Z
 */
public class DemoURLAccess {

	public static void main(String[] args) {
		String urlString = "https://www.gutenberg.org/files/46768/46768-0.txt";
		try {
			URL url = new URL(urlString);
			try( InputStream stream = url.openStream();
				      BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				      BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
					  Scanner input = new Scanner(System.in)) {

				   String line;
				   var count = 1;
				   var PAGE_LENGTH = 35;
				   while(((line = reader.readLine()) != null)) {
				      writer.write(line + "\n");
				      
				      if(count <= PAGE_LENGTH) {
				    	  System.out.print(line + "\n");
				    	  count++;
				      } else {
				    	  System.out.println("\n- - - Press Enter to continue - - -");
				    	  input.nextLine();
				    	  count = 0;
				      }
				   }   
				}
		} catch (MalformedURLException e) {
			System.out.println(
					"We encountered a problem regarding the following URL:\n"
					+ urlString
					+ "\nEither no legal protocol could be found or the string could not be parsed.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println(
					"We encountered a problem regarding the following URL:\n"
					+ urlString
					+ "/nEither no legal protocol could be found or the string could not be parsed.");
			e.printStackTrace();
		}
	}
}
