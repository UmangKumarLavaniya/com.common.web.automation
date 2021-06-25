import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Given;
import com.test.xyz.TestRequestPojo;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * @author umangkumar
 *
 */
public class TestXyz {

	TestRequestPojo trp=new TestRequestPojo();
	//@Test
	public void Test123()
	{
		TestRequestPojo trp=new TestRequestPojo();
		trp.setName("wqewqd");
		
		RestAssured.baseURI="https://xyz.com";
		//Response response=given().header("ContentType","application/json").payload(myRequestPojo)
		
	}
}
