# language: fr
Fonctionnalité: verification des cas des chevauchement des plages de dates

  Scénario: la 1ere plage commence avant le 2e et se fini avant
    Etant donné ces plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-24 | 2022-01-01 |
    Alors les plages se chevauchent

  Scénario: la 1ere plage commence avant le 2e et se fini après
    Etant donné ces plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-24 | 2022-01-04 |
    Alors les plages se chevauchent


  Scénario: les plages sont disjointes avant
    Etant donné ces plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2021-12-20 | 2021-12-23 |
      | 2000-01-01 | 2000-01-01 |
     Alors les plages ne se chevauchent pas

  Scénario: les plages sont disjointes après
    Etant donné ces plages de date
      | Debut      | Fin        |
      | 2021-12-25 | 2022-01-03 |
      | 2022-01-04 | 2022-01-11 |
    Alors les plages ne se chevauchent pas

  Scénario: un exemple de données JSON
    Etant donné une plage de date en JSON
    """
    {
    debut:  '2021-12-25',
    fin: '2022-01-03'
    }
    """
    Alors les plages ne se chevauchent pas
