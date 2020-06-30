import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=API 키 넣기
		
		BufferedReader br = null;
		JSONParser parser = new JSONParser();
		
		try {
			URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&key=AIzaSyCbxOgeLoZKjyUzm7bksp2YaPUm1ozmB2E");
			URLConnection conn = url.openConnection();
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			JSONObject obj = (JSONObject)parser.parse(br);
			
//			System.out.println(obj);
			
			JSONArray arrResults = (JSONArray)obj.get("results");
			JSONObject arrResult = (JSONObject)arrResults.get(0);
			JSONObject geometry = (JSONObject)arrResult.get("geometry");
			JSONObject location = (JSONObject)geometry.get("location");
			System.out.println(location);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br != null) try {br.close();}catch(IOException e) {}
		}
	}

}
