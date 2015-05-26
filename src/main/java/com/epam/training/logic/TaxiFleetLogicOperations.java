package com.epam.training.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.epam.training.car.PassengerCar;
import com.epam.training.comparator.CarConsumptionComparator;
import com.epam.training.exception.LogicInvalidInitializationException;
import com.epam.training.taxifleet.TaxiFleet;
import com.epam.training.constant.Constants;

/* the class containing some business logic (required by the task given) */
public class TaxiFleetLogicOperations {
	private List<PassengerCar> taxiFleetList;
	
	public TaxiFleetLogicOperations(TaxiFleet taxiFleet) 
			throws LogicInvalidInitializationException {
		setTaxiFleetList(taxiFleet);
	}
	
	/* here the calculation of total taxi fleet's cost is implemented */
	public int calculateTaxiFleetTotalPrice() {
		int totalPrice = 0;
		
		for (PassengerCar car : taxiFleetList) {
			totalPrice += car.getCarPrice();
		}
		return totalPrice;
	}
	
	/* here we get the sorted list of taxi depending on their fuel consumption */
	public List<PassengerCar> getTaxiFleetSortedAccordingToConsumption() {
		List<PassengerCar> sortedList = new ArrayList<PassengerCar>();
		
		sortedList.addAll(taxiFleetList);
		Collections.sort(sortedList, new CarConsumptionComparator());
		return sortedList;
	}
	
	/* here we get a list of cars within the specified max speed range */
	public List<PassengerCar> getCarsOfTheSpecificMaxSpeedRange(int minTopSpeed, int maxTopSpeed) {
		List<PassengerCar> chosenCarsList = new ArrayList<PassengerCar>();
		
		for (PassengerCar car : taxiFleetList) {
			if (car.getTopSpeed() >= minTopSpeed && car.getTopSpeed() <= maxTopSpeed) {
				chosenCarsList.add(car);
			}
		}
		return chosenCarsList;
	}
	
	/* a setter with validation */
	public void setTaxiFleetList(TaxiFleet taxiFleet) throws LogicInvalidInitializationException {
		if (taxiFleet != null) {
			this.taxiFleetList = taxiFleet.obtainTaxiFleetList();
		} else {
			throw new LogicInvalidInitializationException(Constants.INVALID_TAXI_FLEET_MESSAGE);
		}
	}
}
