Feature: Navegación Web Mobile

  @WebMobile
  Scenario: Navegar en Serebii desde Chrome Mobile
    Given que el usuario desea navegar en la web
    When ingresa a la pagina de serebii
    Then deberia ver el home de la pagina