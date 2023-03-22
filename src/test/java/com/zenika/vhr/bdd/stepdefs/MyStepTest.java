package com.zenika.vhr.bdd.stepdefs;

import com.zenika.vhr.bdd.SpringIntegrationTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

//Not the real use case
public class MyStepTest extends SpringIntegrationTest {


    @Given("^user wants to create an account")
    public void create_account(DataTable table) throws IOException {

        List<Map<String, String>> signUpForms = table.asMaps(String.class, String.class);
        String id = signUpForms.get(0).get("id");
        String name = signUpForms.get(0).get("name");
        System.out.println(name);
    }

    @When("^account is saved$")
    public void saved() throws IOException {

        this.executeGet("http://localhost:8080/example/poke");
    }

    @Then("^the save 'IS SUCCESSFUL'$")
    public void receive_snek_snek() throws IOException {
        assertThat(latestResponse).isNotNull();
        assertThat(latestResponse.getTheResponse().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}
