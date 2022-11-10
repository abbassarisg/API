package put_request;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiDataPojo;
import pojos.DummyRestApiResponseBodyPojo;

import static io.restassured.RestAssured.*;

public class Put02 extends DummyRestApiBaseUrl {
    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
                    
                    Given
                    
                    URL: https://dummy.restapiexample.com/api/v1/update/21
                    Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
                    
                    When
                    i) Status code is 200
                    
                    Then
                    ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
                    

     */

    @Test
    public void put02() {

        spec.pathParams("first","update","second",21);

        DummyRestApiDataPojo dummyRestApiDataPojo=new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        DummyRestApiResponseBodyPojo expectedData=new DummyRestApiResponseBodyPojo("success",dummyRestApiDataPojo,"Successfully! Record has been updated.");
        System.out.println("expectedData = " + expectedData);

        Response reponse=given().spec(spec).contentType(ContentType.JSON).body(dummyRestApiDataPojo).when().patch("/{first}/{second}");
    
    
    }
}