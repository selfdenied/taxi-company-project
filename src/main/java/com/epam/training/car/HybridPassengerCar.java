package com.epam.training.car;

import com.epam.training.car.engine.ElectricEngine;
import com.epam.training.car.engine.InternalCombustionEngine;
import com.epam.training.car.feature.Gearbox;
import com.epam.training.exception.IllegalSetValueException;

/* the class of a hybrid drive passenger car */
public class HybridPassengerCar extends PassengerCar {
	private InternalCombustionEngine carMainEngine;
	private ElectricEngine carAdditionalEngine;

	public HybridPassengerCar(InternalCombustionEngine carMainEngine,
			ElectricEngine carAdditionalEngine) throws IllegalSetValueException {
		super(); // superclass constructor
		setGearbox(Gearbox.AUTOMATIC); // hybrids are completed with an automatic gearbox only
		setCarMainEngine(carMainEngine); // ICE (either diesel or petrol engine is possible)
		setCarAdditionalEngine(carAdditionalEngine); // electric motor
	}

	public InternalCombustionEngine getCarMainEngine() {
		return carMainEngine;
	}

	public void setCarMainEngine(InternalCombustionEngine carMainEngine)
			throws IllegalSetValueException {
		if (carMainEngine != null) {
			this.carMainEngine = carMainEngine;
		} else {
			throw new IllegalSetValueException(
					"Cannot accept a 'null' value. Enter a proper car engine object");
		}
	}

	public ElectricEngine getCarAdditionalEngine() {
		return carAdditionalEngine;
	}

	public void setCarAdditionalEngine(ElectricEngine carAdditionalEngine)
			throws IllegalSetValueException {
		if (carAdditionalEngine != null) {
			this.carAdditionalEngine = carAdditionalEngine;
		} else {
			throw new IllegalSetValueException(
					"Cannot accept a 'null' value. Enter a proper car engine object");
		}
	}
}
