
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

import graphics.shapes.ui.ShapeVisitor;

public class SRectangle extends Shape {

	private Rectangle rect;
	
	public SRectangle(Point p, int w, int h) {
		
		this.rect = new Rectangle((int) p.getX(),(int) p.getY(),w,h);
	}
	
	public Rectangle getRect() {
		return this.rect;
	}
	
	public void setRectangle(Rectangle rect) {
		this.rect = rect;
	}
	
	public Point getLoc() {
		return rect.getLocation();
		
	}
	
	public void setLoc(Point p) {
		this.rect.setLocation(p);
	}
	
	public void translate(int dx, int dy) {
		this.rect.translate(dx, dy);		
	}
	
	public Rectangle getBounds() {
		return this.rect.getBounds();
	}
	
	public void accept(ShapeVisitor sv) {
		sv.visitRectangle(this);
	}

}
