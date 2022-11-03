package get_request;

import base_url.ReqresBaseUrl;
import io.restassured.filter.log.UrlDecoder;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Set;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get02b extends ReqresBaseUrl {
    @Test
    public void get02() {
         /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

        // Set the Url
        spec.pathParams("first","users","second",23);


        // set expected Data



        //Send The Request and Get The Response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();



        //Do Assertion

        //System.out.println(response.statusCode());
        assertEquals(404,response.statusCode());
        assertEquals("HTTP/1.1 404 Not Found",response.statusLine());
        assertEquals("cloudflare",response.getHeader("Server")); //Server Header'in icinde oldugu icin boyle yazdik cunku Server isimli ayri bir baslik yok
        //assertEquals(0,response.asString().replaceAll("[^A-Za-z0-9]","").length());
        //assertEquals(2,response.asString().replaceAll("\\s","").length());




    }
}
