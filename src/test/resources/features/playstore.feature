Feature: Login en Swag Labs App

  @NativeApp
  Scenario: Login exitoso con usuario estándar
    Given que el usuario abre la app de Swag Labs
    When ingresa el usuario "standard_user" y clave "secret_sauce"
    Then deberia ver la lista de productos