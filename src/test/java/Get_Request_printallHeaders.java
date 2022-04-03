import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Request_printallHeaders {

	
	@Test
	public void getHeaders()
	{
		//Base URI
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		//Request object
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//ResponseObject
		
		Response response=httpRequest.request(Method.GET, "/employees");
				
		//Print Response In Console
		
		String responseBody=response.getBody().asString();
		
		//System.out.println("ResponseBody is  "+responseBody);
		
		//Catch specific header type
		
		String cache=response.header("Cache-Control");
		String content=response.header("Content-Encoding");
		
		System.out.println(cache);
		System.out.println(content);
		
		Assert.assertEquals(cache, "no-cache, private, max-age=31536000");
		Assert.assertEquals(content,"gzip");
		
		
		//Capture all Headers From ResponseBody
		
		Headers allHeaders=response.headers();
		
		for(Header e:allHeaders)
		{
			System.out.println(e.getName()+"           "+e.getValue());
			
		}
		
		
	}
}
