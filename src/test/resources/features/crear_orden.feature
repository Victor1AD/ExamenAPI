Feature: Crear y consultar orden en PetStore

  @test2
  Scenario Outline: Crear orden
    When creo la orden con petId <petId>, quantity <quantity>, shipDate "<shipDate>", status "<status>", complete <complete>
    Then el código de respuesta es <statusCode>
    And el status es "<expectedStatus>"

    Examples:
      | petId | quantity | shipDate                     | status   | complete | statusCode | expectedStatus |
      | 0     | 0        | 2025-02-03T20:29:37.658Z    | placed   | true     | 200        | placed         |

  @test2
  Scenario: Consultar orden
    Given una orden con id 1 existe
    When consulto la orden con id 1
    Then el código de respuesta es 200
    And el status es "placed"
