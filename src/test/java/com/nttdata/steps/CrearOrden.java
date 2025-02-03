package com.nttdata.steps;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CrearOrden {

    private static String CREATE_ORDER = "https://petstore.swagger.io/v2/store/order";
    private static String GET_ORDER = "https://petstore.swagger.io/v2/store/order/{orderId}";

    @Step("Crear orden con petId {0}, quantity {1}, shipDate {2}, status {3}, complete {4}")
    public void crearOrden(int petId, int quantity, String shipDate, String status, boolean complete) {
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"petId\": " + petId + ",\n" +
                        "  \"quantity\": " + quantity + ",\n" +
                        "  \"shipDate\": \"" + shipDate + "\",\n" +
                        "  \"status\": \"" + status + "\",\n" +
                        "  \"complete\": " + complete + "\n" +
                        "}")
                .post(CREATE_ORDER);
    }

    @Step("Consultar orden con id {0}")
    public void consultarOrden(long orderId) {
        SerenityRest.given()
                .pathParam("orderId", orderId)
                .get(GET_ORDER);
    }
}