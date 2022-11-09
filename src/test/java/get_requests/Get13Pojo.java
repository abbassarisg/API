package get_requests;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get13Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
         {
    "meta": null,
    "data": {
        "id": 2508,
        "name": "Rajinder Acharya",
        "email": "rajinder_acharya@mosciski.net",
        "gender": "female",
        "status": "active"
    }
}
    */

    @Test
    public void get13Pojo() {


        //Set the Url

        spec.pathParams("first","users","second",2508);


        //Set The expected data

        GoRestDataPojo goRestDataPojo=new GoRestDataPojo(2508,"Rajinder Acharya","rajinder_acharya@mosciski.net","female","active");

        GoRestPojo expectedData=new GoRestPojo(null,goRestDataPojo);

        System.out.println(expectedData);


        //Send the request and get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion

       GoRestPojo actualData= response.as(GoRestPojo.class);
        System.out.println(actualData);

       assertEquals(200,response.getStatusCode());
       assertEquals(expectedData.getMeta(),actualData.getMeta());
       assertEquals(goRestDataPojo.getId(),actualData.getData().getId());
       assertEquals(goRestDataPojo.getName(),actualData.getData().getName());
       assertEquals(goRestDataPojo.getEmail(),actualData.getData().getEmail());
       assertEquals(goRestDataPojo.getGender(),actualData.getData().getGender());
       assertEquals(goRestDataPojo.getStatus(),actualData.getData().getStatus());


    }
}
