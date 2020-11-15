# RPG par Thibault et Sophie - Tests par itérations

## Test 1 : Test de la classe "Entities.Character"
La classe "Entities.Character" définit un personnage tout simplement. Il possède des points de vie et un nom. Il ne peut pas dépasser les 100 points de vie et si il atteint 0 il meurt.

Un "Entities.Character" peut attaquer un autre "Entities.Character" mais il ne peut pas s'attaquer lui-même Une attaque retire 1 point de vie à un personnage. 

Un "Entities.Character" peut soigner un autre "Entities.Character" mais aussi lui-même. Un soin redonne 1 point de vie à la cible.


## Test 2 : Test de la classe "Warrior"
La classe "Warrior" est une extension de la classe "Character". Un "Warrior" à la proprité de donner entre 0 et 9 points de dégats et il peut s'attaquer lui-même. Il ne peut pas soigner d'autres personnes aussi.

On va donc tester ici les dégats donnés aux ennemis et à lui-même, qu'il ne puisse pas soigner d'ennemis mais que lui-même.

## Test 3 : Test de la classe "Priest"
Le "Priest" est comme un "Warrior" une extension de la classe "Character". Un "Priest" est un personnage de pouvant faire de dégats à un ennemi. Il peut soigner un "Character' entre 5 et 10 points.
De plus, nous devons instancier un rôle plutôt qu'un "Character".

On va tester si le prêtre peut se soigner lui ou ses alliés, on teste le fait qu'il ne puisse pas faire perdre de points de vie ni se donner des dégats.

## Test 4 : Test des "Factions"
Un "Character" peut donc rejoindre une faction.

On va tester ici si un "Character" appartient à une faction ou non, si on peut join une faction ou la leave, ajouter un membre ou en supprimer un. On teste si un "Character" peut attaquer ou soigner un membre de sa faction ou non.

## Test 5 : Test de la classe "Entites"
N'importe qui à de la vie est une "Entities".
Donc un "Character" devient une "Entities".
Une "Entities" de base ne peut pas attaquer ni soigner ou se soigner.
Une "Entities" ne peut pas appartenir à une "Faction".

A l'aide d'une classe "MockEntity" on teste si une entité peut attaquer ou se faire attaquer et soigner ou se faire soigner.

## Test 6 : Suite des tests sur "Factions"
On teste ici qu'une faction puisse ajouter ou supprimer en ami une autre faction
Si une faction est amie avec une autre, alors il est impossible d'attaquer un "Character" d'une autre faction. On teste donc cela. A l'inverse, on ne peut soigner que des "Character" d'une faction alliée, on teste aussi cela.

## Test 7 : Plusieurs factions
On teste ici le fait qu'un "Character" puisse rejoindre ou quitter plusieurs "Factions"

## Test 8 : Test de la classe "Assembly"
Une "Assembly" est une "Faction sauf que seuls certains rôles définis peuvent la rejoindre. Ex : Seulement les "Warriors" pourront rejoindre une assembly avec seulement "Warriors" en "allowedRoles". D'ailleurs, un "Character" pourra rejoindre une seule "Assembly" à la fois, il devra quitter celle où il est en premier avant de rejoindre une autre "Assembly".

On teste donc si un "Character" est dans une "Assembly" ou non, on teste si il y a des membres dans une "Assembly" ou non, on teste si on peut rejoindre une "Assembly" avec differents rôles. On teste au finale toutes les fonctionnalités que l'on a implantées dans Faction

## Test 9 : Le Maître de l'Assemblée
On teste ici le maître de l'assemblée. Le premier a join l'"Assembly" en devient le maître. Si il part, on sélectionne aléatoirement un maître parmi les membres.
On teste alors le premier maître quand l'assemblée est créee. Il peut être le seul à modifier le nom de l'assemblée alors on teste cela enfin on teste le prochain maître si le maître actuel quitte l'assemblée. Il faut vérifier qu'il y ai bien des membres pour pouvoir choisir un maître.

# Sujet du projet

[Sujet](https://gist.github.com/CaptpBdcht/9192a868457a1003edda6687893a92b6)

L'objectif de cet exercice est de commencer à créer le coeur applicatif (business) d'un RPG.  
Commencez par former un groupe de 2.
Créez ensuite la branche pour votre projet:

````
git checkout -b examen-nom1-nom2
git push --set-upstream origin examen-nom1-nom2
````

L'ensemble de l'examen devra être réalisé en pair programming.  
Si vous developpez seul à un moment, vous **DEVEZ** créer une [PR (pull request)](https://docs.github.com/en/free-pro-team@latest/github/collaborating-with-issues-and-pull-requests/about-pull-requests) qui **DOIT** être validée par votre binôme avant d'être mergée.  
En effet, aucun morceau de code ne devrait être connu que d'un seul développeur.  

Le code doit:
  - être correctement **testé**, i.e. vous devez être en mesure d'expliquer comment fonctionnent les tests présents, pourquoi ils sont pertinents, mais aussi d'expliquer pourquoi vous n'avez pas estimé pertinent de tester ce que vous n'avez pas testé
  - être correctement indenté, mettez-vous d'accord en amont sur des normes de code et tenez-vous-y
  - être correctement structuré, ne mettez pas tout dans un seul fichier et séparez bien les classes par responsabilité
  - être lisible, choisissez la langue dans laquelle vous développez et tenez-vous-y ; aussi discutez régulièrement le nom des variables que vous donnez avec votre binôme: soyez au plus proche du **métier** 
  - posséder un README.md expliquant **précisément** comment lancer vos tests : partez du principe qu'un développeur lambda doit pouvoir checkout sur votre branche et suivre votre tutoriel pour lancer les tests - ce qui signifie que vous devez préciser s'il y a des choses à installer pour que ça tourne. Néanmoins n'oubliez pas que clean code rime avec "make dependencies minimal"