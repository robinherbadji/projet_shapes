package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape {

	private int radius;

	private float rotation;

	public SCircle() {
		this.point = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
		this.radius = 5 + (int) (Math.random() * 75);
		this.setLoc(point);
		this.setRadius(radius);
	}

	public SCircle(Point point, int radius) {
		this.setLoc(point);
		this.setRadius(radius);
	}

	@Override
	public Point getLoc() {
		return this.point;
	}

	@Override
	public void setLoc(Point point) {
		this.point = point;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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
		return new Rectangle(this.point.x, this.point.y, this.radius * 2, this.radius * 2);
	}

	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitCircle(this);
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

}