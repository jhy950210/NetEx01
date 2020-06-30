import java.io.BufferedReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strJson = "{\"data\":[8,9,6,2,9]}";
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(strJson);
			JSONArray arr = (JSONArray)obj.get("data");
			
			System.out.println(arr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
