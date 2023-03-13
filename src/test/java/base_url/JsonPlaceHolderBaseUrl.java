package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class JsonPlaceHolderBaseUrl {

    protected RequestSpecification spec;

    @Before  //Her test methodundan önce çalışması için before annotation koyduk
    public void setUp(){

        spec = new RequestSpecBuilder().setAccept(ContentType.JSON).setBaseUri("https://jsonplaceholder.typicode.com/").build();
    }

}
