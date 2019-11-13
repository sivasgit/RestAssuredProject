import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;



public class XML_ResponseValidation {

    @Test
    public void testSingleContent( ) {

        given()
                 .when()
                 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                 .then()
                 .statusCode(200)
                 .body("CUSTOMER.ID" , equalTo("15"))
                 .body("CUSTOMER.FIRSTNAME" , equalTo("Bill"))
                 .body("CUSTOMER.CITY" , equalTo("Seattle"))
                 .log()
                 .all();

    }

    @Test
    public void testMultipleContent( ) {
        given()
                 .when()
                 .get("http://thomas-bayer.com/sqlrest/CUSTOMER/15/")
                 .then()
                 .body("CUSTOMER.text()" , equalTo("15BillClancy319 Upland Pl.Seattle"))
                 .log().all();

    }
    @Test
    public void testUsingXpath(){

        given()
                 .when()
                 .get(("http://thomas-bayer.com/sqlrest/INVOICE/"))
                 .then()
                 .body(hasXPath("/INVOICEList/INVOICE[text()='20']"))
                 .log().all();




    }

}
