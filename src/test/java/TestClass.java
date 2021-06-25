import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author umangkumar
 */
public class TestClass {

    @Test
    public void Test1()
    {
        System.out.println("Hello World");
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response=RestAssured.given().contentType(ContentType.JSON)
            .param("postId", "2").log().everything()
            .when()
            .get("/comments")
            .then()
            .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }
}
