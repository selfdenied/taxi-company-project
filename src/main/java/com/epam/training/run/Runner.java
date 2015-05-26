package com.epam.training.run;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.epam.training.constant.Constants;
import com.epam.training.exception.LogicInvalidInitializationException;
import com.epam.training.logic.TaxiFleetLogicOperations;
import com.epam.training.taxifleet.TaxiFleet;
import com.epam.training.taxifleet.creator.TaxiFleetCreator;
import com.epam.training.util.PrintReportManager;

public class Runner {
		final static Logger LOG = Logger.getLogger(Runner.class); // getting the logger reference
		
		/* initializing the logger configuration */
		static {
			new DOMConfigurator().doConfigure(Constants.LOGGER_CONFIG_FILE_PATH,
					LogManager.getLoggerRepository());
		}
		
		public static void main(String[] args) {
			PrintReportManager printReportManager = new PrintReportManager(); // needed to print a report
			TaxiFleet taxiFleet = new TaxiFleetCreator().receiveTaxiFleet(); // generates a taxi fleet
			
			try {
				// initializing logic operations
				TaxiFleetLogicOperations logic = new TaxiFleetLogicOperations(taxiFleet);
				if (!taxiFleet.isEmpty()) {
					// printing a report into a file
					printReportManager.printReport(logic);
				} else {
					LOG.warn(Constants.EMPTY_TAXI_FLEET_WARNING);
				}
			} catch (LogicInvalidInitializationException exception) {
				LOG.error(Constants.TAXI_FLEET_LOGIC_ERROR, exception);
				LOG.warn(Constants.OPERATION_ABORTED);
			}
		}
}
