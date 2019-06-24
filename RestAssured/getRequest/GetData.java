package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	
	public static void testResponsecode() {
		
		Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
		int code = resp.getStatusCode();
	
		System.out.println("Status code: " + code);
		
		if (code == 200) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
	}
	
	public static void testBody() {
		
		Response resp = RestAssured.get("http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	
		String data = resp.asString();
	
		System.out.println("Data: " + data);
		
		System.out.println("Response time (milliseconds): " + resp.getTime());
	}
	
	public static void main(String args[]) {
		testResponsecode();
		testBody();
	}
}
