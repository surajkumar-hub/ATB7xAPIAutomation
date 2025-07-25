package com.thetestingacademy.ex_21092024.TestNGExamples;

// DependsOnMethods Concept

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG006 {
    @Test
    public void serverStartedOk()
    {
        System.out.println("I will run first");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void method1()
    {
        System.out.println("method1");
    }
}

/** @Test(dependsOnMethods = "serverStartedOk") It means method1() is now depend upon
serverStartedOk() method. Now serverStartedOk() method will run 1st then method1() will run **/
