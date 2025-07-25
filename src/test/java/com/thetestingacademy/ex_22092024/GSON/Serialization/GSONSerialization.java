package com.thetestingacademy.ex_22092024.GSON.Serialization;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

public class GSONSerialization {

    // As of now we have used Strings & Hashmap
    // Now we"ll use Class - Pojo ((Plain Old Java Object))
    // Create a class for the Payload - pojo class
    // PUT Request demo
    // We need - token, booking id

//    String payload = "{\n" +
//                "firstname" : "Jim",
//                "lastname" : "Brown",
//                "totalprice" : 111,
//                "depositpaid" : true,
//                "bookingdates" : {
//                "checkin" : "2018-01-01",
//                        "checkout" : "2019-01-01"
//            },
//                "additionalneeds" : "Breakfast"
//            }
    // How can we convert this String payload into a class

    RequestSpecification r = RestAssured
            .given();
    Response response;
    ValidatableResponse validatableResponse;

    @Description("TC#1 - Verify that create booking is working with valid payload")
    @Test
    public void testNonBDDStylePOSTPositive()
    {
        // Payload
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        BookingDates bookingdates = new BookingDates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);
        // Convert Java Object -> JSON String (byteStream) - Serialization
        Gson gson = new Gson();
        String jsonStringpayload = gson.toJson(booking);
        System.out.println(jsonStringpayload);


        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonStringpayload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);


        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // DeSerilization we"ll do here when we want to Parse the response
        // And when we"ll get the response then only we can do the DeSerilization

    }
}
