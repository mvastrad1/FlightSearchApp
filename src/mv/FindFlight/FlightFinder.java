package mv.FindFlight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlightFinder {

	public static void AllFlights() throws FileNotFoundException, IOException {
		
		List<Flight> dataList = new ArrayList<Flight>();
		
		BufferedReader objReader = new BufferedReader(new FileReader("C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" "+strCurrentLine+"\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
			dataList.add(flight);    
			
		}
		objReader.close();
		
		System.out.println("All flights requested List size :"+dataList.size());
		for (Flight flight: dataList) {
			flight.Print();
		}
	}
		
	
		public static void UniqueFlights() throws FileNotFoundException, IOException {
			
			Set<Flight> dataSet = new HashSet<Flight>();
			
			BufferedReader objReader = new BufferedReader(new FileReader("C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
			String strCurrentLine;
			StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
			while ((strCurrentLine = objReader.readLine()) != null) {
				str.append("\n");
				str.append("str.append(\" "+strCurrentLine+"\")");
				String[] dataArray = strCurrentLine.split(",");
				Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
				dataSet.add(flight);    
				
			}
			objReader.close();
			
			System.out.println("Unique Flights requeested List size :"+dataSet.size());
			for (Flight flight: dataSet) {
				flight.Print();
			}
		}
	
		public static void SpecificFlights(ArrayList<String> flightNos) throws FileNotFoundException, IOException {
			
			HashMap<String, Flight> dataHashMap = new HashMap<String, Flight>();
			
			BufferedReader objReader = new BufferedReader(new FileReader("C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
			String strCurrentLine;
			StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
			while ((strCurrentLine = objReader.readLine()) != null) {
				str.append("\n");
				str.append("str.append(\" "+strCurrentLine+"\")");
				String[] dataArray = strCurrentLine.split(",");
				Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4]);
				dataHashMap.put(dataArray[0], flight);    
				
			}
			objReader.close();

			Set<Flight> flightList = new HashSet<Flight>();
			
			for (String flightNo: flightNos) {
				flightList.add(dataHashMap.get(flightNo));
			}

			System.out.println("Specific flights requested List size :"+flightList.size());
			for (Flight flight: flightList) {
				flight.Print();
			}
	}


		
}
