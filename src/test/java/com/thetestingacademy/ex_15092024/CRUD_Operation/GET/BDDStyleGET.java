package com.thetestingacademy.ex_15092024.CRUD_Operation.GET;

import io.restassured.RestAssured;

public class BDDStyleGET {
    public static void main(String[] args) {

        // GET Request - https://api.zippopotam.us/IN/560037
        // URL
        // HEADER ?
        // GET Method
        // base url = https://api.zippopotam.us
        // basePath = /IN/560037
        // PaYLOAD - ? NO
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No
        // Verification
        // Status Code
        // Response Body
        // Time, Headers ,Cookies

        // Gherkins syntax is -> given(), when(), then()
        // Difference between BDD Style and Non BDD Style:
        // BDD Framework is different - Gherkin Syntax - (given, when, then)
        // Non BDD Style is -> still uses Gherkin syntax (using classes)


        // given  ->
        // URL
        // HEADER ?, Cookies
        // base url = https://api.zippopotam.us
        // basePath = /IN/560037
        // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No

        // When  ->
        // Payload - ? NO/YES - JSON. XML  -> String, Hashmap, Object class
        // GET Method

        // Then()  ->
        // Response Validation
        //  Status Code
        //  Response Body
        //  Time, Headers ,Cookies

        test1();
        test2();
    }

    private static void test2() {
        RestAssured
                .given()
                   .baseUri("https://api.zippopotam.us")
                   .basePath("/IN/-1")
                .when()
                   .log().all().get().
                then()
                   .log().all().statusCode(404);
    }

    private static void test1() {

        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")
                .when()
                .log().all().get().
                then()
                .log().all().statusCode(200);
    }
}
// Here code is repetitive - Disadvantage
