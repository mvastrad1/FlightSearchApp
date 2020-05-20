package mv.FindFlight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FlightFinderApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		System.out.println("<-------- All Flights --->");
		FlightFinder.AllFlights();

		System.out.println("<-------- Unique Flights --->");
		FlightFinder.UniqueFlights();

		System.out.println("<-------- Specific Flights --->");
		ArrayList<String> flightNos = new ArrayList<String>();
		flightNos.add("100");
		flightNos.add("300");
		try {
			FlightFinder.SpecificFlights(flightNos);
		}
		catch (FlightFinderException e){
			System.out.println("something went wrong :Error-"+e.getErrorCode() +" ErrorDesc-" +e.getErrorDesc());
		}
		
		System.out.println("<-------- Highest Miles --->");
		FlightFinder.HighestCostFlight();
	}

}
