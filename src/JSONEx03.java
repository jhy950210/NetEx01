import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		String strJson = "{\"data\":[8,9,6,2,9]}";
		JSONParser parser = new JSONParser();
		
		try {
			br = new BufferedReader(new FileReader("./json data.txt"));
			
			String line = null;
			String street = null;
			String city = null;
			String zipcode = null;
			
			while((line = br.readLine()) !=null) {
				if(line.contains("\"street\"")) {
					street = line.trim().substring(10).replace(",", "").replaceAll("\"", "");
				} else if( line.contains("\"city\"")) {
					city = line.trim().substring(8).replace(",", "").replaceAll("\"", "");
				} else if(line.contains("\"zipcode\"")) {
					zipcode = line.trim().substring(11).replace(",", "").replaceAll("\"", "");
				} else {
					continue;
				}
			}
			System.out.println(street);
			System.out.println(city);
			System.out.println(zipcode);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			JSONObject obj = (JSONObject)parser.parse(strJson);
			JSONArray arr = (JSONArray)obj.get("data");
			
			//System.out.println(arr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
