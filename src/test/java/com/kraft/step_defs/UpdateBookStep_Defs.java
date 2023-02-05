package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UpdateBookStep_Defs {

    Register register=new Register();
    @Given("User should update the collection")
    public void user_should_update_the_collection() {
        register.updatebook();
    }

    @Then("User should verify the updateStatusCode")
    public void user_should_verify_the_updateStatusCode() {
        register.verifyUpdateBook();
    }

}
