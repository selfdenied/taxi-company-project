package com.epam.training.car;

import com.epam.training.car.engine.ElectricEngine;
import com.epam.training.car.feature.Gearbox;
import com.epam.training.exception.IllegalSetValueException;

/* the class of an electric passenger car */
public class ElectricPassengerCar extends PassengerCar {
	private ElectricEngine carEngine;

	public ElectricPassengerCar(ElectricEngine carEngine)
			throws IllegalSetValueException {
		super(); // superclass constructor
		setGearbox(Gearbox.AUTOMATIC); // electric cars are completed with an automatic gearbox only
		setCarEngine(carEngine);
	}

	public ElectricEngine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(ElectricEngine carEngine)
			throws IllegalSetValueException {
		if (carEngine != null) {
			this.carEngine = carEngine;
		} else {
			throw new IllegalSetValueException(
					"Cannot accept a 'null' value. Enter a proper car engine object");
		}
	}
}
