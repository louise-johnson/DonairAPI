package getRequest;

import static io.restassured.RestAssured.*;

public class GetDataStatic {
	
	public static void testResponsecode() {
			
		int code = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
	
		System.out.println("Status code: " + code);
		
		if (code == 200) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
	
	public static void testBody() {
	
		String data = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		long time = get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
	
		System.out.println("Data: " + data);
		
		System.out.println("Response time (milliseconds): " + time);
	}
	
	public static void main(String args[]) {
		testResponsecode();
		testBody();
	}
}
