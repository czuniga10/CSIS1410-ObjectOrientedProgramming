package textManipulation;
import java.util.ArrayList;
import java.util.Scanner;

public class LabTextManipulation {

	public static void main(String[] args) {
		ArrayList<String> parks = new ArrayList<>();
		Scanner input = new Scanner(System.in);
		String str;
		
		do {
			System.out.print("Please enter your favorite National Park or DONE to stop: ");
			str = input.nextLine().toString().toLowerCase();
			parks.add(str);
		} while (!str.equals("done"));
		input.close();
		System.out.println();
		
		System.out.println(listToString(parks));
	}

	private static String listToString(ArrayList<String> str) {
		StringBuilder sb = new StringBuilder();
		String nationalPark = "Favorite National Parks: ";
		for(int i = 0; i < str.size(); i++) {
			if(!str.get(i).equals("done")) {
				sb.append(updateSpelling(str.get(i)));
			}
			if(i < str.size()-2) {
				sb.append(" | ");
			}
		}
		return nationalPark += sb.toString();
	}
	
	private static String updateSpelling(String str) {
		String[] strArr = str.split(" ");
		String result = "";
		for(int i = 0; i < strArr.length; i++) {
			String end = strArr[i].substring(1,strArr[i].length()).toLowerCase();
			String first = strArr[i].substring(0,1).toUpperCase();
			result += first + end;
			if(i != strArr.length-1) {
				result += " ";
			}
		}
		return result;
	}
}
