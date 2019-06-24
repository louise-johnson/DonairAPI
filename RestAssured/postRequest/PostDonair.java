package postRequest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostDonair {

	@Test // Posting a donair with a name only should return:
		  //  - status code 200
		  //  - correct name in the response body ("Test1: name only")
	public void test_postDonairNameOnly_ShouldBeOK() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test1: name only");
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) //status code should be: 200 (OK)
			.body("name", Matchers.equalTo(newDonair.get("name"))); //name should be: Test1: name only
	}
	
	@Test // Posting a donair with a name and a discount should return:
		  //  - status code 200 (OK)
		  //  - correct name in the response body (Test2: name and discount)
		  //  - correct discount (25)
	public void test_postDonairNameAndDiscount_ShouldBeOK() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name","Test2: name and discount"); //set donair name to: Test2: name and discount
		newDonair.put("discountPercent", 25); // set discount percent to: 25
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) //status code should be: 200 (OK)
			.body("name", Matchers.equalTo(newDonair.get("name"))) //name should be: Test2: name and discount
			.body("discountPercent", Matchers.equalTo(newDonair.get("discountPercent"))); //discountPercent should be: 25 
	}
	
	@Test // Posting a donair with a name, discount, size and toppings should return:
	  	  //  - status code 200 (OK)
		  //  - correct name in the response body (Test3: name, discount and toppings)
		  //  - correct discount (25)
		  //  - correct size (large)
		  //  - correct toppings (donair sauce, onions)
	public void test_postDonairNameDiscountToppings_ShouldBeOK() {
		JSONObject newDonair = new JSONObject();
		String toppings[] = {"donair sauce", "onions"};
		newDonair.put("name", "Test3: name, discount, toppings");
		newDonair.put("discountPercent", 33);
		newDonair.put("size", "large");
		newDonair.put("toppings", toppings);
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) 															 // status code should be: 200 (OK)
			.body("name", Matchers.equalTo(newDonair.get("name"))) 						 // name should be: Test3: name, discount, toppings
			.body("discountPercent", Matchers.equalTo(newDonair.get("discountPercent"))) // discountPercent should be: 25
			.body("size", Matchers.equalTo(newDonair.get("size"))) 						 // size should be: large
			.body("toppings", Matchers.hasItems(toppings)); 							 // toppings should have: donair sauce, onions
	}
	
	@Test // Posting a donair with a name over 32 characters should return:
    	  //  - status code 200
	  	  //  - name: ValidationError
		  //  - errors.name.message: Maximum name length is 32
	public void test_postDonairLongName_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test4: there are over 32 characters in this sentence.");
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.name.message", Matchers.equalTo("Maximum name length is 32."));
	}
	
	@Test // Posting a donair with an empty name should return:
	      //  - status code 200
	      //  - name: ValidationError
	      //  - errors.name.message: Name field is required.
	public void test_postDonairEmptyName_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test5: empty name");
		newDonair.put("name", "");
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.name.message", Matchers.equalTo("Name field is required."));
	}
	
	@Test // Posting a donair without a name should return:
	      //  - status code 200
	      //  - name: ValidationError
	      //  - errors.name.message: Name field is required.
	public void test_postDonairNoName_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("size", "medium");
		newDonair.put("discountPercent", 25);
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.name.message", Matchers.equalTo("Name field is required."));
	}	
	
	@Test // Posting a donair with a negative discount should return:
	      //  - status code 200
	      //  - name: ValidationError
	      //  - errors.discountPercent.message: Minimum discount percentage is 0.
	public void test_postDonairNegativeDiscount_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test7: negative discount");
		newDonair.put("discountPercent", -1);
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.discountPercent.message", Matchers.equalTo("Minimum discount percentage is 0."));
	}
	
	@Test // Posting a donair with a string in the discountPercent field should return:
	      //  - status code 200
		  //  - name: ValidationError
		  //  - errors.discountPercent.message: Cast to Number failed for value
	public void test_postDonairStringDiscount_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test8: string discount");
		newDonair.put("discountPercent", "50%");
		
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.discountPercent.message", Matchers.containsString("Cast to Number failed"));
	}
	
	@Test // Posting a donair with an invalid size should return:
          //  - status code 200
	      //  - name: ValidationError
	      //  - errors.size.message: extra large is not a valid enum value for path size
	public void test_postDonairInvalidSize_ShouldFail() {
		JSONObject newDonair = new JSONObject();
		newDonair.put("name", "Test9: invalid size (extra-large)");
		newDonair.put("size", "extra-large");
	
		RestAssured.baseURI = "http://localhost:3001";
		given().urlEncodingEnabled(true)
			.contentType(ContentType.JSON)
			.body(newDonair.toString())
			.post("/donairs")
			.then()
			.assertThat()
			.statusCode(200) // status code should be: 200 (OK)
			.body("name", Matchers.equalTo("ValidationError")) //response body should contain the message ValidationError
			.body("errors.size.message", Matchers.containsString("is not a valid enum value for path"));
	}
}