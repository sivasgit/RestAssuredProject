import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class Authentication {


    @Test
    public void basicAuthentic(){

        given()
               //  .auth().basic("ToolsQA","TestPassword")
                 .auth().digest("ToolsQA","TestPassword")
                 .when()
                 .get("http://restapi.demoqa.com/authentication/CheckForAuthentication/")
                 .then()
                 .log().all()
                 .statusCode(200);







    }



}
