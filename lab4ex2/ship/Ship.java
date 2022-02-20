
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package ship;

public class Ship {

	private boolean floating;
	private int capacity;
	private double length;
	private double width;
	private double height;
	private String name;
	private String origin;
	private String departuredate;
	private String arrivaldate;
	private String departingport;
	private String arrivalport;
	private String owner;
	
	public Ship(boolean floating, int capacity, double length, double width, double height, String name,
			String origin, String departuredate, String arrivaldate, String departingport, String arrivalport,
			String owner) {
		super();
		this.floating = floating;
		this.capacity = capacity;
		this.length = length;
		this.width = width;
		this.height = height;
		this.name = name;
		this.origin = origin;
		this.departuredate = departuredate;
		this.arrivaldate = arrivaldate;
		this.departingport = departingport;
		this.arrivalport = arrivalport;
		this.owner = owner;
	}
	public boolean isFloating() {
		return floating;
	}
	public void setFloating(boolean floating) {
		this.floating = floating;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDeparturedate() {
		return departuredate;
	}
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}
	public String getArrivaldate() {
		return arrivaldate;
	}
	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}
	public String getDepartingport() {
		return departingport;
	}
	public void setDepartingport(String departingport) {
		this.departingport = departingport;
	}
	public String getArrivalport() {
		return arrivalport;
	}
	public void setArrivalport(String arrivalport) {
		this.arrivalport = arrivalport;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void displayDetails(){
		System.out.println("Ship details: ");
		System.out.println("\tName: " + this.getName());
	    System.out.println("\tOwner: " + this.getOwner());
	    System.out.println("\tOrigin: " + this.getOrigin());
	    System.out.println("\tCapacity: " + this.getCapacity() + " people");
	    System.out.println("\tLenght: " + this.getLength() + " meters");
	    System.out.println("\tWidht: " + this.getWidth() + " meters");
	    System.out.println("\tHeight: " + this.getHeight() + " meters");
	    System.out.println("\tDate departure: " + this.getDeparturedate());
	    System.out.println("\tDate arrival: " + this.getArrivaldate());
	    System.out.println("\tDeparting Port: " + this.getDepartingport());
	    System.out.println("\tArrival Port: " + this.getArrivalport());
	    System.out.println("\tFloating: " + this.isFloating());
	}
	
}
