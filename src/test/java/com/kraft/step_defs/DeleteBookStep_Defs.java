package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteBookStep_Defs {

    Register register=new Register();
    @Given("User should delete a book")
    public void user_should_delete_a_book() {
        register.deleteBook();
    }

    @Then("User should verify deleteStatusCode")
    public void user_should_verify_deleteStatusCode() {
        register.verifyDeleteBook();
    }
}
