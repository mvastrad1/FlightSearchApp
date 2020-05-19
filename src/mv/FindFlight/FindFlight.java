package mv.FindFlight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FindFlight {

	public static void main(String[] args) throws FileNotFoundException, IOException, FlightFinderException {

		//FlightFinder.AllFlights();

		//FlightFinder.UniqueFlights();

		ArrayList<String> flightNos = new ArrayList<String>();
		flightNos.add("100");
		flightNos.add("300");
		FlightFinder.SpecificFlights(flightNos);
		
		//FlightFinder.HighestCostFlight();
	}

}
