package com.kraft.step_defs;

import com.kraft.services.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountDeleteStep_Defs {

    Register register=new Register();
    @Given("User should delete account")
    public void user_should_delete_account() {
        register.AccountDelete();
    }

    @Then("User should verify delete account status code")
    public void user_should_verify_delete_account_status_code() {
        register.verifyAccountDelete();
    }
}
