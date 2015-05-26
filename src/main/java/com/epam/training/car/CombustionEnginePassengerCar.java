package com.epam.training.car;

import com.epam.training.car.engine.InternalCombustionEngine;
import com.epam.training.car.feature.Gearbox;
import com.epam.training.constant.Constants;
import com.epam.training.exception.IllegalSetValueException;

/* the class of a passenger car with an internal combustion engine */
public class CombustionEnginePassengerCar extends PassengerCar {
	private InternalCombustionEngine carEngine;

	public CombustionEnginePassengerCar(Gearbox gearbox,
			InternalCombustionEngine carEngine) throws IllegalSetValueException {
		super(); 		// superclass constructor
		setGearbox(gearbox);	// the gearbox can be either manual or automatic
		setCarEngine(carEngine);
	}
	
	public Gearbox getGearbox() {
		return gearbox;
	}
	
	public void setGearbox(Gearbox gearbox) throws IllegalSetValueException {
		if (gearbox != null) {
			this.gearbox = gearbox;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_GEARBOX_MESSAGE);
		}
	}

	public InternalCombustionEngine getCarEngine() {
		return carEngine;
	}

	public void setCarEngine(InternalCombustionEngine carEngine) throws IllegalSetValueException {
		if (carEngine != null) {
			this.carEngine = carEngine;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_CAR_ENGINE_MESSAGE);
		}
	}
}
