package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;

import static io.restassured.RestAssured.given;

public class Get17 extends DummyRestApiBaseUrl {
    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/employee/1
    When
        User sends GET Request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
        "employee_salary" is 320800
    And
        "employee_age" is 61
    And
        "status" is "success"
    And
        "message" is "Successfully! Record has been fetched."
        {
    "status": "success",
    "data": {
        "id": 1,
        "employee_name": "Tiger Nixon",
        "employee_salary": 320800,
        "employee_age": 61,
        "profile_image": ""
    },
    "message": "Successfully! Record has been fetched."
}
     */

    @Test
    public void get17() {

        spec.pathParams("first","employee","second",1);

        DummyRestApiDataPojo dummyRestApiDataPojo=new DummyRestApiDataPojo("Tiger Nixon",320800,61,"");
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",dummyRestApiDataPojo,"Successfully! Record has been fetched.");

        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


    }
}
