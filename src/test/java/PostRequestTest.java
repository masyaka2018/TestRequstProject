
import groovy.json.JsonParser;
import groovy.json.JsonSlurper;
import org.json.JSONObject;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import static io.restassured.RestAssured.*;

public class PostRequestTest {

    String data = "\"{\"title\": \"Homework submission\"," +
            "\"destination\": \"/File Requests/Homework\"," +
            "\"deadline\": {\"deadline\": \"2020-10-12T17:00:00Z\"," +
            "\"allow_late_uploads\": \"seven_days\"}," +
            "\"open\": true}\"";

    @Test
    @Description("Send Post request to server")
    public void sendPortRequest(){
        given()
                .baseUri("https://api.dropboxapi.com/")
                .header("Authorization", "Bearer","Content-Type","application/json")
                .body(data)
                .when()
                .post("/2/file_requests/create")
                .then()
                .assertThat().statusCode(200);
    }
}
