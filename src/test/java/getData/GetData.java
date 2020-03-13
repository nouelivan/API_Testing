package getData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;


import io.restassured.http.ContentType;


public class GetData {

	@Test
	public void starWarsVehicleTestStatus200( ) {
	
		given().
		
		baseUri("https://swapi.co").
		contentType(ContentType.JSON).
		
		
		when().
		
		get("/api/vehicles/14").
		
		
		then().
		
		statusCode(200);
	
	}
	
	@Test
	public void starWarsVehicleName() {
		
		baseURI = "https://swapi.co/api/";
		
		
		String json = get("vehicles/14/?name=Snowspeeder").asString();
		System.out.println(json);
		
		
		given().
		
		param("name","Snowspeeder").
		
		
		when().
		
		get("vehicles/14").
		
		
		then().
		
		body("name", equalTo("Snowspeeder") ).
		and().time(lessThan(6000L));
		
		
	}
	
	@Test
	public void starWarsPilotURL() {
		
		baseURI = "https://swapi.co/api/";
		
		
		String json = get("vehicles/14/?pilots=https://swapi.co/api/people/1/").asString();
		System.out.println(json);
		
		
		given().
		
		param("pilots","https://swapi.co/api/people/1/").
		
		
		when().
		
		get("vehicles/14").
		
		
		then().
		
		body("pilots[0]", equalTo("https://swapi.co/api/people/1/") ).
		and().time(lessThan(6000L));
		
		
	}
	
}
