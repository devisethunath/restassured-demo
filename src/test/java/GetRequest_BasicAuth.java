import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest_BasicAuth {

	@Test
	public void authorisation()
	{
		//URI
		
		RestAssured.baseURI="https://lms-admin-rest-service.herokuapp.com/programs";
		
		//Basic Authentication
		PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme ();
		authscheme.setUserName("admin");
		authscheme.setPassword("password");
		
		RestAssured.authentication=authscheme;
		
		//REquest Obj
		
		RequestSpecification httpRequest=RestAssured.given();
		
		//ResponseObj
		Response response=httpRequest.request(Method.GET,"/");
		
		String ResponseBody=response.getBody().asString();
		
		System.out.println(ResponseBody);
	}
}
