package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Runner {

	private static ArrayList<Customer> customerBase;
	private static Building building;
	private static int numberOfFloors;
	private static int numberOfCustomers;
	private static int startingFloor;

	public static void main(String[] args) {

		numberOfFloors = (int) (Math.random() * 30);
		numberOfCustomers = (int) (Math.random() * 100);

		customerBase = new ArrayList<Customer>();

		createCustomerBase(numberOfCustomers, numberOfFloors);
		createBuildingStructure(customerBase, numberOfFloors);

		building.elevator.bottomToTopMove(numberOfFloors, 4);
	}

	private static void createCustomerBase(int maxCustomers, int numberOfFloors) {
		for (int i = 0; i < maxCustomers; i++) {
			Customer cust = new Customer((int) (Math.random() * numberOfFloors),
					(int) (Math.random() * numberOfFloors));
			if (cust.getStartingFloor() != cust.getDesiredFloor()) {
				customerBase.add(cust);
			}
		}
	}

	private static void createBuildingStructure(
			ArrayList<Customer> customerBase, int maxFloors) {
		building = new Building(customerBase, maxFloors, randomFloor(0,
				numberOfFloors));
	}

	public static int randomFloor(int start, int end) {
		int range = (end - start) + 1;
		int floor = start + (int) (Math.random() * range);
		if (floor == 13) {
			floor++;
		}
		return floor;
	}
}