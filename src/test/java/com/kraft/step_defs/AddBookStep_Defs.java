package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddBookStep_Defs {

    Register register=new Register();
    @Given("User should add new book")
    public void user_should_add_new_book() {
        register.addBook();
    }

    @Then("User should verify the addBookStatusCode")
    public void user_should_verify_the_addBookStatusCode() {
        register.verifyaddBook();
    }

}
