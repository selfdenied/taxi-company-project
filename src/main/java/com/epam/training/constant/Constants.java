package com.epam.training.constant;

/* the list of all constants used in the application */
public class Constants {
	public static final String LOGGER_CONFIG_FILE_PATH = "config/log4j.xml";
	public static final String OUTPUT_FILE_PATH = "output/file.txt";
	public static final String PETROL_ENGINE_DESCRIPTION = "Petrol Engine";
	public static final String DIESEL_ENGINE_DESCRIPTION = "Diesel Engine";
	public static final String ELECTRIC_ENGINE_DESCRIPTION = "Electric Engine";
	public static final int MIN_NUMBER_OF_CYLINDERS = 2;
	public static final int MAX_NUMBER_OF_CYLINDERS = 16;
	public static final int MIN_TOP_SPEED = 0;
	public static final int MAX_TOP_SPEED = 450;
	public static final String INVALID_CYLINDERS_MESSAGE = "Number of cylinders should be between 2 and 16";
	public static final String INVALID_DISPLACEMENT_MESSAGE = "Engine displacement should be positive";
	public static final String INVALID_POWER_MESSAGE = "Engine max power should be positive";
	public static final String INVALID_TORQUE_MESSAGE = "Engine max torque should be positive";
	public static final String INVALID_CAR_ID_MESSAGE = "Car ID should be positive";
	public static final String INVALID_CAR_PRICE_MESSAGE = "Car price should be positive";
	public static final String INVALID_TOP_SPEED_MESSAGE = "Car's top speed should be between 0 and 450 km/hour";
	public static final String INVALID_CURB_WEIGHT_MESSAGE = "Car's curb weight should be positive";
	public static final String INVALID_CONSUMPTION_MESSAGE = "Car's consumption should be positive";
	public static final String INVALID_BODY_STYLE_MESSAGE = "Cannot accept a 'null' value. Enter a proper body style value";
	public static final String INVALID_DRIVE_ARRANGEMENT_MESSAGE = "Cannot accept a 'null' value. Enter a proper drive arrangement";
	public static final String INVALID_GEARBOX_MESSAGE = "Cannot accept a 'null' value. Enter a proper gearbox value";
	public static final String INVALID_CAR_ENGINE_MESSAGE = "Cannot accept a 'null' value. Enter a proper car engine object";
	public static final String INVALID_TAXI_FLEET_MESSAGE = "Cannot accept a 'null' value. Enter a proper taxi fleet object";
	public static final String WRITE_INTO_FILE_ERROR_MESSAGE = "Error. Can't write into file!";
	public static final String TOTAL_PRICE_MESSAGE = "The total price of the taxi fleet: ";
	public static final String USD = " USD";
	public static final String TAXI_LIST_MESSAGE = "\nThe list of taxi sorted according to fuel consumption:";
	public static final String CAR_SPEED_RANGE_MESSAGE = "The list of taxi with the given top speed range (180 - 220 km/hour):";
	public static final String CAR_ID_MESSAGE = "\nCar ID: ";
	public static final String CAR_PRICE_MESSAGE = "\nCar price: ";
	public static final String CAR_CONSUMPTION_MESSAGE = "\nCar consumption: ";
	public static final String LITERS_PER_KM = " l/100km";
	public static final String CAR_TOP_SPEED_MESSAGE = "\nCar top speed: ";
	public static final String KM_PER_HOUR = " km/hour\n";
	public static final String START_WRITING_MESSAGE = "Writing into a file...";
	public static final String END_WRITING_MESSAGE = "End of process...";
	public static final String OPERATION_ABORTED = "The process of printing a report into a file has been aborted";
	public static final String TAXI_FLEET_LOGIC_ERROR = "TaxiFleetLogicOperations constructor does not accept 'null' values";
	public static final String TAXI_FLEET_CREATED_INFO = "Taxi fleet has been successfully generated...";
	public static final String TAXI_FLEET_CREATION_WARN = "Warning. No cars were added into the taxi fleet";
	public static final String EMPTY_TAXI_FLEET_WARNING = "Warning. Taxi fleet list is empty! Report printing is aborted";
}
