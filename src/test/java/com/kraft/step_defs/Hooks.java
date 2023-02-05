package com.kraft.step_defs;

import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.junit.After;

import static io.restassured.path.xml.XmlPath.reset;

public class Hooks {

    @Before
    public void setUp(){

        RestAssured.baseURI="https://demoqa.com";

    }
    @After
    public void tearDown(){
        reset();

    }
}

