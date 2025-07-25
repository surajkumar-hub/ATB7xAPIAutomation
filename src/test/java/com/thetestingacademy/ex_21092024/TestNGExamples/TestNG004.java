package com.thetestingacademy.ex_21092024.TestNGExamples;

// Concept of adding priority to the test case

import org.testng.annotations.Test;

public class TestNG004 {

    @Test(priority = 1)
    public void t1()
    {
        System.out.println("1");
    }

    @Test(priority = 0)
    public void t2()
    {
        System.out.println("3");
    }

    @Test(priority = 3)
    public void t3()
    {
        System.out.println("2");
    }
}
