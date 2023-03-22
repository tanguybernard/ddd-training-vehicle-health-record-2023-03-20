Feature: Obtenir Carnet

  Scenario: En tant que garagiste je veux consulter le carnet

    Given garagiste with attributes
      | email               |
      | garagiste.green@fs.com |
    Given Carnet with attributes exits
      | idCarnet | nom |
      | abc |   Renault       |
      | def |      Peugeot    |

    When jeveux consulter le carnet
    Then le carnet est rendus
    And le carnet contient les operations


  Scenario: En tant que proprietaire je veux consulter le carnet

    Given propriétaire with attributes
      | email               |
      | proprio.green@fs.com |

    When jeveux consulter le carnet
    Then le carnet est rendus
    And le carnet contient les operations