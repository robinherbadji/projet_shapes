package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {
	// Attributs
	private Rectangle rect;
	public SRectangle()
	{
		this(new Point(50,50),100,100);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Constructeur	
	public SRectangle(Point point, int rWidth, int rHeight) {
		this.rect = new Rectangle((int)point.getX(), (int)point.getY(), rWidth, rHeight); // Utilisation de la classe java Rectangle
		this.setLoc(this.rect.getLocation());
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	// Méthodes	
	public Rectangle getRect() {
		return rect;
	}
	
	@Override
	public Point getLoc() {
		return this.rect.getLocation(); // On utilise la classe Rectangle Java		
	}
	
	@Override
	public void setLoc(Point point) {
		this.rect.setLocation(point); // On utilise la classe Rectangle Java	
	}
	
	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitRectangle(this); // Qu'est-ce que le shapevisitor va venir visiter? -> Le rectangle this
	}
	
	public Rectangle getBounds() {
		return this.rect.getBounds();
	}
	
}
