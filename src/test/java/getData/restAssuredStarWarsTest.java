package getData;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;


import io.restassured.http.ContentType;


public class restAssuredStarWarsTest {

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
	
	@Test
	public void starWarsVehicleManufacturer() {
		
		baseURI = "https://swapi.co/api/";
		
		
		String json = get("vehicles/24/?manufacturer=Ubrikkian%20Industries%20Custom%20Vehicle%20Division").asString();
		System.out.println(json);
		
		
		given().
		
		param("manufacturer","Ubrikkian Industries Custom Vehicle Division").
		
		
		when().
		
		get("vehicles/24").
		
		
		then().
		
		body("manufacturer", equalTo("Ubrikkian Industries Custom Vehicle Division") ).
		and().time(lessThan(6000L));
		
		
	}
	
	@Test
	public void starWarsVehicleCost() {
		
		baseURI = "https://swapi.co/api/";
		
		
		String json = get("vehicles/6/?cost%20in%20credits=14500").asString();
		System.out.println(json);
		
		
		given().
		
		param("cost_in_credits","14500").
		
		
		when().
		
		get("vehicles/6").
		
		
		then().
		
		body("cost_in_credits", equalTo("14500") ).
		and().time(lessThan(6000L));
		
		
	}
	
	@Test
	public void starWarsFilmURL() {
		
		baseURI = "https://swapi.co/api/";
		
		
		String json = get("vehicles/7/?films=https://swapi.co/api/films/1/").asString();
		System.out.println(json);
		
		
		given().
		
		param("films","https://swapi.co/api/films/1/").
		
		
		when().
		
		get("vehicles/7").
		
		
		then().
		
		body("films[0]", equalTo("https://swapi.co/api/films/1/") ).
		and().time(lessThan(6000L));
		
		
	}
	
}
