package com.thetestingacademy.ex_14092024;

import io.restassured.RestAssured;

public class Test002 {
    public static void main(String[] args) {
        System.out.println("Rest Assured Test Case");
        System.out.println("GET request Demo");

//        We"ll use Gherkins Syntax
//        given() - URL, HEADERS, Parameters, Body / Payload
//        when() - HTTP Methods - GET, POST, PUT, PATCH, DELETE, HEAD, OPTIONS
//        then() - It basically verify the response (Expected Result = Actual Result)

        // given(), when(), then() = all are static methods

        RestAssured
                .given()
                  .baseUri("https://restful-booker.herokuapp.com")
                  .basePath("/booking/1").log().all()
                .when()
                  .get()
                .then().log().all()
                  .statusCode(200);
    }
}
/** It means given the base url is this - "https://restful-booker.herokuapp.com", base path is
this - "/booking/1" -> when we make GET request -> then status code should be 200   **/

// If the test case is pass then we can't see any output.
// To see all the information use this command - log().all()