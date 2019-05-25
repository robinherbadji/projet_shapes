package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {
	
	private Rectangle rect;	
	private Point point;
	private float rotation;
	
	public SRectangle(Point point, int rWidth, int rHeight) {
		this.point = point;
		this.rect = new Rectangle((int)point.getX(), (int)point.getY(), rWidth, rHeight); // Utilisation de la classe java Rectangle
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	@Override
	public Point getLoc() {
		//return point;
		return this.rect.getLocation(); // Si on utilise les méthodes de la classe java Point
	}
	
	@Override
	public void setLoc(Point point) {
		this.point = point;
		this.rect = new Rectangle((int)point.getX(), (int)point.getY(), this.rect.width, this.rect.height);		
	}
	
	@Override
	public void translate(int dx, int dy) {
		Point point = this.point;
		point.x += dx;
		point.y += dy;
		this.setLoc(point);
	}
	
	@Override
	public Rectangle getBounds() {
		return rect;
	}
	
	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitRectangle(this);
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/*
	@Override
	public void rotate(int degree) {
		// TODO Auto-generated method stub
		
	}*/

	
}