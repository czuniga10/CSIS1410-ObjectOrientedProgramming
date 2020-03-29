package nuisance;

import java.util.*;

/**
 * Test Client App for the Interface Assignment
 * 
 * @author Chad Z
 */
public class NuisanceApp {

	public static void main(String[] args) {
		Friend[] friends = {new Friend("Juan",27,Hobby.MUSIC), 
				new Friend("Kate",27,Hobby.SPORTS), 
				new Friend("Alex",21,Hobby.MUSIC)};
		
		System.out.println("3 Friends:");
		printFriends(friends);

		System.out.println();
		
		System.out.println("friend1 equals friend2: " + 
				friends[0].equals(friends[1]));
		System.out.println("friend1 equals friend3: " + 
				friends[0].equals(friends[2]));
		System.out.println("friend2 equals new friend: " + 
				friends[1].equals(new Friend("Kate",27,Hobby.SPORTS)));
		System.out.println();
		
		Telemarketer telemarketer = new Telemarketer("Fritz",25);
		System.out.println("telemarketer: " + telemarketer);
		System.out.println();
		
		System.out.println("4 Insects:");
		
		Mosquito mosquito = new Mosquito("Aedes vexans");
		PeskyMosquito peskyMostquito = new PeskyMosquito("Anopheles walkeri");
		List<String> colors = new ArrayList<String>();
		colors.add("yellow");
		colors.add("black");
		colors.add("blue");
		Butterfly butterfly1 = new Butterfly("Swallowtail", colors);
		Insect[] insects = {
				mosquito, 
				peskyMostquito,
				butterfly1, 
				new Butterfly(butterfly1) };
		
		printInsects(insects);
		
		Nuisance[] nuisances = {telemarketer,mosquito,peskyMostquito};
		System.out.println("3 Nuisances:");
		
		for(Nuisance el:nuisances) {
			if(el instanceof Mosquito) {
				System.out.println(((Mosquito) el).buzz());
			}
			if(el instanceof PeskyMosquito) {
				System.out.println(((PeskyMosquito) el).bite());
			}
			System.out.println(el.annoy());
			System.out.println();
		}
	}
	
	private static void printFriends(Friend[] friends) {
		int count = 1;
		for(Friend el:friends) {
			System.out.printf("Friend %d: %s%n",count,el);
			count++;
		}
	}
	
	private static void printInsects(Insect[] insects) {
		for(Insect el:insects) {
			System.out.println(el);
		}
		System.out.println();
	}

}
