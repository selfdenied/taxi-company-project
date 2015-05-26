package com.epam.training.car;

import com.epam.training.car.feature.*;
import com.epam.training.constant.Constants;
import com.epam.training.exception.IllegalSetValueException;

/* the class of some abstract passenger car */
public abstract class PassengerCar {
	int carID;
	int carPrice;			// measured in US Dollars
	int topSpeed;			// measured in km/hour
	int curbWeight;		// measured in kg
	double consumption;	// measured in l/100km (or equiv. for electric cars)
	BodyStyle bodyStyle;
	DriveArrangement driveArrangement;
	Gearbox gearbox;
	
	PassengerCar() {
		super(); // superclass constructor (Object)
	}
	
	/* getters and setters with validation */
	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) throws IllegalSetValueException {
		if (carID > 0) {
			this.carID = carID;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_CAR_ID_MESSAGE);
		}
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) throws IllegalSetValueException {
		if (carPrice > 0) {
			this.carPrice = carPrice;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_CAR_PRICE_MESSAGE);
		}
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) throws IllegalSetValueException {
		if (topSpeed > Constants.MIN_TOP_SPEED && topSpeed <= Constants.MAX_TOP_SPEED) {
			this.topSpeed = topSpeed;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_TOP_SPEED_MESSAGE);
		}
	}

	public int getCurbWeight() {
		return curbWeight;
	}

	public void setCurbWeight(int curbWeight) throws IllegalSetValueException {
		if (curbWeight > 0) {
			this.curbWeight = curbWeight;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_CURB_WEIGHT_MESSAGE);
		}
}
	
	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) throws IllegalSetValueException {
		if (consumption > 0) {
			this.consumption = consumption;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_CONSUMPTION_MESSAGE);
		}
	}

	public BodyStyle getBodyStyle() {
		return bodyStyle;
	}

	public void setBodyStyle(BodyStyle bodyStyle) throws IllegalSetValueException {
		if (bodyStyle != null) {
			this.bodyStyle = bodyStyle;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_BODY_STYLE_MESSAGE);
		}
	}

	public DriveArrangement getDriveArrangement() {
		return driveArrangement;
	}

	public void setDriveArrangement(DriveArrangement driveArrangement) throws IllegalSetValueException {
		if (driveArrangement != null) {
			this.driveArrangement = driveArrangement;
		} else {
			throw new IllegalSetValueException(Constants.INVALID_DRIVE_ARRANGEMENT_MESSAGE);
		}
	}

	public Gearbox getGearbox() {
		return gearbox;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(Constants.CAR_ID_MESSAGE + carID);
		buffer.append(Constants.CAR_PRICE_MESSAGE + carPrice + Constants.USD);
		buffer.append(Constants.CAR_CONSUMPTION_MESSAGE + consumption + Constants.LITERS_PER_KM);
		buffer.append(Constants.CAR_TOP_SPEED_MESSAGE + topSpeed + Constants.KM_PER_HOUR);
		return buffer.toString();
	}
}
