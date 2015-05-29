package com.epam.training.taxifleet.creator;

import org.apache.log4j.Logger;

import com.epam.training.car.PassengerCar;
import com.epam.training.car.engine.*;
import com.epam.training.car.feature.*;
import com.epam.training.exception.IllegalSetValueException;
import com.epam.training.taxifleet.TaxiFleet;
import com.epam.training.taxifleet.factory.TaxiFactory;

/* the class that creates various cars and adds them into a taxifleet list 
 * some hard coding is introduced here
 */
public class TaxiFleetCreator {
	/* getting the logger reference */
	final static Logger LOG = Logger.getLogger(TaxiFleetCreator.class);
	private TaxiFleet taxiFleet = new TaxiFleet();
	private TaxiFactory taxiFactory = new TaxiFactory();
	private InternalCombustionEngine petrolEngine1;
	private InternalCombustionEngine petrolEngine2;
	private InternalCombustionEngine petrolEngine3;
	private InternalCombustionEngine dieselEngine1;
	private PassengerCar car1;
	private PassengerCar car2;
	private PassengerCar car3;
	private PassengerCar car4;

	/* returns the list filled with taxi cars */ 
	public TaxiFleet receiveTaxiFleet() {
		if (createTaxiFleet()) {
			LOG.info("Taxi fleet has been successfully generated...");
		} else {
			LOG.warn("Warning. No cars were added into the taxi fleet");
		}
		return taxiFleet;
	}
	
	private boolean createEngines() {
		boolean isProperlyCompleted = false;
		
		try {
			petrolEngine1 = taxiFactory.getPetrolEngine(4, 1781, 150, 200, true);
			petrolEngine2 = taxiFactory.getPetrolEngine(6, 3281, 250, 340, false);
			petrolEngine3 = taxiFactory.getPetrolEngine(4, 1981, 211, 350, true);
			dieselEngine1 = taxiFactory.getDieselEngine(4, 1590, 120, 250, true);
			isProperlyCompleted = true;
		} catch (IllegalSetValueException exception) {
			LOG.error(exception.getMessage(), exception);
		}
		return isProperlyCompleted;
	}
	
	private boolean createCars() {
		boolean isProperlyCompleted = false;
		
		try {
			car1 = taxiFactory.getCombustionEnginePassengerCar(1, 10000, 210,
					1560, 7.1, BodyStyle.SALOON, DriveArrangement.FRONT_WHEEL_DRIVE, 
					Gearbox.MANUAL, petrolEngine1);
			car2 = taxiFactory.getCombustionEnginePassengerCar(2, 15000, 250,
					1870, 13.7, BodyStyle.ESTATE, DriveArrangement.REAR_WHEEL_DRIVE, 
					Gearbox.AUTOMATIC, petrolEngine2);
			car3 = taxiFactory.getCombustionEnginePassengerCar(3, 25000, 250,
					1700, 9.5, BodyStyle.COUPE, DriveArrangement.ALL_WHEEL_DRIVE, 
					Gearbox.AUTOMATIC, petrolEngine3);
			car4 = taxiFactory.getCombustionEnginePassengerCar(4, 9000, 190,
					1200, 4.5, BodyStyle.SALOON, DriveArrangement.FRONT_WHEEL_DRIVE, 
					Gearbox.MANUAL, dieselEngine1);
			isProperlyCompleted = true;
		} catch (IllegalSetValueException exception) {
			LOG.error(exception.getMessage(), exception);
		}
		return isProperlyCompleted;
	}
	
	private boolean createTaxiFleet() {
		boolean isProperlyCreated = false;
		
		if (createEngines() && createCars()) {
			taxiFleet.add(car1);
			taxiFleet.add(car2);
			taxiFleet.add(car3);
			taxiFleet.add(car4);
			isProperlyCreated = true;
		}
		return isProperlyCreated;
	}
}
