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
	/* getting the logger reference */
	final static Logger LOG = Logger.getLogger(PrintReportManager.class);

	public void printReport(TaxiFleetLogicOperations logic) {
		PrintWriter writer = null;
		// trying to open a file and write a report in it
		try {
			if (!logic.getTaxiFleetList().isEmpty()) {
				writer = new PrintWriter(Constants.OUTPUT_FILE_PATH, "UTF-8");
				LOG.info("Writing into a file...");
				writer.println(Constants.TOTAL_PRICE_MESSAGE
						+ logic.calculateTaxiFleetTotalPrice() + Constants.USD);
				writer.println(Constants.TAXI_LIST_MESSAGE);
				writer.println(getTaxiListShortDescription(logic
						.obtainTaxiFleetSortedAccordingToConsumption()));
				writer.println(Constants.CAR_SPEED_RANGE_MESSAGE);
				writer.println(getTaxiListShortDescription(logic
						.obtainCarsOfTheSpecificMaxSpeedRange(180, 220)));
				LOG.info("End of process...");
			} else {
				LOG.warn("Warning. Taxi fleet list is empty! Report printing is aborted");
			}
		} catch (IOException exception) {
			LOG.error("Error. Can't write into file!", exception);
		} finally {
			if (writer != null) {
				writer.close(); // closing the stream
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
