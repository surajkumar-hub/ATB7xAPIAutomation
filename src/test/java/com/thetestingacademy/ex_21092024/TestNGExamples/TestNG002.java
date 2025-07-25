package com.thetestingacademy.ex_21092024.TestNGExamples;

// This is how we can write the test case which can pass the value

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG002 {
    // PUT
    String token;
    Integer bookingID;

    @BeforeTest
    public String getToken()
    {
        token = "123";
        return token;
    }

    @BeforeTest // It means before running this test, we"ll create a booking id
    public void getTokenAndBookingID()
    {
        // POST Req -
        // POST code
        bookingID = 123;
    }


    @Test // This is the actual test case
    public void testPUTReq()
    {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test // This is the actual test case
    public void testPUTReq2()
    {
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test // This is the actual test case
    public void testPUTReq3()
    {
        System.out.println(token);
        System.out.println(bookingID);
    }

}
