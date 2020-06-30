import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class URlEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is = null;
		
		try {
			URL url = new URL("https://www.naver.com");
			is = url.openStream();
			
			int data = 0;
			while((data = is.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(is!=null) try {is.close();}catch(IOException e) {}
		}
	}

}
