import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URlEx03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		
//		 = new BufferedReader(new InputStreamReader(System.in));
		try {
			URL url = new URL("https://www.naver.com");
			br = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String msg = null;
			while((msg = br.readLine()) !=null) {
				System.out.println(msg);
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
