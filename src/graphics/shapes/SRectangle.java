package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SRectangle extends Shape {

	private Rectangle rect;
	
	/**
	 * Constructor of a random positioned SRectangle
	 */
	public SRectangle() {
		this.point = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
		int rWidth = 20 + (int) (Math.random() * 100);
		int rHeight = 20 + (int) (Math.random() * 100);
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), rWidth, rHeight); // Utilisation de la classe
		// java Rectangle
	}

	public SRectangle(int rWidth, int rHeight) {
		this.point = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), rWidth, rHeight);
	}

	public SRectangle(Point point, int rWidth, int rHeight) {
		this.point = point;
		this.rect = new Rectangle((int) point.getX(), (int) point.getY(), rWidth, rHeight);
	}

	public Rectangle getRect() {
		return rect;
	}

	@Override
	public Point getLoc() {
		return this.rect.getLocation(); // Si on utilise les methodes de la classe java Point
	}

	@Override
	public void setLoc(Point point) {
		this.point = point;
		this.rect.setLocation(point);
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

}