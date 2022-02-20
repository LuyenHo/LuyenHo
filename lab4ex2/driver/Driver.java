
//Name: Ngoc Luyen Ho
//Class: CIS 35A 1Z
//Assignment Number: 4
//Due Date: 05/25/2021
//Date Submitted: 05/25/2021

package driver;

import ship.CargoShip;
import ship.CruiseShip;
import ship.Ship;

public class Driver {

	public static void main(String[] args) {
		String [] buffetmenu1 = {"Fresh seafood","Beef", "Dessert"};
		String [] buffetmenu2 = {"Fresh seafood","Pork", "Chicken", "Vegetables", "Dessert"};
		String [] service1 = {"bars", "shops", "fitness", "casino"};
		String [] service2 = {"restaurants", "bars", "shops", "swimming pools", "internet cafe"};
		Ship[] shipArr = new Ship[5];
		Ship ship1 = new CargoShip(false, 100, 100, 50, 30, "Hope", "U.S", "January 21st, 2021", "March 15th, 2021", "The U.S Port", "Japan Port",
				"James", "Dry bulk", "RoRo (Roll on/off)", 20, "Dogs, Cats", 100000 );
		Ship ship2 = new CruiseShip(false, 150, 150, 70, 50, "Future", "Japan", "January 25th, 2021", "February 25th, 2021", "The U.S Port", "The U.S Port",
				"Logan", 50, 70, buffetmenu1, service1, "Holiday Cruise" );
		Ship ship3 = new CargoShip(false, 95, 120, 60, 40, "Happy", "French", "February 11st, 2021", "March 15th, 2021", "The French Port", "The U.S Port",
				"Jennis", "Container Cargo", "LoLo (Lift on/off)", 10, "Plants, Toxis Chemicals", 130000 );
		Ship ship4 = new CruiseShip(false, 200, 200, 100, 70, "Pioneers", "Italia", "March 1st, 2021", "March 25th, 2021", "The U.S Port", "The U.S Port",
				"John", 150, 100, buffetmenu2, service2, "Panama Canal Cruise");
		Ship ship5 = new CargoShip(true, 80, 90, 40, 35, "Discover", "U.S", "March 21st, 2021", "April 10th, 2021", "The Japan Port", "The French Port",
				"Henry", "Breakbulk", "LoLo (Lift on/off)", 25, "Weapons", 90000 );

		// Populating ship objects top the array

		shipArr[0] = ship1;
		shipArr[1] = ship2;
		shipArr[2] = ship3;
		shipArr[3] = ship4;
		shipArr[4] = ship5;

		// Displaying details:
		for (int i = 0; i < shipArr.length; i++) {
			Ship shipObj = (Ship) shipArr[i];
			shipObj.displayDetails();
			System.out.println("\n");
		}
	}
}

/*~*~* 
output

CargoShip details: 
	Cargo Type: Dry bulk
	Loading Method: RoRo (Roll on/off)
	Number of cranes: 20
	Contraband: Dogs, Cats
	Cargo value: $100000.0
Ship details: 
	Name: Hope
	Owner: James
	Origin: U.S
	Capacity: 100 people
	Lenght: 100.0 meters
	Widht: 50.0 meters
	Height: 30.0 meters
	Date departure: January 21st, 2021
	Date arrival: March 15th, 2021
	Departing Port: The U.S Port
	Arrival Port: Japan Port
	Floating: false


CruiseShip details: 
	Cruise Type: Holiday Cruise
	Ticket price: $50.0
	Number of rooms: 70
	Buffet menu: Fresh seafood, Beef, Dessert
	Services: bars, shops, fitness, casino
Ship details: 
	Name: Future
	Owner: Logan
	Origin: Japan
	Capacity: 150 people
	Lenght: 150.0 meters
	Widht: 70.0 meters
	Height: 50.0 meters
	Date departure: January 25th, 2021
	Date arrival: February 25th, 2021
	Departing Port: The U.S Port
	Arrival Port: The U.S Port
	Floating: false


CargoShip details: 
	Cargo Type: Container Cargo
	Loading Method: LoLo (Lift on/off)
	Number of cranes: 10
	Contraband: Plants, Toxis Chemicals
	Cargo value: $130000.0
Ship details: 
	Name: Happy
	Owner: Jennis
	Origin: French
	Capacity: 95 people
	Lenght: 120.0 meters
	Widht: 60.0 meters
	Height: 40.0 meters
	Date departure: February 11st, 2021
	Date arrival: March 15th, 2021
	Departing Port: The French Port
	Arrival Port: The U.S Port
	Floating: false


CruiseShip details: 
	Cruise Type: Panama Canal Cruise
	Ticket price: $150.0
	Number of rooms: 100
	Buffet menu: Fresh seafood, Pork, Chicken, Vegetables, Dessert
	Services: restaurants, bars, shops, swimming pools, internet cafe
Ship details: 
	Name: Pioneers
	Owner: John
	Origin: Italia
	Capacity: 200 people
	Lenght: 200.0 meters
	Widht: 100.0 meters
	Height: 70.0 meters
	Date departure: March 1st, 2021
	Date arrival: March 25th, 2021
	Departing Port: The U.S Port
	Arrival Port: The U.S Port
	Floating: false


CargoShip details: 
	Cargo Type: Breakbulk
	Loading Method: LoLo (Lift on/off)
	Number of cranes: 25
	Contraband: Weapons
	Cargo value: $90000.0
Ship details: 
	Name: Discover
	Owner: Henry
	Origin: U.S
	Capacity: 80 people
	Lenght: 90.0 meters
	Widht: 40.0 meters
	Height: 35.0 meters
	Date departure: March 21st, 2021
	Date arrival: April 10th, 2021
	Departing Port: The Japan Port
	Arrival Port: The French Port
	Floating: true

*~*~*/
