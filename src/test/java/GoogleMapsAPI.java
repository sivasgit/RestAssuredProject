import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;



public class GoogleMapsAPI {


    @Test
    public void getLocations( ) {
        given()
                 .param("key" , "AIzaSyBnR-NW8t_oUP2khBIs6rub_GSlSYBzsB0")
                 .param("types" , "supermarket")

                 .when()
                 .get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&name=harbour")

                 .then()
                 .header("Content-Type" , "application/json; charset=UTF-8")
                 .header("Content-Encoding" , "gzip")
                 .log().all();

    }

    @Test
    public void captureSingleAndMultipleHeaders( ) {
        Response response =
                 given()
                          .param("key" , "AIzaSyBnR-NW8t_oUP2khBIs6rub_GSlSYBzsB0")
                          .param("types" , "supermarket")

                          .when()
                          .get("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&name=harbour");

        //Extract single header value from response
        String headercontentType = response.getHeader("Content-Type");
        System.out.println("The Value of Content-Type header is......." + headercontentType);

        //Extract multiple headers & their values from response
        Headers headers = response.getHeaders();

        System.out.println("The values of Multiple Headers..............");
        for ( Header header : headers ) {
            System.out.println(header.getName() + "    " + header.getValue());
        }

    }

}
