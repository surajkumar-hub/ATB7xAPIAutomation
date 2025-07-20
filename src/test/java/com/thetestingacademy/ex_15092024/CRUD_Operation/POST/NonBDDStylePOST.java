package com.thetestingacademy.ex_15092024.CRUD_Operation.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class NonBDDStylePOST {
    // We need below details:
    // POST Request
    // URL - https://restful-booker.herokuapp.com/auth
    // BODY - PAYLOAD - JSON
    /**
     {
     "username" : "admin",
     "password" : "password123"
     } **/
    // HEADER - Content Type -> application/json

    @Test
    public void test_non_bbd_post() {

        //  Payload cane be given in 3 ways - String(1%), Hashmap(4%), Classes( 95%)

        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";

        // Given - It is basically request specification
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);
        // This is preparation of the request

        // When - Response
        Response response = r.when().post(); // Response is one more interface
        // This is making of the request

        // Then - Validation Part
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);
        // This is verification of the request
    }
}
