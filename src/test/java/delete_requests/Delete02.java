package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import org.junit.Test;
import pojos.DummyRestApiDeletePojo;

public class Delete02 extends DummyRestApiBaseUrl {

    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"


                 Given
                 URL: https://dummy.restapiexample.com/api/v1/delete/2

                 When
                 User sends Delete Request and gets response

                 Then
                 i) Status code is 200

                 Then
                 ii) "status" is "success"

                 And
                 iii) "data" is "2"

                 And
                 iv) "message" is "Successfully! Record has been deleted"


       */

    @Test
    public void name() {

        spec.pathParams("first","delete","second",2);

        DummyRestApiDeletePojo expectedData=new DummyRestApiDeletePojo("success","2","Successfully! Record has been deleted");

    }
}
