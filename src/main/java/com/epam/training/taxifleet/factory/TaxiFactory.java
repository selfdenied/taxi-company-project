package com.epam.training.taxifleet.factory;

import com.epam.training.car.*;
import com.epam.training.car.engine.*;
import com.epam.training.car.feature.*;
import com.epam.training.exception.IllegalSetValueException;

/* the factory class (needed to handle exceptions that are invoked by Constructors */
public class TaxiFactory {

	// get a petrol engine entity
	public InternalCombustionEngine getPetrolEngine(int numberOfCylinders,
			int displacement, int maxPower, int maxTorque, boolean turbocharged)
			throws IllegalSetValueException {
		InternalCombustionEngine engine = new PetrolEngine();

		initializeEngine(numberOfCylinders, displacement, maxPower, maxTorque,
				turbocharged, engine);
		return engine;
	}

	// get a diesel engine entity
	public InternalCombustionEngine getDieselEngine(int numberOfCylinders,
			int displacement, int maxPower, int maxTorque, boolean turbocharged)
			throws IllegalSetValueException {
		InternalCombustionEngine engine = new DieselEngine();

		initializeEngine(numberOfCylinders, displacement, maxPower, maxTorque,
				turbocharged, engine);
		return engine;
	}

	// get an electric engine entity
	public ElectricEngine getElectricEngine(int maxPower, int maxTorque)
			throws IllegalSetValueException {
		ElectricEngine electricEngine = new ElectricEngine();

		electricEngine.setMaxPower(maxPower);
		electricEngine.setMaxTorque(maxTorque);
		return electricEngine;
	}

	// get a "car with ICE" entity
	public PassengerCar getCombustionEnginePassengerCar(int carID,
			int carPrice, int topSpeed, int curbWeight, double consumption,
			BodyStyle bodyStyle, DriveArrangement driveArrangement,
			Gearbox gearbox, InternalCombustionEngine carEngine)
			throws IllegalSetValueException {
		PassengerCar passengerCar = new CombustionEnginePassengerCar(gearbox,
				carEngine);

		initializePassengerCar(carID, carPrice, topSpeed, curbWeight,
				consumption, bodyStyle, driveArrangement, passengerCar);
		return passengerCar;
	}

	// get an electric car entity
	public PassengerCar getElectricPassengerCar(int carID, int carPrice,
			int topSpeed, int curbWeight, double consumption,
			BodyStyle bodyStyle, DriveArrangement driveArrangement,
			ElectricEngine carEngine) throws IllegalSetValueException {
		PassengerCar passengerCar = new ElectricPassengerCar(carEngine);

		initializePassengerCar(carID, carPrice, topSpeed, curbWeight,
				consumption, bodyStyle, driveArrangement, passengerCar);
		return passengerCar;
	}

	// get a hybrid car entity
	public PassengerCar getHybridPassengerCar(int carID, int carPrice,
			int topSpeed, int curbWeight, double consumption,
			BodyStyle bodyStyle, DriveArrangement driveArrangement,
			InternalCombustionEngine carMainEngine,
			ElectricEngine carAdditionalEngine) throws IllegalSetValueException {
		PassengerCar passengerCar = new HybridPassengerCar(carMainEngine,
				carAdditionalEngine);

		initializePassengerCar(carID, carPrice, topSpeed, curbWeight,
				consumption, bodyStyle, driveArrangement, passengerCar);
		return passengerCar;
	}

	// supplementary method
	private boolean initializeEngine(int numberOfCylinders, int displacement,
			int maxPower, int maxTorque, boolean turbocharged,
			InternalCombustionEngine engine) throws IllegalSetValueException {
		boolean isInitialized = false;

		engine.setNumberOfCylinders(numberOfCylinders);
		engine.setDisplacement(displacement);
		engine.setMaxPower(maxPower);
		engine.setMaxTorque(maxTorque);
		engine.setTurbocharged(turbocharged);
		isInitialized = true;
		return isInitialized;
	}

	// supplementary method
	private boolean initializePassengerCar(int carID, int carPrice,
			int topSpeed, int curbWeight, double consumption,
			BodyStyle bodyStyle, DriveArrangement driveArrangement,
			PassengerCar passengerCar) throws IllegalSetValueException {
		boolean isInitialized = false;

		passengerCar.setCarID(carID);
		passengerCar.setCarPrice(carPrice);
		passengerCar.setTopSpeed(topSpeed);
		passengerCar.setCurbWeight(curbWeight);
		passengerCar.setConsumption(consumption);
		passengerCar.setBodyStyle(bodyStyle);
		passengerCar.setDriveArrangement(driveArrangement);
		isInitialized = true;
		return isInitialized;
	}
}
