package get_requests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik,
    2) otomasyon tetsleri icin de Reset Assured Library kullanacagiz
    3) Otomasyon testleri yaparken asagidaki adimlari izliyoruz
        a) Gereksinimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziminda "Gherkin" dilini kullanacagiz.
            Bizler yazilim diline hakim olsakta karsimizdaki kisiler yazilim
            diline hakim olmayabilirler. Oysa Gerkin dili kullanilirsa onlarda
            anlayabilir

            -Given : On kosul olusturmak icin kullanilir,

            -When  : Yapilacak aksiyonlar icin kullanilir(get(), put(), patch() ve delete())

            -Then  : Istek yaptiktan sonra (requets gonderdikten sonra) dogrulama kisminda

            -And   : Coklu islemlerde kullanacagiz


        c)  Test kodlarimizi yazmaya baslayacagiz

            i)   Set the URL,
            ii)  Set the expected Data (bklenen datanin olusturulmasi:Post,Put ve Patch ileolusturacagiz))
            iii) Type code to send request(Talep gondermek icin kod yazimi)
            iv)  Do Assertion(dogrulama yapmak icin)
     */


    /*
Given
        https://restful-booker.herokuapp.com/booking/101
    When
        User sends a GET Request to the url
    Then
        HTTP Status Code should be 200
    And
        Content Type should be JSON
    And
        Status Line should be HTTP/1.1 200 OK
 */
    @Test

    public void get01() {

//            i)   Set the URL,
              String url="https://restful-booker.herokuapp.com/booking/101";

//            ii)  Set the expected Data (bklenen datanin olusturulmasi:Post,Put ve Patch ileolusturacagiz))
                //Bizden Post,put ya da patch istenmedigi icin bu case de kullanmayacgiz

//            iii) Type code to send request(Talep gondermek icin kod yazimi)
              Response response=given().when().get(url);
              response.prettyPrint();

//            iv)  Do Assertion(dogrulama yapmak icin)
              response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");


              //Status Code konsola yazdiralim
              System.out.println("Status Code= "+response.getStatusCode());

              //Content Type konsola yazdiralim
              System.out.println("Content Type= "+response.contentType());

              //Status Line konsola yazdiralim
              System.out.println("Status Line= "+response.statusLine());

              //Header konsola yazdiralim
              System.out.println("Header= "+response.getHeader("Server"));

              //Headers konsola yazdiralim
              System.out.println("Headers= "+response.getHeaders());

              //Time konsola yazdiralim
              System.out.println("Time= "+response.time());
    }
}
