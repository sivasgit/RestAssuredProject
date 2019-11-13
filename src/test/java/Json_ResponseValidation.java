import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;



public class Json_ResponseValidation {

@Test
public void testStatus(){

    given()
             .when()
             .get("https://restcountries.eu/rest/v2/alpha/IN")
             .then()
             .statusCode(200)
             .log().all();




}


}
