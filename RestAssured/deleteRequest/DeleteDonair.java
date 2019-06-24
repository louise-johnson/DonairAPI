package deleteRequest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;


public class DeleteDonair {
	
	@Test // Deleting a donair with the name "Test1: name only" should return:
	      //  - status code 200
	      //  - message: donair successfully deleted
	public void test_deleteDonairTest1_ShouldSucceed() {
		given()
			.baseUri("http://localhost:3001")
			.basePath("/donairs/search")
			.delete("/Test1: name only")
			.then()
			.assertThat()
			.statusCode(200)
			.body("message", Matchers.equalTo("donair successfully deleted"));
	}
	
	@Test // Deleting a donair with the name "Test2: name and discount" should return:
          //  - status code 200
          //  - message: donair successfully deleted
	public void test_deleteDonairTest2_ShouldSucceed() {
		given()
			.baseUri("http://localhost:3001")
			.basePath("/donairs/search")
			.delete("/Test2: name and discount")
			.then()
			.assertThat()
			.statusCode(200)
			.body("message", Matchers.equalTo("donair successfully deleted"));
	}
	
	@Test // Deleting a donair with the name "Test3: name, discount, toppings" should return:
          //  - status code 200
          //  - message: donair successfully deleted
	public void test_deleteDonairTest3_ShouldSucceed() {
		given()
			.baseUri("http://localhost:3001")
			.basePath("/donairs/search")
			.delete("/Test3: name, discount, toppings")
			.then()
			.assertThat()
			.statusCode(200)
			.body("message", Matchers.equalTo("donair successfully deleted"));
	}
}
