package com.thetestingacademy.ex_21092024.TestNGExamples;

// Concept of parameter

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG007 {
    @Parameters("browser")
    @Test
    void demo1(String value)
    {
        System.out.println("Browser is " +value);
        // Open the Browser and select dadadada

    }
}
/** In this program, demo1(String value) function require some value, and we can send the value from
 another testng file */
// Ex - testng_parameters_chrome.xml