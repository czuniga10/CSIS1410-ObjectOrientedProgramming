package polymorphism;

import polymorphism.PruningShears;

public class ElectricPruningShears extends PruningShears {
	private boolean power;
	
	public ElectricPruningShears(int size) {
		super(size);
	}

	/**
	 * @return the power
	 */
	public boolean isOn() {
		return power;
	}
	
	public void onOff() {
		power = !power;
	}	
	
	/**
	 * Returns String "bzzzz electric prunning" to indicate the Prune Shears are cutting
	 * 
	 * @return 		String "bzzzz electric prunning" 
	 */
	@Override
	public String cut() {
		if(isOn()) {
			return super.cut();
		} else {
			return "";
		}
	}

	@Override
	public String toString() {
		return super.toString() + " power= " + (power ? "on" : "off");
	}
	
}
