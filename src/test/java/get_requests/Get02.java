package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
    /* Given
    https://restful-booker.herokuapp.com/booking/1
    When
    User send a GET Request to the url
    Then
    HTTP Status code should be 404
    And
    Status Line should be HTTP/1.1 404 Not Found
    And
    Response body contains "Not Found"
    And
    Response body does not contain "TechProEd"
    And
    Server is "Cowboy"
            */

    @Test
    public void get01() {


//      i)   Set the URL

        String url="https://restful-booker.herokuapp.com/booking/1";


//      ii)  Set the expected Data (bklenen datanin olusturulmasi:Post,Put ve Patch ileolusturacagiz))
        //Bizden Post,put ya da patch istenmedigi icin bu case de kullanmayacgiz


//      iii) Type code to send request(Talep gondermek icin kod yazimi)

        Response response=given().when().get(url);
        response.prettyPrint();


//      iv)  Do Assertion(dogrulama yapmak icin)

        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");


        assertTrue(response.asString().contains("Not Found"));
        //Body Not Found iceriyor mu testi

        assertFalse(response.asString().contains("TechProEd"));
        //Body nin TechProEd icermedigi tets edildi

        assertEquals("Cowboy",response.getHeader("Server"));
        //Server'in Cowboy olup olmadigini test ediyoruz
    }
}
