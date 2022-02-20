
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package ship;

public class CargoShip extends Ship{
	
	private String cargotype;
	private String loadingmethod;
	private int numberofcranes;
	private String contraband;
	private double cargovalue;

	public CargoShip(boolean floating, int capacity, double length, double width, double height, String name,
			String origin, String departuredate, String arrivaldate, String departingport, String arrivalport,
			String owner, String cargotype, String loadingmethod, int numberofcranes, String contraband,
			double cargovalue) {
		super(floating, capacity, length, width, height, name, origin, departuredate, arrivaldate, departingport,
				arrivalport, owner);
		this.cargotype = cargotype;
		this.loadingmethod = loadingmethod;
		this.numberofcranes = numberofcranes;
		this.contraband = contraband;
		this.cargovalue = cargovalue;
	}

	public String getCargotype() {
		return cargotype;
	}

	public void setCargotype(String cargotype) {
		this.cargotype = cargotype;
	}

	public String getLoadingmethod() {
		return loadingmethod;
	}

	public void setLoadingmethod(String loadingmethod) {
		this.loadingmethod = loadingmethod;
	}

	public int getNumberofcranes() {
		return numberofcranes;
	}

	public void setNumberofcranes(int numberofcranes) {
		this.numberofcranes = numberofcranes;
	}

	public String getContraband() {
		return contraband;
	}

	public void setContraband(String contraband) {
		this.contraband = contraband;
	}

	public double getCargovalue() {
		return cargovalue;
	}

	public void setCargovalue(double cargovalue) {
		this.cargovalue = cargovalue;
	}
	
	public void displayDetails(){
		System.out.println("CargoShip details: ");
	    System.out.println("\tCargo Type: " + this.getCargotype());
	    System.out.println("\tLoading Method: " + this.getLoadingmethod());
	    System.out.println("\tNumber of cranes: " + this.getNumberofcranes());
	    System.out.println("\tContraband: " + this.getContraband());
	    System.out.println("\tCargo value: $" + this.getCargovalue());
	    super.displayDetails();
	}

}
