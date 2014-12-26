package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 *
 */

public class Runner {

	private static ArrayList<Customer> customerBase;
	private static int maxFloors;
	private static int numberOfCustomers;
	private static int startingFloor;
	private static int desiredFloor;
	private static int groundFloor;

	public static void main(String[] args) {

		maxFloors = (int) (Math.random() * 30);
		numberOfCustomers = (int) (Math.random() * 10);
		startingFloor = (int) (Math.random() * maxFloors);
		desiredFloor = (int) (Math.random() * maxFloors);
		createCustomerBase(numberOfCustomers, startingFloor, desiredFloor);
		createBuildingStructure(customerBase, maxFloors, groundFloor);
	}

	private static void createCustomerBase(int maxCustomers, int startingFloor, int desiredFloor) {
		for (int i = 0; i < maxCustomers; i++) {
			Customer cust = new Customer(maxCustomers, startingFloor, desiredFloor);
			customerBase.add(cust);
		}
	}
	
	private static void createBuildingStructure(ArrayList<Customer> customerBase,
			int maxFloors, int groundFloor) {
		Building building = new Building(customerBase, maxFloors, groundFloor);
	}
}