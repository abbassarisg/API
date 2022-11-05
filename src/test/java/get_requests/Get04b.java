package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends RestfulBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void get04() {

        //Set The Url


        //   tek parametre oldugu icin "s" yok      query oldugu icin "queryParams" kullanildi
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");

        //Set The expected Data


        //Send The request and get The Response

       Response response= given().spec(spec).when().get("/{first}");
       response.prettyPrint();

       assertEquals(200,response.statusCode());
       assertTrue(response.asString().contains("bookingid"));

    }
}
