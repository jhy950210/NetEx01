import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject obj = (JSONObject)parser.parse(new FileReader("./google_API_test.txt"));
			
			//System.out.println(obj.toString());
			JSONArray arr = (JSONArray)obj.get("results");
//			System.out.println(arr.size());
//			System.out.println(arr.get(0));
			for(int i = 0; i< arr.size(); i++) {
				JSONObject result = (JSONObject)arr.get(i);
				
				System.out.println(result.get("geometry"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
