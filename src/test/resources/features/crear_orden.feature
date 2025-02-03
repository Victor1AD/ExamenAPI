Feature: Crear y consultar orden en PetStore

  @test2
  Scenario: Crear orden
    When creo la orden con petId 0, quantity 0, shipDate "2025-02-03T20:29:37.658Z", status "placed", complete true
    Then el código de respuesta es 200
    And el status es "placed"

  Scenario: Consultar orden
    Given una orden con id 1 existe
    When consulto la orden con id 1
    Then el código de respuesta es 200
    And el status es "placed"