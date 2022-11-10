package get_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Get16 extends DummyRestApiBaseUrl {
    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    /*
    Given
    https://dummy.restapiexample.com/api/v1/employees

    When
    User send get request

    Then

          i) Status code is 200

    And
         ii) There are 24 employees

    And
         iii) "Tiger Nixon" and "Garrett Winters" are among the employees

    And
         iv) The greatest age is 66

    And
         v) The name of the lowest age is "Tatyana Fitzpatrick"

    And
         vi) Total salary of all employees is 6,644,770


     */

    @Test
    public void get16() {

        spec.pathParam("first","employees");

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //*************Ayni body icinde yapilan assert'ler softassert'tur*****************


        // i) There are 24 employees

        response.then().assertThat().statusCode(200).body("data.employees",hasSize(24),

        // iii) "Tiger Nixon" and "Garrett Winters" are among the employees

                "data.employee_name",hasItems("Tiger Nixon" , "Garrett Winters"));//hasItem= icerisinde bu ogeler varmi sorgusu yapiyor


        // iv) The greatest age is 66
        List<Integer> ages=response.jsonPath().getList("data.employee_age");

        System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("Sorted ages = " + ages);

        System.out.println("The Oldest age= "+ages.get(ages.size()-1));

        assertEquals(66,(int)ages.get(ages.size()-1)); //ages tan geken Integer oldugu icin narrow yaparak primitive int yaptik


        //v) The name of the lowest age is "Tatyana Fitzpatrick"

        //String lowestAgedEmployee=response.jsonPath().getString("data.findAll{it.employee_age == 19}.employee_name");

        String lowestAgedEmployee=response.jsonPath().getString("data.findAll{it.employee_age == "+ages.get(0)+"}.employee_name");
        System.out.println("lowestAgedEmployee = " + lowestAgedEmployee);

        assertEquals("[Tatyana Fitzpatrick]",lowestAgedEmployee);

        // vi) Total salary of all employees is 6,644,770
        
        List<Integer> salaries=response.jsonPath().getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        // 1. Yol

        int sum =0;

        for (int w:salaries){
            sum+=w;
        }
        System.out.println("sum = " + sum);

        assertEquals(6644770,sum);

        // 2. Yol

        int sum2=salaries.stream().reduce(0,(t,u)->t+u); //Lambda ile farkli gosterim
        System.out.println("sum2 = " + sum2);
        
        int sum3=salaries.stream().reduce(0,Integer::sum);
        System.out.println("sum3 = " + sum3);
       
        int sum4=salaries.stream().reduce(0,Math::addExact);
        System.out.println("sum4 = " + sum4);

        assertEquals(6644770,sum4);

    }
}
