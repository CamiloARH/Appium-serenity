Feature: Interacción Play Store

  @AppStore
  Scenario: Descargar Waze
    Given que el usuario accede a la tienda de aplicaciones
    When busca la aplicacion "Waze" y la selecciona
    Then deberia poder iniciar la descarga