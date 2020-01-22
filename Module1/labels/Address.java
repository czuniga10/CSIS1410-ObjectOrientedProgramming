// package labels;

/**
 * US address that is NOT a PO Box
 * 
 * @author Chad Z
 *
 */
public class Address {
	private String street;
	private String city;
	private State state;
	private int zip;
	
	/**
	 * Constructor inits the fields
	 * 
	 * @param street	street address	
	 * @param city
	 * @param state		US state
	 * @param zip 		5 digit zip code
	 */
	public Address(String street, String city, State state, int zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * returns street address
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * returns city/town
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * returns the US state
	 * @return the state
	 */
	public State getState() {
		return state;
	}

	/**
	 * returns 5 digit zip code
	 * @return the zip
	 */
	public int getZip() {
		return zip;
	}
}