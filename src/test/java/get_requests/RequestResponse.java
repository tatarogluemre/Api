package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestResponse {
    /*
    1-) Postman manuel API testi için kullanılır
    2-) API otomosyonu için Rest-Assured Library kullanıcaz
    3-) Otomasyon kodlarının yazımı için şu adımları izliyoruz :
         a- Gereksinimleri anlama
         b- Test Case'i yazma :
            - Test Case yazmak için "Gherkin Language" kullanıyoruz.
               -- Given:  Ön Koşullar --> EndPoint, body
               -- When :  İşlemler --> Get, Put, Delete ...
               -- Then :  Dönütler--> Assert
               -- And  :  Çoklu işlemlerin art arda yazılacağı yerlerde kullanılır.
          c- Test kodunu yazarken şu adımları izleriz :
               -- Set the URL
               -- Set the expected data
               -- Send the request and get the reponse
               -- Do assertion
     */

    public static void main(String[] args) {
        // Get request nasıl yapılır :
        Response response = given().when().get("https://restful-booker.herokuapp.com/booking/198");
        response.prettyPrint();//prettyPrint() methodu reponse datayı Json formatında yazdırır.
       //Status Code Yazdırma:
        System.out.println("Status Code :"+response.statusCode());
       //Contetnt-type yazdırma:
        System.out.println("Content Type : "+response.contentType());
      //Status Line yazdırma:
        System.out.println("Status Line :"+response.statusLine());
      //Header yazdırma:
        System.out.println("Connection :"+response.header("Connection"));
        System.out.println("Server :"+response.header("Server"));
      //Headers yazdırma:
        System.out.println("Headers : \n"+response.headers());
      //Time yazdırma:
        System.out.println("Time : "+response.getTime());


    }


}
