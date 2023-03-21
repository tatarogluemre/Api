package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    protected RequestSpecification spec;

    @Before  //Her test methodundan önce çalışması için before annotation koyduk
    public void setUp(){

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://dummy.restapiexample.com/api/v1").build();
    }

}
