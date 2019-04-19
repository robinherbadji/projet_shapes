package graphics.shapes;

import java.awt.Point;

public abstract class Shape {
	// Attributs
	protected Point loc;
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Constructeur
	public Shape() {
		// Vide pour l'instant, on verra apr�s
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// M�thodes (celles dont nous avons besoin pour l'instant sont toutes abstraites)
	public abstract Point getLoc(); // Retourne la position de la forme (la variable loc)
	
	public abstract void setLoc(Point point); // Modifie la position de la forme (la variable loc)
	
	public abstract void accept(ShapeVisitor sVisitor); // Permet d'accepter la visite du ShapeDraftman (dessinateur) chez une forme
	
}