Feature: Seleccionar productos y validar total

  Scenario: Seleccionar tres productos y verificar el total
    When el usuario agrega tres productos al carrito
    Then el total en el carrito debe ser 1830