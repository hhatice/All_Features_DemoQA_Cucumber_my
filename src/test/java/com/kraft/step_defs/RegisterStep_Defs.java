package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegisterStep_Defs {

    Register register=new Register();
    @Given("User should register with valid credentials")
    public void user_should_register_with_valid_credentials() {
        register.registerNewUser();
    }

    @Then("User should verify the status code")
    public void user_should_verify_the_status_code() {
        register.verifyRegister();
    }


}
