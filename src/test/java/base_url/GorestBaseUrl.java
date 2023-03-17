package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GorestBaseUrl {

    protected RequestSpecification spec;

    @Before  //Her test methodundan önce çalışması için before annotation koyduk
    public void setUp(){

        spec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v1").build();
    }

}
