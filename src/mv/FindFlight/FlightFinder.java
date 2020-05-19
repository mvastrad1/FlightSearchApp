package mv.FindFlight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightFinder {

	public static void AllFlights() throws FileNotFoundException, IOException {
		// This will print/return all flights listed in the file including duplicates
		List<Flight> dataList = new ArrayList<Flight>();

		BufferedReader objReader = new BufferedReader(new FileReader(
				"C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" " + strCurrentLine + "\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
			dataList.add(flight);

		}
		objReader.close();
		Collections.sort(dataList);
		System.out.println("All flights requested List size :" + dataList.size());
		for (Flight flight : dataList) {
			flight.Print();
		}
		// I can return dataList if needed 
	}

	public static void UniqueFlights() throws FileNotFoundException, IOException {
		//This will return all unique records form the file ( duplicates are removed)
		Set<Flight> dataSet = new HashSet<Flight>();

		BufferedReader objReader = new BufferedReader(new FileReader(
				"C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" " + strCurrentLine + "\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
			dataSet.add(flight);

		}
		objReader.close();

		System.out.println("Unique Flights requeested List size :" + dataSet.size());
		for (Flight flight : dataSet) {
			flight.Print();
		}
		// I can return dataSet if needed 
	}

	public static void SpecificFlights(ArrayList<String> flightNos) throws FileNotFoundException, IOException, FlightFinderException {
		//This will return only requested flights form the file

		//Check if incoming list is empty
		if (flightNos.isEmpty()) {
			throw new FlightFinderException ("101", "List cannot be empty");
		}

		Set<String> inList = new HashSet<String>(flightNos);
		if (inList.size() != flightNos.size()) {
			throw new FlightFinderException ("102", "Duplicate valies in the list not allowed");
		}
		
		HashMap<String, Flight> dataHashMap = new HashMap<String, Flight>();

		BufferedReader objReader = new BufferedReader(new FileReader(
				"C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" " + strCurrentLine + "\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
			dataHashMap.put(dataArray[0], flight);

		}
		objReader.close();

		Set<Flight> flightList = new HashSet<Flight>();

		
		for (String flightNo : flightNos) {
			if (dataHashMap.containsKey(flightNo)) {
				flightList.add(dataHashMap.get(flightNo));
			}
			else {
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
		//This will return all unique records form the file ( duplicates are removed)
		Set<Flight> dataSet = new HashSet<Flight>();

		BufferedReader objReader = new BufferedReader(new FileReader(
				"C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" " + strCurrentLine + "\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
			dataSet.add(flight);

		}
		objReader.close();
		String maxFlightCost = "0";
		Flight flt = new Flight();
		for (Flight flight : dataSet) {
			String[] flightCost = flight.getCost().split(":");
			if (Double.parseDouble(maxFlightCost) < Double.parseDouble(flightCost[0])) {
				maxFlightCost = flightCost[0];
				flt = flight ; 
			}
		}
		System.out.println("Flight with highest cost :");
		flt.Print();
	}
	

}
