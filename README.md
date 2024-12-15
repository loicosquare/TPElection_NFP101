# Projet NFP101 :  Élections Législatives

Ce projet modélise des élections législatives à système majoritaire uninominal à un tour en utilisant Java. Le projet est structuré en plusieurs classes et interfaces, chacune représentant un aspect des élections.

## Structure du Projet

Le projet est composé des fichiers suivants :

- `Candidat.java` : Classe représentant un candidat aux élections.
- `Circonscription.java` : Classe représentant une circonscription électorale.
- `Main.java` : Classe principale pour tester les fonctionnalités des classes `Candidat` et `Circonscription`.
- `Participant.java` : Interface représentant un participant à une élection.

## Prérequis

Pour compiler et exécuter ce projet, tu as besoin de :

- Java Development Kit (JDK) installé sur ton ordinateur.
- Un IDE (comme IntelliJ IDEA, Eclipse) ou un éditeur de texte (comme Visual Studio Code).

## Compilation et Exécution

### Utilisation de la ligne de commande

1. **Ouvrir un terminal** :
    - Ouvre un terminal ou une invite de commande.

2. **Naviguer jusqu'au répertoire du projet** :
    - Utilise la commande `cd` pour naviguer jusqu'au répertoire où se trouvent les fichiers `.java`.

3. **Compiler les fichiers Java** :
   ```sh
   javac Candidat.java Circonscription.java Main.java Participant.java

## Utilisation d'un IDE
### Ouvrir votre IDE :

- Ouvrez ton IDE préféré (IntelliJ IDEA, Eclipse, etc.).
- Importer le projet :
- Crée un nouveau projet Java et importe les fichiers .java dans le répertoire src du projet.

### Compiler et exécuter :

Utilisez les fonctionnalités de votre IDE pour compiler et exécuter la classe Main.

## Description des Classes
### `Candidat.java`
La classe Candidat représente un candidat aux élections. Chaque candidat a un nom, un prénom, une affiliation politique facultative, et un nombre de voix obtenues.

### `Circonscription.java`
La classe Circonscription représente une circonscription électorale. Chaque circonscription a un nom, un nombre d'inscrits sur les listes électorales, une liste de candidats, et un statut indiquant si l'élection est terminée.

### `Participant.java`
L'interface Participant représente un participant à une élection. Elle définit les méthodes que toute classe implémentant cette interface doit fournir. Voici les méthodes définies par cette interface :

- getNomComplet() : Retourne le nom complet du participant.
- getVoix() : Retourne le nombre de voix obtenues par le participant. Cette méthode peut retourner null si le nombre de voix n'est pas encore connu.
- ajouterVoix(int voix) : Ajoute un certain nombre de voix au participant.

### `Main.java`
La classe Main est la classe principale qui contient la méthode main pour tester les fonctionnalités des classes Candidat et Circonscription. Elle crée des instances de candidats et de circonscription, ajoute des voix aux candidats, clôture l'élection, calcule le taux de participation, et détermine le vainqueur de l'élection.

# Copyright

© [FONKOUO SANOU TEMENA LOIC] [Dec 2024]. Tous droits réservés.

--------------------------------------------------------------------------------------------------------------------
Ce projet a été créé dans le cadre du TP pour le cours NFP101 - Programmation Orientée Objet.

--------------------------------------------------------------------------------------------------------------------
Vous pouvez cloner ce projet en utilisant la commande suivante :

```sh
git clone https://github.com/loicosquare/TPElection_NFP101.git
