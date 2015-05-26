package com.epam.training.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.log4j.Logger;

import com.epam.training.car.PassengerCar;
import com.epam.training.constant.Constants;
import com.epam.training.logic.TaxiFleetLogicOperations;

/* the class is responsible for printing reports on the basis of app's business logic */
public class PrintReportManager {
	final static Logger LOG = Logger.getLogger(PrintReportManager.class); // getting the logger reference
	
	public void printReport(TaxiFleetLogicOperations logic) {
		PrintWriter writer = null;
		// trying to open a file and write a report in it
		try {
			writer = new PrintWriter(Constants.OUTPUT_FILE_PATH, "UTF-8");
			LOG.info(Constants.START_WRITING_MESSAGE);
			writer.println(Constants.TOTAL_PRICE_MESSAGE + 
					logic.calculateTaxiFleetTotalPrice() + Constants.USD);
			writer.println(Constants.TAXI_LIST_MESSAGE);
			writer.println(getTaxiListShortDescription(logic.getTaxiFleetSortedAccordingToConsumption()));
			writer.println(Constants.CAR_SPEED_RANGE_MESSAGE);
			writer.println(getTaxiListShortDescription(logic.getCarsOfTheSpecificMaxSpeedRange(180, 220)));
			LOG.info(Constants.END_WRITING_MESSAGE);
		} catch (IOException exception) {
			LOG.error(Constants.WRITE_INTO_FILE_ERROR_MESSAGE, exception);
		} finally {
			if (writer != null) {
				writer.close(); 	// closing the stream
			}
		}
	}
	
	/* the method gives a short description of each car (taxi) in the list */
	private String getTaxiListShortDescription(List<PassengerCar> taxiList) {
		StringBuffer buffer = new StringBuffer();
		for (PassengerCar car : taxiList) {
			buffer.append(car.toString());
		}
		return buffer.toString();
	}
}
