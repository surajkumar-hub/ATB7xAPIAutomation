package com.thetestingacademy.ex_21092024.TestNGExamples;

// Concept of how to group the testcases

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG005 {

    @Test(groups = {"sanity", "qa", "preprod"}) // group annotation is used to group the test cases
    public void sanityRun()
    {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun()
    {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"sanity", "qa", "preprod"})
    public void sanityRun1()
    {
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"qa","preprod", "reg"})
    public void RegRun2()
    {
        System.out.println("Reg");
        Assert.assertTrue(false);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun3()
    {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
