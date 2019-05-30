# projet_shapes
Projet Java Shapes


Extensions :
- Possibilité de faire nouvelles formes (Triangle, Polygône, Image, ...)
- Animation de formes (formes qui bougent sur l'écran et rebondissent sur les parois)
- Ajouter / Copier / Couper / Coller / Supprimer une forme
- Modifier une forme (Position, Dimensions, Couleur, Police, ...)
- Menu Toolbar (Ajout de forme, Modification, Lancement d'animation, ...)
- Menu contextuel (clic droit)
- Raccourcis clavier
- Afficher / Masquer grille de coordonnées
- Créer un système de sauvegarde du modèle (nouveau, ouvrir, sauvegarder, exporter en jpg, ...)
- Exporter le projet en un exécutable
- Gestion des MouseEvents par états différents (enum)

Questions :
- Selectionner une SCollection -> Qu'est ce que le getBounds d'une SCollection? --> Selectionne aussi l'intérieur
- Est-ce que l'utilisation de "static" est obligatoire dans le cas du ControlPanel?
- Comment différencier un clic dans l'état normal et un clic quand on veut valider un emplacement de forme? --> Variables enum

- ControlPanel hérite de ShapesController?

Notes :
- Timer Swing pour l'anim (pas de Threads)
- 

