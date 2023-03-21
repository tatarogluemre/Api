package utilities;

import org.codehaus.jackson.map.ObjectMapper;
import pojos.JsonPlaceHolderPojo;

import java.io.IOException;

public class ObjectMapperUtil {

    public static <T> T convertJsonToJava(String json, Class<T> cls){   //<T> T --> herhangi bi data tipi demek

        try {
           return new ObjectMapper().readValue(json,cls);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
