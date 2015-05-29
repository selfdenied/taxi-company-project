package com.epam.training.car;

import com.epam.training.car.engine.InternalCombustionEngine;
import com.epam.training.car.feature.Gearbox;
import com.epam.training.exception.IllegalSetValueException;

/* the class of a passenger car with an internal combustion engine */
public class CombustionEnginePassengerCar extends PassengerCar {
	private InternalCombustionEngine carEngine;

	public CombustionEnginePassengerCar(Gearbox gearbox,
			InternalCombustionEngine carEngine) throws IllegalSetValueException {
		super(); // superclass constructor
		setGearbox(gearbox); // the gearbox can be either manual or automatic
		setCarEngine(carEngine);
	}

	public InternalCombustionEngine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(InternalCombustionEngine carEngine)
			throws IllegalSetValueException {
		if (carEngine != null) {
			this.carEngine = carEngine;
		} else {
			throw new IllegalSetValueException(
					"Cannot accept a 'null' value. Enter a proper car engine object");
		}
	}
}
