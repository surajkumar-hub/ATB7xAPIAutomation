package com.thetestingacademy.ex_21092024.TestNGExamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG003 {
    @BeforeTest
    public void getToken()
    {
        System.out.println("1");
    }
    @BeforeTest
    public void getBookingID()
    {
        System.out.println("2");
    }
    @Test
    public void test_PUT()
    {
        // token and BookingID
        System.out.println("3");
    }
}
// O/P: 2
//1
//3
// There is no preference in @BeforeTest. It can be 1 2 3 or 2 1 3 but 3 will be the last
