package get_requests;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends RestfulBaseUrl {

     /*
        Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
             {
            {
    "firstname": "Adam",
    "lastname": "Macioszek",
    "totalprice": 400,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2021-01-01",
        "checkout": "2021-12-01"
    },
    "additionalneeds": "Bathroom"
}
            },
            "additionalneeds": "Breakfast"
            }
     */

    @Test
    public void get09() {

        //Set the url

        spec.pathParams("first","booking","second","91");


        //Set the expectedData

        Map<String,String> bookingdatesMap=new HashMap<>();
        bookingdatesMap.put("checkin","2021-01-01");
        bookingdatesMap.put("checkout","2021-12-01");

        Map<String,Object> expecteData= new HashMap<>();

        expecteData.put("firstname","Adam");
        expecteData.put("lastname","Macioszek");
        expecteData.put("totalprice",400);
        expecteData.put("depositpaid",true);
        expecteData.put("bookingdates",bookingdatesMap);

        System.out.println("expecteData = " + expecteData);

        //Send the request and get the reponse
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Map<String ,Object> actualData=response.as(HashMap.class);

        assertEquals(expecteData.get("firstname"),actualData.get("firstname"));
        assertEquals(expecteData.get("lastname"),actualData.get("lastname"));
        assertEquals(expecteData.get("totalprice"),actualData.get("totalprice"));
        assertEquals(expecteData.get("depositpaid"),actualData.get("depositpaid"));
        assertEquals(bookingdatesMap.get("checkin"),((Map) (actualData.get("bookingdates"))).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"),((Map) (actualData.get("bookingdates"))).get("checkout"));





    }
}
