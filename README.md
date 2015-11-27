# ServeurClient
Client Serveur Java utilisation de socket java protocole TCP

--------------------ServiceTCPColombetTijani.txt Rendu de Colombet Aurélien et Tijani Yassine SI4G3---------------------

----------Comment se connecter au serveur----------

	Pour se connecter au serveur il faut rentrer dans le client l'adresse IP du serveur (récupéré par ifconfig) lors du lancement du client. Ensuite il faut rentrer le port utilisé par le serveur (notre serveur utilise le port 2000). Après cela vous serez connecté au serveur.

----------type de bufferisation----------

	Nous avons utilisé pour la Bufferisation nous avons utilisé les Class java suivantes :
		-PrintStream pour envoyer des messages.
		-BufferedReader pour lire les message qui sont envoyé.

----------Encodage des chaines----------

	L'encodage des chaines de caractère utilise l'UTF-8.

----------Format des chaines envoyées----------
	
	Nous avons utilisé un caractère spéciale pour simuler les '\n'. Si nous voulons envoyé un retour à la ligne il faut mettre le caractère '|' dans la chaîne de caractère envoyé. Tout les \n serons remplacé par un retour à la ligne se qui permet de formater les reponses du serveur pour le client.


----------Liste des services----------

1. Ajout d'un nom avec ou sans surnom (si le nom existe déjà, on rajoute le surnom au nom dans la base)

2. Visionner la liste des noms avec leurs surnoms associés

3. Rechercher un nom et ses surnoms associés

4. Rechercher un surnom et afficher le nom associés et tous les surnoms associés au nom

5. Modifier un nom : 
	5.1. Ajout d'un nouveau surnom
	5.2. Suppression d'un surnom existant
	5.3. Modification d'un surnom existant
	5.4. Suppression du nom (avec suppression de tous ses surnoms)
	5.5. Modification du nom 

Le système respectera les contraintes suivantes : 
-pas de doublon de nom
-pas de doublon de surnoms dans l'intégralité de la base


----------Serialisation et protocole d'application----------

Type de serialisation choisi : Chaine.

Lorsque l'utilisateur tape une requete au clavier, le client envoie une string au
format suivant :

     commande parm1 param2 parm3 etc...

Exemple : si le client tape "removeName Forquet", le serveur reçoit la chaine :

removeName Forquet


 ----------Liste des commandes----------

-add name surnom1 surnom2 etc.
-> ajout d'un nom avec une liste de surnoms eventuellement vide (si le nom existe déjà on rajoute les surnoms au nom existant)
-list
-> liste tous les noms avec leurs surnoms associés

-searchName name
-> recherche un nom et affiche tous ses surnoms associés

-searchNick nick
-> cherche un surnom et affiche le nom associé ainsi que tous ses surnoms

-modifyName name newName
-> modifie un nom existant

-addNick name nick
-> ajoute un surnom à un nom existant

-modifyNick nick newNick
-> modifie un surnom existant

-removeNick nick
-> supprime un surnom

-removeName name
-> supprime un nom

----------Choix des deux requetes à implementer----------

-> ajout d'un nom avec une liste de surnoms eventuellement vide (si le nom existe déjà on rajoute les surnoms au nom existant)
-> liste tous les noms avec leurs surnoms associés


