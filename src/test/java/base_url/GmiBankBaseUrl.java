package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import utilities.AuthenticationGmiBank;

public class GmiBankBaseUrl {

    protected RequestSpecification spec;

    @Before  //Her test methodundan önce çalışması için before annotation koyduk
    public void setUp(){

        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).addHeader("Authorization","Bearer "+AuthenticationGmiBank.getAuthentication()).setBaseUri("https://www.gmibank.com").build();
    }

}
