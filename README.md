# PROJET : MESURE DE L'IMPACT DE L'INSERTION PROFESSIONNELLE DE LA JEUNESSE IVOIRIENNE SUR LE PIB
#### 
---
Présentation : Nom de l'APPLICATION **OATOO**

|   Outils   |          Description                   |
| -----------|----------------------------------------|
| HTML       |  Utilisation de Bootsrap               |
| ANGULAR    | POUR LE FRONT-END                      |
| SPRING BOOT| POUR LE BACK-END  AVEC JWT TOKEN       |
| LIBRAIRIES | MODIFICATION DU CODE CSS ET RESPONSIVE |
| BOOSTSTRAP | Utilisation du CDN                     |

---
## Description du projet

> Le projet consiste à mettre en place une plateforme de gestion des demandeurs d'emploi et surtout l'impact que peut avoir leur insertion sur le PIB.

    + Constat:
        -   L’emploi des jeunes est un enjeu majeur pour le continent en général, et la Côte
d’Ivoire en particulier. Le taux de sous-employabilité est élevé et beaucoup de jeunes
restent dans la précarité. Au vue de ce constat depuis quelques années le
gouvernement ivoirien à adopter une nouvelle vision celle de l’année de la jeunesse.
        -   Cette vision est d’ améliorer le taux d’insertion professionnelle à travers des
formations intégrations, des ateliers, des financements de projets, les incubateurs de
startup. C’est dans ce cadre que notre application dénoté Oatoo prend tout son sens.

>>> L’application vise à mesurer de manière efficiente l’impact du taux d’employabilité
sur le PIB ivoirien durant une période bien définie. En effet la loi d&#39;Okun décrit une
relation linéaire empirique entre le taux de croissance (du PIB) et la variation du taux
de chômage. En dessous d&#39;un certain seuil de croissance, le chômage augmente ; au-
dessus de ce seuil, il diminue, à élasticité constante. En se basant sur cette loi et en
étudiant les impôts payés par les ex-chômeurs.


## LES ENTITES

Règle `Liste des entités utilisées dans l'application au niveau du front-end et du back-end
`


---
==Table librairies==

`Les Propiétés de la table librairies`
``` --id
    --name
    --adress
    --phone
    --email
    --gestionnaire
    --heure d'ouverture
    --heure de fermeture
    --createdat
    --updatedat

```
---


+ LISTE DES TACHES :
  - 0-Installation de l'environnement marven    OK
  - 1-Creation du projet spring boot      OK
  - 2- Creation de la base de donnee      OK
  - 3- Definition des tables de la base de donnee   OK
  - 4- Connexion de la base de donnée 
  - 5- Structure de l'application
  - 6- Creation du modele
  - 7- Creation des repositories
  - 8- Creation des controllers
  - 9- Creation des services 



## TRAVAIL A FAIRE
- La page index.html doit être modifier 
    > Utilisation de overplay ou code dans le commentaire pour le carousel
    > Ajuster les cadres pour la consommation des API pour les listes de produits
    > Ajouter un footer

- La page register.html, register.js doit être modifier 
    > Utilisation du code https://github.com/LordWinNgoran/PratiqueHtmlCssJs
    > Gestion du mot de passe , champ vide, et enregistrment dans le localstorage
    > Rediriger sur la page de connexion

- La page login.html doit être modifier  et creer un js pour le login
    > Utilisation du code https://github.com/LordWinNgoran/PratiqueHtmlCssJs
    > Gestion du mot de passe , champ vide, et verification du mot de passe et email
    > Si email et mot de passse sont corrects Afficher dans un alert "Vous êtes connecté"

### RAPPEL CODE APPEL API JS
`fetch('https://fakestoreapi.com/products', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
        },
    })
    .then(response => response.json())
    .then(response =>
        appendData(response));
`
appendData est une fonction qui permet d'inserer dans le **DOM** les cadres de consommation de l'API Fakestore.

## MERCI ATOS MERCI A VOUS ENSEMBLE NOUS IRONS LOIN

<div style="text-align:center"><img src="./assets/img/carousel-1.JPG" /></div>.










# Di-Bootcamp-DI-Bootcamp-Final-Project-Oatoo


---
__Advertisement :)__

- __[Spring boot ](https://start.spring.io/)__ - Site de génération de projet avec spring boot.
- __[Angular](https://angular.io/cli)__ - Site officiel Angular pour installation,configuration et la documentation.

#### Projet Bibliothèque (R) Atos Atos Digital academy

####  GROUPE JAVA : Signé 2022 - 2023 :
>>> 1. Formateur: Mr Gouguia Yannick
>>> 2. Délégué: N'Guessan Marina
>>> 3. Sous-délégué: Sango Désiré

---
## Description du projet

> Le projet consiste à mettre en place un systeme de gestion de librairie. Nous pouvons enregistrer plusieurs librairies
et pour chaque librairie, nous aurons plusieurs livres, autheur....


+ LISTE DES TACHES :
  - 0-Installation de l'environnement marven    OK
  - 1-Creation du projet spring boot      OK
  - 2- Creation de la base de donnee      OK
  - 3- Definition des tables de la base de donnee   OK
  - 4- Connexion de la base de donnée 
  - 5- Structure de l'application
  - 6- Creation du modele
  - 7- Creation des repositories
  - 8- Creation des controllers
  - 9- Creation des services 


## Tables

Règle `Ajouter des livres, pour chauque livre nous avons une ou plusieurs categories, un ou plusieurs auteurs
`




---
==Table librairies==

`Les Propiétés de la table librairies`
``` --id
    --name
    --adress
    --phone
    --email
    --gestionnaire
    --heure d'ouverture
    --heure de fermeture
    --createdat
    --updatedat

```
---

==Table books==

`Les Propiétés de la table books`
``` --id
    --librairy_id
    --title
    --description
    --isbn
    --nombre de page
    --maison d'edition
    --date de parution
    --createdat
    --updatedat

```
---

==Table categories==

`Les Propiétés de la table categories`
``` --id
    --librairy_id
    --libelle
    --createdat
    --updatedat

```
---


==Table authors==

`Les Propiétés de la table categories`
```  --id
    --librairy_id
    --fullname
    --address
    --phone
    --email
    --gender
    --createdat
    --updatedat
```
---

 ` ### Les relations`

##### - many to many:



---


==Table books_categories==

`Les Propiétés de la table books_categories`
```  --book_id
     --category_id
     --createdat
     --updatedat
```
---


==Table authors_books==

`Les Propiétés de la table authors_books`
```  --author_id
     --book_id
     --version
     --createdat
     --updatedat
```
---
    
    
