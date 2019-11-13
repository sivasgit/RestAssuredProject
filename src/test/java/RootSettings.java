import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;



public class RootSettings {

@Test
    public void root(){
        given()
                 .when()
                 .get(("http://thomas-bayer.com/sqlrest/CUSTOMER/15/"))
                 .then()
                 .statusCode(200)
                 .rootPath("CUSTOMER")
                 .body("ID",equalTo("15"))

                .detachRootPath("CUSTOMER")
                 .body("CUSTOMER.FIRSTNAME",equalTo("Bill"))
                 .log().all();



    }



}
