package com.thetestingacademy.ex_21092024.TestNGExamples.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;

public class Test001_Assertion {
    // POST - Whenever we do create booking -> Verify the Response
    // Status Code
    // Validate the booking Id and Id > 0
    // Id != 0
    // First name last name -  They should be matched with the expected result
    // Response Time
    // Verify the headers

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_post(){
        String payload_POST= "{\n" +
                "    \"firstname\" : \"Pramod\",\n" +
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
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        /** There are 3 types of assertion:
         1. Rest Assured Default - By using Hamcrest
         2. TestNG Assertion (SoftAssert & HardAssert)
         3. AssertJ Assertion **/

        //  1. Rest Assured Default - By using Hamcrest
//        import org.hamcrest.Matchers;
//        validatableResponse.body("booking.firstname",Matchers.equalTo("Pramod"));
//        validatableResponse.body("booking.lastname",Matchers.equalTo("Dutta"));
//        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
//        validatableResponse.body("bookingid",Matchers.notNullValue());

        // 2. TestNG Assertion
        // SoftAssert & HardAssert
        // HardAssert means that if any assertion fails, the remaining statements in that test
        // method will not be executed.

        // Extract the booking Id and firstname
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");

        // Assert.assertNotNull(bookingId); // It means bookingId shouldn't be null
        // Assert.assertEquals(firstname,"Pramod");

        // 3. AssertJ Assertion - fluent assertions java library

        // assertThat(bookingId).isNotNull().isNotZero().isPositive();
        // assertThat(firstname).isEqualTo("Pramod").isNotEmpty().isNotBlank();
        String s = ""; // This is a Empty String
        String s2 = " "; //This is Blank

    }
}
