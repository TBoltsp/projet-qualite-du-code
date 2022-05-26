Feature: PlageHoraire

  Scenario: Plage de Horaire B se termine avant le debut de Horaire de Date A
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-05-10 au 2022-05-20
    Then il ne doit pas y avoir de collision


  Scenario: Plage de Horaire B commence après la fin de Horaire de Date A
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-07-10 au 2022-07-20
    Then il ne doit pas y avoir de collision


  Scenario:  Plage de Horaire B chevauche A par la gauche
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-06-01 au 2022-06-12
    Then il doit y avoir une collision

  Scenario:  Plage de Horaire B chevauche A par la droite
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-06-12 au 2022-06-20
    Then il doit y avoir une collision

  Scenario:  Plage de Horaire B entoure Horaire de Date A
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-06-01 au 2022-06-20
    Then il doit y avoir une collision


  Scenario:  Plage de Horaire B est entoure par Horaire de Date A
    Given Plage de horaire A du 2022-06-10 au 2022-06-15
    When Plage de horaire B va du 2022-06-11 au 2022-06-14
    Then il doit y avoir une collision

  