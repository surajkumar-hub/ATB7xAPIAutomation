package com.thetestingacademy.ex_15092024.CRUD_Operation.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

//  public class NonBDDStyle {
    /** Rest Assured provides us lot of classes & Interface. One of the interface is
     "RequestSpecification". This interface tells that we can set by using basePath(), header(),
     body(), cookie(), param(), then().
     There is another interface called "ResponseSpecification", which tells us that we can set
     by using statusCode(), statusLine(), header(), body(), contentType(), then()

     Basically, given() part has given to RequestSpecification and then() part has given to
     ResponseSpecification. Basically, here corresponding interfaces are created. **/

    /** static RequestSpecification r = RestAssured.given();
    It means whenever we write RequestSpecification r = RestAssured.given(), we are basically
     saying that "RestAssured.given()" part has given to "RequestSpecification" interface.

     Advantage is we can re-use the reference (r) and can write like this ->
     r.baseUri("https://api.zippopotam.us");
     r.basePath("IN/560037");
     r.when().get();
     r.then().log().all().statusCode(200);

     Now no need to use (.) (.) Like this:
     RestAssured
     .given()
        .baseUri("https://api.zippopotam.us")
        .basePath("/IN/560037")
     .when()
        .log().all().get().
     then()
        .log().all().statusCode(200);**/

/** Note: If we want to re-use the variable, we should use RequestSpecification and if we don't want
        to re-use, then we can write like this (.) (.) (.) **/

public class NonBDDStyleGET {
        static RequestSpecification r = RestAssured.given(); // Common Part

        public static void main(String[] args) {
            // r.relaxedHTTPSValidation(); // This for if we get any SSL related issue
            r.baseUri("https://api.zippopotam.us"); // Common Part // It"ll be executed only once
            testnon_bdd_1();
            testnon_bdd_2();
        }

        private static void testnon_bdd_2() {
            r.basePath("/IN/-1");
            r.when().get();
            r.then().log().all().statusCode(404);
        }

        private static void testnon_bdd_1() {
            r.basePath("/IN/560037");
            r.when().get();
            r.then().log().all().statusCode(200);
        }
    }
    /** Here we have used Common Part only once, and we have reused the variable "r" **/

/** static RequestSpecification r = RestAssured.given(); -> If we write this inside main() method,
 "r" variable won't be global variable, and we can't use outside of the main() **/

/** r.relaxedHTTPSValidation()- This for if we get any SSL related issue, then we can write
 after the given() request **/
