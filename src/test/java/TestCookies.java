import io.restassured.http.Cookie;
import io.restassured.response.Response;
import java.util.Map;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


//@Test
public class TestCookies {

    public void cookie(){

        given()
                 .when()
                 .get("http://jsonplaceholder.typicode.com/photos")
                 .then()
                 .log().all()
                 .cookie("__cfduid","dc7938d467c6f02e2e07116a000ffc2d31559896449");

    }


    @Test
    public void testcookiesDetails(){

        Response response =
                 when()
                 .get("http://jsonplaceholder.typicode.com/photos");

                 //Extract of value of single cookie
        String cookie=response.getCookie("__cfduid");
        System.out.println("Value of the cookie "+ cookie);


        //extract multiple values of cookies

        Map<String,String>cookies=response.getCookies();

        for(Map.Entry entry:cookies.entrySet())
            System.out.println(entry.getKey()+" " + entry.getValue());


        //extract more info about cookeis
        Cookie cookieinfo =response.getDetailedCookie("__cfduid");
        System.out.println(cookieinfo.hasExpiryDate());
        System.out.println(cookieinfo.getExpiryDate());
        System.out.println(cookieinfo.getMaxAge());
        System.out.println(cookieinfo.getValue());
        System.out.println(cookieinfo.hasDomain());




    }

}
