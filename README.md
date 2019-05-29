# projet_shapes
Projet Java Shapes


Extensions :
- Possibilit� de faire nouvelles formes (Triangle, Polyg�ne, Image, ...)
- Animation de formes (formes qui bougent sur l'�cran et rebondissent sur les parois)
- Ajouter / Copier / Couper / Coller / Supprimer une forme
- Modifier une forme (Position, Dimensions, Couleur, Police, ...)
- Menu Toolbar (Ajout de forme, Modification, Lancement d'animation, ...)
- Menu contextuel (clic droit)
- Raccourcis clavier
- Afficher / Masquer grille de coordonn�es
- Cr�er un syst�me de sauvegarde du mod�le (nouveau, ouvrir, sauvegarder, exporter en jpg, ...)
- Exporter le projet en un ex�cutable
- Gestion des MouseEvents par �tats diff�rents (enum)

Questions :
- Selectionner une SCollection -> Qu'est ce que le getBounds d'une SCollection? --> Selectionne aussi l'int�rieur
- Est-ce que l'utilisation de "static" est obligatoire dans le cas du ControlPanel?
- Comment diff�rencier un clic dans l'�tat normal et un clic quand on veut valider un emplacement de forme? --> Variables enum

- ControlPanel h�rite de ShapesController?

Notes :
- Timer Swing pour l'anim (pas de Threads)
- 

