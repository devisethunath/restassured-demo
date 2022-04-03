import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GetRquest_validateRespBodyContains {


	@Test
	public void validateRespBody()
	{
		//Base Uri
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee";

		//Request Obj
		RequestSpecification httpRequest=RestAssured.given();

		//Resp Obj
		Response response=httpRequest.request(Method.GET,"/11");

		String responseBody=response.getBody().asString();
		
		System.out.println(responseBody);
		
		Assert.assertEquals(responseBody.contains("Jena Gaines"), true);
		
		//Extract all values in Resp Body Using JSON PATH
		
		JsonPath jsonpath= response.jsonPath();
		
		System.out.println(jsonpath.get("employee_name"));
		System.out.println(jsonpath.get("employee_salary"));
		System.out.println(jsonpath.get("employee_age"));
		System.out.println(jsonpath.get("profile_image"));
		
		Assert.assertEquals(jsonpath.get("employee_name"), "Jena Gaines");
		
		
		
		



	}

}
