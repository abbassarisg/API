package get_requests;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08b extends JsonplaceholderBaseUrl {

    //    *****Get08 Class'inin dinamik yontemle yapilisi



    //De-Serialization: Json datayı Java objesine çevirme
    //Serialization: Java objesini Json formatına çevirme.
    //De-Serialization: Iki türlü yapacağız.
    //Gson: Google tarafından üretilmiştir.
    //Object Mapper: Daha popüler...

      /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get08b() {

        //De-Serialization: Json datayı Java objesine çevirme
        //Serialization: Java objesini Json formatına çevirme.
        //De-Serialization: Iki türlü yapacağız.
        //Gson: Google tarafından üretilmiştir.
        //Object Mapper: Daha popüler...


        // Set the url

        spec.pathParams("first","todos","second",2);


        //Set the Expected data

        JsonPlaceHolderTestData objJsonPLaceHolder=new JsonPlaceHolderTestData();
        Map<String,Object> expectedData=objJsonPLaceHolder.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion

        Map<String,Object> actualData=response.as(HashMap.class); //De=Serialization
        System.out.println("actualData = " + actualData);
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
        assertEquals("1.1 vegur",response.getHeader("Via"));
        assertEquals("cloudflare",response.getHeader("Server"));
        assertEquals(200,response.statusCode());


    }
}