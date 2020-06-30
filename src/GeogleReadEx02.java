import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GeogleReadEx02 {

	  public static void main(String[] args) {
	      // 구글 데이터 베이스 읽기
	      
	      BufferedReader br = null;
	      
	      try {
	         URL url = new URL("https://maps.googleapis.com/maps/api/geocode/json?address=%EC%84%9C%EC%9A%B8%EC%8B%9C%EC%B2%AD&key=AIzaSyAbVFS-qIntFVB06FBnXHkiT1NwtbD_MZ4");
	         URLConnection conn = url.openConnection();

	         br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	         
	         String line = null;
	         String latitude = null;
	         String longitude = null;
	         while((line = br.readLine()) != null ) {
	            if(line.contains("\"location\"") ) {
	                  //System.out.println(br.readLine());
	                  //System.out.println(br.readLine());
	               
	               latitude = br.readLine().trim().substring(8).replaceAll(",","");
	               longitude = br.readLine().trim().substring(8);
	               
	            }  
	         }
	         
	         System.out.println("위도 : " + latitude);
	         System.out.println("경도 : " + longitude);
	         }catch (MalformedURLException e) {
	         // TODO 자동 생성된 catch 블록
	         e.printStackTrace();
	      } catch (IOException e) {
	         // TODO 자동 생성된 catch 블록
	         e.printStackTrace();
	      } finally {
	         if(br != null) try {br.close();} catch(IOException e) {}
	         
	         
	      }
	      
	   }


}
