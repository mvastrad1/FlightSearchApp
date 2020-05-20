package mv.FindFlight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

	
	public List<Flight> ReadFile() throws FileNotFoundException, IOException {
		
		List<Flight> dataList = new ArrayList<Flight>();

		BufferedReader objReader = new BufferedReader(new FileReader(
				"C:\\Users\\Muttu.Vastrad\\Desktop\\Muttu\\JavaTraining\\eclips_workspace\\FindFlightApp\\resources\\FlightInfo.txt"));
		
		String strCurrentLine;
		StringBuilder str = new StringBuilder(" StringBuilder str = new StringBuilder()");
		while ((strCurrentLine = objReader.readLine()) != null) {
			str.append("\n");
			str.append("str.append(\" " + strCurrentLine + "\")");
			String[] dataArray = strCurrentLine.split(",");
			Flight flight = new Flight(dataArray[0], dataArray[1], dataArray[2], dataArray[3], dataArray[4], dataArray[5]);
			dataList.add(flight);

		}
		objReader.close();
		
		return dataList ;
	}

}
