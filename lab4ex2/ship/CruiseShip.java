
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package ship;

public class CruiseShip extends Ship{
	private double ticketprice;
	private int numberofrooms;
	private String buffetmenu [];
	private String services [];
	private String cruisetype;
	public CruiseShip(boolean floating, int capacity, double length, double width, double height, String name,
			String origin, String departuredate, String arrivaldate, String departingport, String arrivalport,
			String owner, double ticketprice, int numberofrooms, String[] buffetmenu, String[] services,
			String cruisetype) {
		super(floating, capacity, length, width, height, name, origin, departuredate, arrivaldate, departingport,
				arrivalport, owner);
		this.ticketprice = ticketprice;
		this.numberofrooms = numberofrooms;
		this.buffetmenu = buffetmenu;
		this.services = services;
		this.cruisetype = cruisetype;
	}
	public double getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(double ticketprice) {
		this.ticketprice = ticketprice;
	}
	public int getNumberofrooms() {
		return numberofrooms;
	}
	public void setNumberofrooms(int numberofrooms) {
		this.numberofrooms = numberofrooms;
	}
	public String[] getBuffetmenu() {
		return buffetmenu;
	}
	public void setBuffetmenu(String[] buffetmenu) {
		this.buffetmenu = buffetmenu;
	}
	public String[] getServices() {
		return services;
	}
	public void setServices(String[] services) {
		this.services = services;
	}
	public String getCruisetype() {
		return cruisetype;
	}
	public void setCruisetype(String cruisetype) {
		this.cruisetype = cruisetype;
	}

	public void displayDetails(){
		System.out.println("CruiseShip details: ");
	    System.out.println("\tCruise Type: " + this.getCruisetype());
	    System.out.println("\tTicket price: $" + this.getTicketprice());
	    System.out.println("\tNumber of rooms: " + this.getNumberofrooms());
	    System.out.print("\tBuffet menu: ");
	    for (int i = 0; i < buffetmenu.length; i++) {
			System.out.print(buffetmenu[i]);
			if (i < buffetmenu.length - 1) System.out.print(", ");
		}
	    System.out.print("\n\tServices: ");
	    for (int i = 0; i < services.length; i++) {
			System.out.print(services[i]);
			if (i < services.length - 1) System.out.print(", ");
		}
	    System.out.println(""); 
	    super.displayDetails();
	}
}
