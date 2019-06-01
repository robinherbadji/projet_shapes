package graphics.shapes;

import java.awt.Point;

public abstract class Shape {
	
	private HashMap<String, Attributes> attributes;
	// Attributs
	protected Point loc;
	
	public Attributes getAttributes(String s){
		return this.attributes.get(s);
	}
	
	public void addAttributes(Attributes a) {
        this.attributes.put(a.getId(), a);
    	}

 
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Constructeur
	public Shape() {
		this.attributes = new HashMap<String, Attributes>();
	}
	
	public SelectionAttributes getSelect() {
		return (SelectionAttributes)this.getAttributes("Selection");
	}
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Méthodes (celles dont nous avons besoin pour l'instant sont toutes abstraites)
	public abstract Point getLoc(); // Retourne la position de la forme (la variable loc)
	
	public abstract void setLoc(Point point); // Modifie la position de la forme (la variable loc)
	public abstract Rectangle getBounds();
	public abstract void accept(ShapeVisitor sVisitor); // Permet d'accepter la visite du ShapeDraftman (dessinateur) chez une forme
	public abstract boolean isText();
    	public abstract void resize();
}
