package newAPItesting;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.util.HashMap;
public class NewsampleAPI {

	@Test
	public void get_request()
	{
		Response res=
				given()
				.when()

				.get("https://gorest.co.in/public/v1/users/715")
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.contentType("application/json")
				.log().all()
	//.body("email", equalTo("subhasini_fr_shah@wyman-maggio.org"))
				.extract().response();
		String jsonString=res.asString();
		
		Assert.assertEquals(jsonString.contains("subhasini_fr_shah@wyman-maggio.org"), true);
	//	Assert.assertEquals("email",equalTo("subhasini_fr_shah@wyman-maggio.org"));
		
//	Assert.assertEquals("data[0].id", equalTo(17));

	}
	@Test
	public void post_request()
	{
		
		JSONObject object=new JSONObject();
		
		
		object.put("name","Devi");
		object.put("job","SDET");
		
		Response res=
		given()
		.body(object)
		.contentType("application/json")
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.log().all()
		.extract().response();
	
				
		String jsonString=res.asString();
		
		Assert.assertEquals(jsonString.contains("Devi"), true);
	}


}
