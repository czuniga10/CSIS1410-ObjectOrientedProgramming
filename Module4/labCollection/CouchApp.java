package labCollection;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Test client for Couch Class.
 * 
 * @author Chad Z
 */
public class CouchApp {

	public static void main(String[] args) {
		Color[] colors = {Color.BLACK, Color.BLUE, Color.DARK_GRAY, Color.GRAY, 
				Color.GREEN, Color.LIGHT_GRAY, Color.RED, Color.WHITE};
		ArrayList<Couch> couches = new ArrayList<>();
		ArrayList<Couch> favorites = new ArrayList<>();
		addCouches(couches,colors);
		addFavorites(favorites);
		printCouchListData(couches,favorites);
		
		System.out.println("Removing all vinyl couches... \n");
		couches.removeIf(x -> x.getMaterial() == Material.VINYL);
		printCouchListData(couches,favorites);
		
		System.out.println("Adding all the favorites to the list . . .\n");
		couches.addAll(favorites);
		printCouchListData(couches,favorites);
		
		System.out.println("Adding all the couches to a set. . .\n");
		Set<Couch> couchSet = new HashSet<Couch>(couches);
		printCouchSetData(couchSet,favorites);
	}

	private static void addCouches(ArrayList<Couch> couches, Color[] colors) {
		for(var i = 0; i < colors.length; i++) {
			couches.add(new Couch(colors[i],Material.FABRIC));
			couches.add(new Couch(colors[i],Material.LEATHER));
			couches.add(new Couch(colors[i],Material.VINYL));
		}
	}
	
	private static void addFavorites(ArrayList<Couch> favorites) {
		favorites.add(new Couch(Color.RED,Material.FABRIC));
		favorites.add(new Couch(Color.BLACK,Material.LEATHER));
		favorites.add(new Couch(Color.WHITE,Material.VINYL));
	}
	
	private static void printCouchListData(ArrayList<Couch> couches, ArrayList<Couch> favorites) {
		for(Couch el:couches) {
			System.out.println(el);
		}
		System.out.printf("Number of elements in list couches: %d%n",couches.size());
		isFavoritesListIncluded(couches, favorites);
		System.out.println();
	}
	
	private static void printCouchSetData(Set<Couch> couchSet, ArrayList<Couch> favorites) {
		for(Couch el:couchSet) {
			System.out.println(el);
		}
		System.out.printf("Number of elements in the set: %d%n",couchSet.size());
		isFavoritesSetIncluded(couchSet, favorites);
		System.out.println("");
	}
	
	private static void isFavoritesListIncluded(ArrayList<Couch> couches, ArrayList<Couch> favorites) {
		if(couches.containsAll(favorites)) {
			System.out.println("All favorites are in the list.");
		} else {
			System.out.println("Not all favorites are in the list.");
		}
	}
	
	private static void isFavoritesSetIncluded(Set<Couch> couchSet, ArrayList<Couch> favorites) {
		if(couchSet.containsAll(favorites)) {
			System.out.println("All favorites are in the set.");
		} else {
			System.out.println("Not all favorites are in the set.");
		}
	}
}
