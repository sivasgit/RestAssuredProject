import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;



public class Json_ResponseValidation {

    @Test
    public void testStatus( ) {

        given()
                 .when()
                 .get("https://restcountries.eu/rest/v2/alpha/IN")
                 .then()
                 .body("capital" , equalTo("New Delhi"))//single content validation
                 .body("borders" , hasItems("AFG" , "BGD" , "NPL"))//multiple content
                 .statusCode(200)
                 .log().all();
    }

        public void testParamsAndHeaders() {

            given()
                     .pathParam("country" , "IN")
                     .header("myheader" , "Indians")

                     .when()
                     .get("https://restcountries.eu/rest/v2/alpha/{country}")
                     .then()
                     .statusCode(200)
                     .header("Content-Encoding","gzip")
                     .log().all();

        }

    }


