package polymorphism;

public class CutterApp {

	public static void main(String[] args) {
		Pliers sideCutter = new Pliers(6, PliersType.SIDE_CUTTER);
		Pliers endNipper = new Pliers(6, PliersType.END_NIPPER);
		Pliers flushCutter = new Pliers(6, PliersType.FLUSH_CUTTER);
		
		PruningShears pruningShears = new PruningShears(9);
		ElectricPruningShears electricShears1 = new ElectricPruningShears(11);
		ElectricPruningShears electricShears2 = new ElectricPruningShears(12);
		electricShears1.onOff();
		electricShears2.onOff();
		electricShears1.onOff();

		Cutter[] arr = {sideCutter, endNipper, flushCutter, pruningShears, electricShears1, electricShears2};
		
		for(Cutter el:arr) {
			System.out.println(el +": \n" + "size= " + el.getSize());
			System.out.println(el.cut());
			System.out.println();
		}
	}

}
