package com.thetestingacademy.ex_15092024.CRUD_Operation.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePUT {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    // 6118 - This is the booking ID
    // Token -  Token?
    // Payload - {
    //    "firstname" : "Pramod",
    //    "lastname" : "Brown",
    //    "totalprice" : 111,
    //    "depositpaid" : true,
    //    "bookingdates" : {
    //        "checkin" : "2018-01-01",
    //        "checkout" : "2019-01-01"
    //    },
    //    "additionalneeds" : "Breakfast"
    // }


    // To make PUT request, we need to make a POST request to authorize first, which"ll give a token
    // Then we need to make a POST request, which will give Booking ID
    // Then we need to share this Token and Booking ID. Then only PUT will work

//    public void get_token()
//    {
//
//    }
//
//    public void get_booking_id()
//    {
//        return bookingid;
//    }

    @Test
    public void test_put_positive_tc()
    {
        // 1. POST - Auth - token
        // Enter payload to get the token

        String token  = "28ff2f8e7d90c0c";
        String bookingid = "960";

        String payloadPUT= "{\n" +
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
        requestSpecification.basePath("/booking/"+bookingid);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token",token);
        requestSpecification.body(payloadPUT).log().all();

        Response response = requestSpecification.when().put();

         // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }
}
