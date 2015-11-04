# ServeurClient
Client Serveur Java utilisation de socket java protocole TCP

--------------------ServiceTCPForquetRobin.txt Rendu de Forquet Vincent et Robin Gregory SI4G3---------------------

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

Type de serialisation choisi : Chaine au format JSON.

Lorsque l'utilisateur tape une requete au clavier, le client envoie une string au
format JSON suivant : 

{
    "commande": "foo",
    "params": {
        "nom": "axz",
        "surnoms": ["xxx","xxy","xxz", etc.],
        "oldname":"valOldName",
        "newname":"valNewName"		
    		}			
}

Exemple : si le client tape "removeName Forquet", le serveur reçoit la chaine :

 {"commande":"removeName","params":{"nom":"Forquet"}}


 ----------Liste des commandes----------

-add name surnom1 surnom2 etc.
-> ajout d'un nom avec une liste de surnoms eventuellement vide (si le nom existe déjà on rajoute les surnoms au nom existant)
JSON : { "commande":"add", "params":{"nom":"name", "surnoms":["surnom1","surnom2", etc.]}}

-list
-> liste tous les noms avec leurs surnoms associés
JSON : { "commande":"list"}

-searchName name
-> recherche un nom et affiche tous ses surnoms associés
JSON : { "commande":"searchName", "params":{"nom":"name"}}

-searchNick nick
-> cherche un surnom et affiche le nom associé ainsi que tous ses surnoms
JSON : { "commande":"searchNick", "params":{"nom":"nick"}}

-modifyName name newName
-> modifie un nom existant
JSON : { "commande":"modifyName", "params":{"oldname":"name","newname":"newName"}}

-addNick name nick
-> ajoute un surnom à un nom existant
JSON : { "commande":"addNick", "params":{"nom":"name", "surnoms":["nick"]}}

-modifyNick nick newNick
-> modifie un surnom existant
JSON : { "commande":"modifyNick", "params":{"oldname":"nick","newname":"newNick"}}

-removeNick nick
-> supprime un surnom
JSON : { "commande":"removeNick", "params":{"nom":"nick"}}

-removeName name
-> supprime un nom 
JSON : { "commande":"removeName", "params":{"nom":"name"}}
