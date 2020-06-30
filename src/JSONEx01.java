import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONEx01 {
	 public static void main(String[] args) {
	      // TODO 자동 생성된 메소드 스텁
	      // 앞에 "는 자바의 문자열 표시
	      // 안에 "는 기호로 처리돼서 앞에 \를 붙임
	      // json형식을 문자열로 표현
	      String json = "[{ \"name\":\"홍길동\",\"city\":\"서울\" },{ \"name\":\"박문수\",\"city\":\"수원\" }]";
	      // validation
	      JSONParser parser = new JSONParser();
	      
	      try {
	         JSONArray array = (JSONArray)parser.parse(json);
	         // 배열의 길이를 표시
	         System.out.println(array.size());
	         
	         for(int i=0 ; i<array.size() ; i++) {
	            // json안에 오브젝트형으로 되어있기 때문에 가져올때 Object로 가져온다
	            JSONObject obj = (JSONObject)array.get(i);
	            System.out.println((String)obj.get("name"));
	            System.out.println((String)obj.get("city"));
	        }
	         
	      	} catch (ParseException e) {
	         // TODO 자동 생성된 catch 블록
	      		e.printStackTrace();
	      	}
	   }

	
}
