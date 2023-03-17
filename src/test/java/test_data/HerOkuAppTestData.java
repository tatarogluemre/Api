package test_data;

import java.util.HashMap;
import java.util.Map;

public class HerOkuAppTestData {

    public Map<String,String> bookingDatesMethod(String checkin, String checkout){

        Map<String,String> bookingDates = new HashMap<>();
        bookingDates.put("checkin",checkin);
        bookingDates.put("checkout",checkout);
      return bookingDates;

    }

    public Map<String,Object> expectedDataMethod(String firstname ,String lastname , Integer totalprice, Boolean depositpaid,Map<String,String> bookingDates, String additionalneeds){

    Map<String,Object> expectedData = new HashMap<>();
    expectedData.put("firstname",firstname);
    expectedData.put("lastname",lastname);
    expectedData.put("totalprice",totalprice);
    expectedData.put("depositpaid",depositpaid);
    expectedData.put("bookingdates",bookingDates);
    expectedData.put("additionalneeds",additionalneeds);
    return expectedData;

}

}
