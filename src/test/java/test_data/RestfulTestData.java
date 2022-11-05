package test_data;

import java.util.HashMap;
import java.util.Map;

public class RestfulTestData {

    public Map<String,String > bookigndatesMethod(String checkin,String checkout){

        Map<String,String> bookingdatesMap=new HashMap<>();
        bookingdatesMap.put("checkin",checkin);
        bookingdatesMap.put("checkout",checkout);

    return bookingdatesMap;

             }

       public Map<String,Object> expectedDataMethod(String firstname,String lastname,Integer totalprice,Boolean depositpaid,Map<String,String> bookingdates){


        Map<String ,Object> expectedData=new HashMap<>();

        expectedData.put("firstname",firstname);
        expectedData.put("lastname",lastname);
        expectedData.put("totalprice",totalprice);
        expectedData.put("depositpaid",depositpaid);
        expectedData.put("bookingdates",bookingdates);

                    return expectedData;
        }

      // "           booking": {
      //              " firstname": "John",
      //             "lastname": "Doe",
      //             "totalprice": 11111,
      //             "depositpaid": true,
      //             "bookingdates"


    public Object objectToMap(Object o){

        return (Map)o;
    }

    }


