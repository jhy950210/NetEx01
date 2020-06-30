import java.net.MalformedURLException;
import java.net.URL;

public class URLEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://www.naver.com:8080/sample/hello.html?key=value&key2=value2");
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			
			System.out.println(url.getPath());
			System.out.println(url.getQuery());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
