package mv.FindFlight;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightFinder {

	public static void AllFlights() throws FileNotFoundException, IOException {
		// This will print/return all flights listed in the file including duplicates
		List<Flight> dataList = new ArrayList<Flight>();
		MyFileReader f = new MyFileReader();
		dataList = f.ReadFile();
		Collections.sort(dataList);
		System.out.println("All flights requested List size :" + dataList.size());
		for (Flight flight : dataList) {
			flight.Print();
		}
		// I can return dataList if needed
	}

	public static void UniqueFlights() throws FileNotFoundException, IOException {
		// This will return all unique records form the file ( duplicates are removed)

		List<Flight> dataList = new ArrayList<Flight>();
		MyFileReader f = new MyFileReader();
		dataList = f.ReadFile();
		Set<Flight> dataSet = new HashSet<Flight>(dataList);

		System.out.println("Unique Flights requeested List size :" + dataSet.size());
		for (Flight flight : dataSet) {
			flight.Print();
		}
		// I can return dataSet if needed
	}

	public static void SpecificFlights(ArrayList<String> flightNos)
			throws FileNotFoundException, IOException, FlightFinderException {

		if (flightNos.isEmpty()) {
			throw new FlightFinderException("101", "List cannot be empty");
		}

		Set<String> inList = new HashSet<String>(flightNos);
		if (inList.size() != flightNos.size()) {
			throw new FlightFinderException("102", "Duplicate valies in the list not allowed");
		}

		List<Flight> dataList = new ArrayList<Flight>();
		MyFileReader f = new MyFileReader();
		dataList = f.ReadFile();

		HashMap<String, Flight> dataHashMap = new HashMap<String, Flight>();

		for (Flight flight : dataList) {
			dataHashMap.put(flight.getNumber(), flight);
		}

		Set<Flight> flightList = new HashSet<Flight>();
		for (String flightNo : flightNos) {
			if (dataHashMap.containsKey(flightNo)) {
				flightList.add(dataHashMap.get(flightNo));
			} else {
				throw new FlightFinderException("100", "Flight does not exist");
			}
		}

		System.out.println("Specific flights requested List size :" + flightList.size());
		for (Flight flight : flightList) {
			flight.Print();
		}
		// I can return flightList if needed

	}

	public static void HighestCostFlight() throws FileNotFoundException, IOException {
		List<Flight> dataList = new ArrayList<Flight>();
		MyFileReader f = new MyFileReader();
		dataList = f.ReadFile();
		Set<Flight> dataSet = new HashSet<Flight>(dataList);

		//----- Sort by cost -------------
		Collections.sort(dataList, new Comparator<Flight>() {
			@Override
			public int compare(Flight f1, Flight f2) {
				Double f1Cost = Double.parseDouble(f1.getCost());
				Double f2Cost = Double.parseDouble(f2.getCost());
				return -f1Cost.compareTo(f2Cost);
			}
		});
/*		Flight flt = new Flight();
		flt = dataList.get(0);
		
		String maxFlightCost = "0";
		for (Flight flight : dataSet) {
			String[] flightCost = flight.getCost().split(":");
			if (Double.parseDouble(maxFlightCost) < Double.parseDouble(flightCost[0])) {
				maxFlightCost = flightCost[0];
				flt = flight;
			}
		}
*/
		System.out.println("Flight with highest Miles :");
		dataList.get(0).Print();
	}

}
