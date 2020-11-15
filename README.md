# Clean Code MOC

[Sujet](https://gist.github.com/CaptpBdcht/9192a868457a1003edda6687893a92b6)

L'objectif de cet exercice est de commencer à créer le coeur applicatif (business) d'un RPG.  
Nous avons choisi pour TP de partir dans le monde de la série [Vikings](https://fr.wikipedia.org/wiki/Vikings_(série_télévisée)).

### Binôme
***
* **Corentin DELAGE**
* **Julien GUILLAN**

### IntelliJ
***
>Attention a l'ouverture, cliquez sur "configure as maven project" et non pas sur eclipse !  
### Installation des dépendances
***
Nous avons développé entièrement ce Projet en JAVA.
il est donc nécessaire de disposer du JDK en version 11 minimum. 
>Téléchargeable ici: [OpenJDK 11](https://openjdk.java.net/install/)

Maven 3.6 est nécessaire pour compiler et lancer les tests (cf. [Documentation](https://maven.apache.org/install.html))

>Téléchargeable ici: [Maven 3.6](http://maven.apache.org/download.cgi)

### Compilation du projet
***
Pour compiler le projet une fois OpenJDK et Maven d'installé, depuis un terminal (ou cmd) entrez:
```
$ mvn install #facultatif, uniquement pour s'assurer de la bonne installation des dépendances
$ mvn compile
```
La sortie console suivante devrait s'afficher:
```
...
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.450 s
[INFO] Finished at: XXXX-XX-XXT01:09:20+01:00
[INFO] ------------------------------------------------------------------------
```
 ### Lancement des tests unitaires
***
Pour effectuer les tests unitaires nous avons choisi JUnit 4.12.
>Pas d'inquiétude, tout est dans le pom.xml

Une fois la compilation terminé, pour lancer les tests, depuis votre CLI rentrez:
```
$ mvn test
```

La sortie console suivante devrait s'afficher:
```
...
[INFO] Results:
[INFO] 
[INFO] Tests run: 24, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.270 s
[INFO] Finished at: 2020-11-15T01:13:21+01:00
[INFO] ------------------------------------------------------------------------
```
Tout simplement.
