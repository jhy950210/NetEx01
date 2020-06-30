import java.net.InetAddress;
import java.net.UnknownHostException;

public class NetEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 도메인과 아이피 :  InerAddress
		
		// dns(domain name service)
		// 도메인 <-> ip에 대한 정보를 저장하는 서버
		try {
			InetAddress inetAddress1 = InetAddress.getByName("www.naver.com");
			
			System.out.println( inetAddress1.getHostName());
			System.out.println( inetAddress1.getHostAddress());
			
			// 서버 ip(여러개)
			InetAddress[] inetAddresses = InetAddress.getAllByName("www.naver.com");
			for( InetAddress inetAddress : inetAddresses){
				System.out.println(inetAddress.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
