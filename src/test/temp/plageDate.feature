# language: fr
Feature: PlageDate

Scenario: Plage de Date B se termine avant le debut de Plage de Date A
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-05-10 au 2022-05-20
Then il ne doit pas y avoir de colision


Scenario: Plage de Date B commence après la fin de Plage de Date A
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-07-10 au 2022-07-20
Then il ne doit pas y avoir de colision


Scenario:  Plage de Date B chevauche A par la gauche
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-06-01 au 2022-06-12
Then il doit y avoir de colision

Scenario:  Plage de Date B chevauche A par la droite
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-06-12 au 2022-06-20
Then il doit y avoir de colision

Scenario:  Plage de Date B entoure Plage de Date A
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-06-01 au 2022-06-20
Then il doit y avoir de colision


Scenario:  Plage de Date B est entoure par Plage de Date A
Given Plage de date A du 2022-06-10 au 2022-06-15
When Plage de date B va du 2022-06-11 au 2022-06-14
Then il doit y avoir de colision
