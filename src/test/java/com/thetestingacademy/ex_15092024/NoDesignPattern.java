package com.thetestingacademy.ex_15092024;

// No Design Pattern Example

public class NoDesignPattern {

    public void step1()
    {
        System.out.println("Step 1");
    }

    public void step2()
    {
        System.out.println("Step 2");
    }

    public void step3(String param1)
    {
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        NoDesignPattern np = new NoDesignPattern();
        np.step1();
        np.step2();
        np.step3("Pramod");

        /** In this case we are not using any pattern. Means np reference is calling step1(), then
         step2(), then step3(). Instead of this we can do something like BuilderPatternDesign */
    }
}
