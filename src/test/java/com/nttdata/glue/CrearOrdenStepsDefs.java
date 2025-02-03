package com.nttdata.glue;

import com.nttdata.steps.CrearOrden;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CrearOrdenStepsDefs {

    @Steps
    CrearOrden crearOrden;

    @ParameterType("true|false")
    public boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }

    @When("creo la orden con petId {int}, quantity {int}, shipDate {string}, status {string}, complete {booleanValue}")
    public void crearOrden(int petId, int quantity, String shipDate, String status, boolean complete) {
        crearOrden.crearOrden(petId, quantity, shipDate, status, complete);
    }

    @Then("el código de respuesta es {int}")
    public void elCódigoDeRespuestaEs(int statusCode) {
        restAssuredThat(response -> response.statusCode(statusCode));
    }

    @And("el status es {string}")
    public void elStatusEs(String status) {
        restAssuredThat(response -> response.body("status", equalTo(status)));
    }

    @Given("una orden con id {long} existe")
    public void unaOrdenConIdExiste(long orderId) {
        // Aquí podrías agregar lógica para asegurarte de que la orden existe, si es necesario
    }

    @When("consulto la orden con id {long}")
    public void consultoLaOrdenConId(long orderId) {
        crearOrden.consultarOrden(orderId);
    }
}