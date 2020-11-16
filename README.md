# Clean Code MOC

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


# Seance de travail Pair Programming

14/10/20  - Seance 1 :  Prise en main du projet dans un fichier 'playground'
                                     Creation des classes Characters (Warrior, Priest) 
                                     Ajout Protocol Characters
                                     Création classe Faction
                    
18/10/20 - Seance 2 : Migration du projet 'playground' en projet 'command line'
                                    Ajout Protocol Entities
                                    Ajout des premiers TU
                                    Modification des methodes attack et heal selon les nouveaux use cases
                                    
05/11/20 - Seance 3 : Itération 7 
                                    Ajout de la liste de Faction
                                    Modification fonction heal et attack (conditions avec liste de faction)
                                    MaJ des TU
                                    
15/11/20 - Seance 4 : Refacto code + début itération 9 
                                    ajout d'une extension pour la notion d'intéraction entre les characters (heal, attack, join, leave...)
                                    Refacto : - Attack
                                                    - heal 
                                                    - méthodes d'interaction de faction

16/11/20 - Seance 5 : Itération 9 + TU 
                                    

