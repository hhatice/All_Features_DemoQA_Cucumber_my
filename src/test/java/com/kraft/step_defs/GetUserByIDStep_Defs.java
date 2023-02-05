package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GetUserByIDStep_Defs {

    Register register=new Register();
    @Given("user should see book list")
    public void user_should_see_book_list() {
        register.getUserById();
    }

    @Then("User should verify the BookStatusCode")
    public void user_should_verify_the_BookStatusCode() {
        register.verifyUser();
    }

}
