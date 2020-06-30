import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			URLConnection conn = 
					new URL("https://ssl.pstatic.net/tveta/libs/1291/1291934/ba6b0c794e8ee6c450c5_20200624191046340.jpg").openConnection();
			
			bis = new BufferedInputStream(conn.getInputStream());
			bos = new BufferedOutputStream(new FileOutputStream("./image.jpg"));
			
			int data = 0;
			while((data = bis.read()) != -1) {
				bos.write(data);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bis!=null) try {bis.close();}catch(IOException e) {}
			if(bos!=null) try {bos.close();}catch(IOException e) {}
		}
	}

}
