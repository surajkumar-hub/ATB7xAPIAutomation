package com.thetestingacademy.ex_15092024;

public class BuilderPatternDesignPatternJava {
    // Change the return type of each method as Class type
    // "this" always points to current/calling object. Returning the same to have same reference

    public BuilderPatternDesignPatternJava Floor1(){
        System.out.println("Floor 1 is Done");
        return this;
    }

    public BuilderPatternDesignPatternJava Floor2(String parm){
        System.out.println("Floor 2 is Done");
        return this;
    }

    public BuilderPatternDesignPatternJava Floor3(){
        System.out.println("Floor 3 is Done");
        return this;
    }

    public static void main(String[] args) {
        BuilderPatternDesignPatternJava bp = new BuilderPatternDesignPatternJava();
        bp.Floor1().Floor2("pramod").Floor3();

    }

}

/** bp.Floor1().Floor2("pramod").Floor3(); - It means, when Floor1 gets completed it"ll return
 to the bp, when Floor 2 gets completed it"ll return to the bp and when Floor3 gets completed,
 it"ll return to the bp.

It's just a design pattern. Design pattern means the way of organizing the things. Here all the
 steps are inter linked with each other.

 Builder pattern means step by step using same reference to build the object.

 Same pattern is used by the Rest Assured. First Rest Assured will prepare a given() request ->
 When given() request is done, it"ll switch to when() request -> and when when() request is done
 then it"ll switch to then() request. It's like Chaining Concept.

 For reference - Floor1 is done by given()
                 Floor2 is done by when()
                 Floor3 is done by then()
 This is called Builder pattern in case of java **/
