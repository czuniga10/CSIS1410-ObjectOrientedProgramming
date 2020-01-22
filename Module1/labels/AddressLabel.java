// package labels;

/**
 * Represents an address label that includes the fist name, last name
 * and address of addressee
 * 
 * @author Chad Z
 *
 */
public class AddressLabel {
	private String firstName;
	private String lastName;
	private Address address;
	
	/**
	 * Constructor for the Address Label
	 * 
	 * @param firstName 	first name of users label
	 * @param lastName		last name of users label
	 * @param address		address on users label
	 */
	public AddressLabel(String firstName, String lastName, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}
	
	/**
	 * Prints address Label in the following format: </br>
	 * {firstName} {lastName} </br>
	 * {streetAddress} </br>
	 * {city}, {state} {zip}
	 */
	public void printLabel() {
		System.out.printf("%s %s %n", firstName, lastName);
		System.out.println(address.getStreet());
		System.out.printf("%s, %s %d", address.getCity(), address.getState(), address.getZip());
	}

	@Override
	public String toString() {
		return "AddressLabel [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + "]";
	}
}