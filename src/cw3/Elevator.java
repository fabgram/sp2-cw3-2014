package cw3;

import java.util.ArrayList;

/**
 * @author fgrami01 & jbukow01
 * 
 */

public class Elevator {

	private final int NUMBER_OF_FLOORS;
	private ArrayList<Customer> customerList;
	private int currentFloor;
	private boolean top = false;
	private int movements;
	private int direction;

	/**
	 * @param customerList
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public Elevator(ArrayList<Customer> customerList, int numberOfFloors,
			int startingFloor) {
		this.customerList = customerList;
		this.NUMBER_OF_FLOORS = numberOfFloors;
		this.currentFloor = startingFloor;
		movements = 0;
	}

	/**
	 * @param numberOfFloors
	 * @param startingFloor
	 */

	public void run(int option, int numberOfFloors, int startingFloor) {
		System.out.println("Starting floor: " + currentFloor
				+ " Number of floors: " + NUMBER_OF_FLOORS
				+ " Number of customers: " + customerList.size());
		
		if (option == 1) {
			bottomToTopMove(numberOfFloors, startingFloor);
		} else if (option == 2) {
			// otherMove();
		} else {
			System.out.println("Please choose correct option! Options: (1, 2)");
		}
		System.out.println("Finished. Total number of moves: " + movements);
	}
	
	private void move() {
		
		if (direction == 1 && currentFloor == NUMBER_OF_FLOORS) {
			direction = -1;
		}
		else if (direction == -1 && currentFloor == 0) {
			direction = 1;
		}
	}

	public void bottomToTopMove(int numberOfFloors, int startingFloor) {
		if (currentFloor != numberOfFloors && !top) {
			for (int i = 0; i < numberOfFloors; i++) {
				customerJoins();
				customerLeaves();
			}
			currentFloor++;
			movements++;
			System.out.println("Current floor: " + currentFloor
					+ " Number of customers: " + customerList.size());
		}
		if (currentFloor == numberOfFloors) {
			top = true;
		}

		if (top) {
			for (int i = numberOfFloors; i > 0; i--) {
				customerJoins();
				customerLeaves();
				currentFloor--;
				movements++;
				System.out.println("Current floor: " + currentFloor
						+ " Number of customers: " + customerList.size());
			}
		}
	}
	
	private void otherMove() {
		//otherMove
	}

	public void customerJoins() {
		for (int i = 0; i < customerList.size(); i++) {
			if (customerList.get(i).getStartingFloor() == currentFloor) {
				customerList.get(i).setInElevator(true);
			}
		}
	}

	public void customerLeaves() {
		for (int i = customerList.size() - 1; i >= 0; i--) {
			if (customerList.get(i).getDestinationFloor() == currentFloor && customerList.get(i).isInElevator()) {
				customerList.remove(i);
			}
		}
	}
}
