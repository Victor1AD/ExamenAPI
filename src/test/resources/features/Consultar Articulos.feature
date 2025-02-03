Feature: Consulta un servicio

  @consultaArticulos
  Scenario: Consulta un servicio
    Given la url "https://petstore.swagger.io/v2/store/order" del servicio
    When genero la orden
    Then imprimo los articulos