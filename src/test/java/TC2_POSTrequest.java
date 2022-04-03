import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC2_POSTrequest {
	
	
	@Test
	public void createEmployee() throws InterruptedException
	{
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		
		RequestSpecification request= RestAssured.given();
		
		//Specify request payload in JSONformat
		
		JSONObject requestParams=new JSONObject();
		
		requestParams.put("name","Devi");
		requestParams.put("salary","30000");
		requestParams.put("age","37");
		//requestParams.put("id", 12367);
		
		//Specify Json /Content type
		
		request.header("Content-Type", "application/json");
		
		//Add json to body of request
		
		request.body(requestParams.toJSONString());
		
		
		//POST Request
		
		Response response=request.request(Method.POST,"/create");
		
		System.out.println(response);
		
		Thread.sleep(5000);
		
		//VALIDATION
		
		int statuscode=response.getStatusCode();
		
		System.out.println(statuscode);
		
		Assert.assertEquals(statuscode, 200);
		
		//Validate response success code
		
		String successcode=response.jsonPath().get("SuccessCode");
		
		System.out.println(successcode);
		
		
		
		
		
		
		
		
		
	}

}
