package getRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

public class GetDonair {
	
	@Test //the response code should be 200 (OK)
	public void test_ResponseCode_ShouldBe_200() {
		RestAssured.baseURI = "http://localhost:3001";
		
		given().
		when().
			get("/donairs").
		then().
			statusCode(200);
	}
	
	@Test //the number of donairs should be 3
	public void test_NumberOfDonairs_ShouldBe_3() {
		RestAssured.baseURI = "http://localhost:3001";
		
		given().
		when().
			get("/donairs").
		then().
			assertThat().
			body("", hasSize(3));
	}
	
	@Test //the first donair should have name Test2: name and discount
	public void test_FirstDonairName_ShouldBe_Test2nameanddiscount() {
		RestAssured.baseURI = "http://localhost:3001";
		
		given().
		when().
			get("/donairs").
		then().
			assertThat().
			body("name[0]", is("Test2: name and discount"));
	}
	
	@Test //the first donair toppings should be: donair sauce, tomato, onion
	public void test_FirstDonairToppings_ShouldBe_SauceTomatoOnion() {
		RestAssured.baseURI = "http://localhost:3001";
		String toppings[] = {"donair sauce", "tomato", "onion"};
		
		given().
		when().
			get("/donairs").
		then().
			assertThat().
			body("toppings[0]", hasItems(toppings));
	}
	
	@Test //a donair with the name 'hello' should not be in the DB
	public void test_SearchInvalidName_ShouldBe_Empty() {
		RestAssured.baseURI = "http://localhost:3001";
		
		given().
		when().
			get("/donairs/search/hello").
		then().
			assertThat().
			body("", Matchers.hasSize(0)); //the body should be empty
	}
}