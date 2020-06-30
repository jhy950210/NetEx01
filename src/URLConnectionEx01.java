import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
		try {
			URL url = new URL("https://www.daum.net");
			URLConnection conn = url.openConnection();
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			String line = null;
			while((line = br.readLine())!= null) {
				if(line.startsWith("<ul class=\"list_txt\">")) {
					while(true) {
						String htmlLine = br.readLine();
						if(!htmlLine.equals("</ul>")) {
							System.out.println(htmlLine);
						} else {
							break;
						}
					}
				}
				System.out.println( line );
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(br!=null) try {br.close();}catch(IOException e) {}
		}
	}

}
