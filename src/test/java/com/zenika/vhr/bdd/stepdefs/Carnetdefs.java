package com.zenika.vhr.bdd.stepdefs;

import com.zenika.vhr.bdd.SpringIntegrationTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Carnetdefs extends SpringIntegrationTest {
    @Given("garagiste with attributes")
    public void garagisteWithAttributes(DataTable table) {

        /*List<Map<String, String>> signUpForms = table.asMaps(String.class, String.class);
        String email = signUpForms.get(0).get("email");
        System.out.println(email);*/
        //genere token

    }


    @Given("Carnet with attributes exits")
    public void carnetWithAttributesExits() {
    }

    @When("jeveux consulter le carnet")
    public void jeveuxConsulterLeCarnet() throws IOException {

        /*var carnetId = "123";
        this.executeGet("http://localhost:8080/api/carnet/"+carnetId);*/
    }

    @Then("le carnet est rendus")
    public void leCarnetEstRendus() throws IOException {
        //assertThat(latestResponse.getTheResponse().getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @And("le carnet contient les operations")
    public void leCarnetContientLesOperations() {
        //assertThat(latestResponse.getBody()).isNotNull();

    }

    @Given("propriétaire with attributes")
    public void propriétaireWithAttributes() {

        //genre un token pour le proprio
    }

}
