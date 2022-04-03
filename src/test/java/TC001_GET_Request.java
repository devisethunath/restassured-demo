import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_Request {
	
	@Test
	void getWeatherDetails()
	{
		//specify basr URI
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";   
		
		RequestSpecification httpRequest=RestAssured.given();
		
		Response response=httpRequest.request(Method.GET,"/1");
		
		//Extract body from response
		
		String responsebody=response.andReturn().getBody().asString();
		
		System.out.println(responsebody);
		
		//Status code
		
		int statuscode=response.getStatusCode();
		
		String statusline=response.getStatusLine();
		
		//validation
		
		Assert.assertEquals(statuscode, 200);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}

}
