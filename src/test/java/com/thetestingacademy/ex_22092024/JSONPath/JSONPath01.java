package com.thetestingacademy.ex_22092024.JSONPath;

// How can we extract the data from a JSON

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
// import com.github.javafaker.Faker;

public class JSONPath01 {

    //  POST - Create -> Verify the Response
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_post(){
        String dynamic_value = "James"; // How to add dynamic value

        Faker faker = new Faker();
        String dynamic_fake_name = faker.name().fullName();
        System.out.println(dynamic_fake_name);
        // Java Faker will give fake details

        String payload_POST= "{\n" +
                "    \"firstname\" : \""+dynamic_value+"\",\n" +
                "    \"lastname\" : \"Dutta\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST);

        Response response = requestSpecification.when().post();

        System.out.println(response.asString()); // To print & see the response

        // How can we make this JSON path format so that we can get all the values?
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId  = jsonPath.getString("bookingid");
        String firstname  = jsonPath.getString("booking.firstname");
        String checkout  = jsonPath.getString("booking.bookingdates.checkout");
        System.out.println(bookingId);
        System.out.println(firstname);
        System.out.println(checkout);

        assertThat(bookingId).isNotNull().isNotBlank().isGreaterThan("0");
        assertThat(firstname).isNotNull().isNotBlank().isEqualTo("Pramod");
        assertThat(checkout).isNotNull().isNotBlank();

        Assert.assertEquals(firstname,"Pramod"); // This is using TestNG Assertion

}
}
