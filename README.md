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
    
    
