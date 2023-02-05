package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AuthorizedStep_Defs {

    Register register=new Register();
    @Given("User should be authorized with valid credentials")
    public void user_should_be_authorized_with_valid_credentials() {
        register.authorized();
    }

    @Then("verify authorizedStatusCode")
    public void verify_authorizedStatusCode() {
        register.verifyAuthorized();
    }

}
