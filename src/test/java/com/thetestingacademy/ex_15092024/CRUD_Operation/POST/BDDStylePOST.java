package com.thetestingacademy.ex_15092024.CRUD_Operation.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePOST {
    // We need below details:
    // POST Request:
    // URL - https://restful-booker.herokuapp.com/auth
    // BODY - PAYLOAD - JSON
    /**
     {
     "username" : "admin",
     "password" : "password123"
     } **/
    // HEADER - Content Type -> application/json

    @Test
    public void test_post() {
        //  Payload cane be given in 3 ways - String(1%), Hashmap(4%), Classes( 95%)

        String payload = "{\n" +
                "                    \"username\" : \"admin\",\n" +
                "                    \"password\" : \"password123\"\n" +
                "                }";
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON).body(payload).log().all()
                .when()
                .post()
                .then()
                .statusCode(200).log().all();
    }
}