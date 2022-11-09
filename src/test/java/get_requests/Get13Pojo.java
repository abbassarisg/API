package get_requests;

import base_urls.GoRestBaseUrl;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestPojo;

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


    }
}
