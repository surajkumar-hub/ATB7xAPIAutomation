package com.thetestingacademy.ex_22092024.POJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class POJO002 {
    // HashMap Payload
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    String bookingId;

    @Test
    public void test_post_with_hashmap()
    {
        // Suppose we want to send this payload
        // {
        //    "firstname" : "sally",
        //    "lastname" : "brown",
        //    "totalprice" : 111,
        //    "depositpaid" : true,
        //    "bookingdates" : {
        //        "checkin" : "2018-01-01",
        //        "checkout" : "2019-01-01"
        //    },
        //    "additionalneeds" : "Breakfast"
        //}

        // Hashmap -> How can we create a Hashmap for this -
        // {} -> This corresponding to a map always
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>(); // Here we are using LinkedHashMap to maintain the order
        jsonBodyUsingMap.put("firstname", "sally"); // In Map, put is used to add a value
        jsonBodyUsingMap.put("lastname", "brown");
        jsonBodyUsingMap.put("totalprice", 111);
        jsonBodyUsingMap.put("depositpaid", true);

        Map<String, Object> bookingDatesMap = new LinkedHashMap<>(); // We have created a new object because this is another type of HashMap
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout", "2019-01-01");

        jsonBodyUsingMap.put("bookingdates", bookingDatesMap);
        jsonBodyUsingMap.put("additionalneeds", "Breakfast");

        System.out.println(jsonBodyUsingMap);


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonBodyUsingMap).log().all();

        Response response = requestSpecification.when().post();

        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        bookingId = response.jsonPath().getString("bookingid");
        System.out.println(bookingId);


    }
}
