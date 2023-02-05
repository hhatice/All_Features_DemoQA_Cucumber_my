package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GenerateTokenStep_Defs {

    Register register=new Register();
    @Given("input valid credentials")
    public void inputValidCredentials() {
        register.generateToken();
    }
    @Then("verify tokenStatusCode")
    public void verifyTokenStatusCode() {
        register.verifyRegister();

    }
}
