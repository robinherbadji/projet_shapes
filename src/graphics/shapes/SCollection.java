package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape {
	private ArrayList<Shape> collection;
	private float rotation;

	public SCollection() {
		this.collection = new ArrayList<Shape>();
		this.rotation = 0;
	}

	public void add(Shape shape) {
		this.collection.add(shape);
	}

	public void delete(Shape shape) {
		this.collection.remove(shape);
	}

	public Iterator<Shape> iterator() {
		return collection.iterator();
	}

	@Override
	public Point getLoc() {
		if (collection != null)
			return collection.get(0).getLoc(); // Position of the first shape
		else
			return null;
	}

	@Override
	public void setLoc(Point point) {
		collection.get(0).setLoc(point);
		/*
		 * Iterator<Shape> itr = collection.iterator(); while (itr.hasNext()) {
		 * itr.next().setLoc(point); }
		 */
	}

	@Override
	public void translate(int dx, int dy) {
		Iterator<Shape> itr = collection.iterator();
		while (itr.hasNext()) {
			Shape shape = itr.next();
			shape.translate(dx, dy);
		}
	}

	@Override
	public Rectangle getBounds() {
		Iterator<Shape> itr = collection.iterator();
		Rectangle bounds = new Rectangle(-1, -1); // Rectangle seen as non-existing		
		while (itr.hasNext()) {
			Shape shape = itr.next();
			bounds = bounds.union(shape.getBounds());
		}
		return bounds;
	}

	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitCollection(this);
	}

	public float getRotation() {
		return collection.get(0).getRotation();
	}

	public void setRotation(float rotation) {
		/*
		 * Iterator<Shape> itr = collection.iterator(); while (itr.hasNext()) { Shape
		 * shape = itr.next(); shape.setRotation(rotation); }
		 */
	}

	public ArrayList<Shape> getCollection() {
		return this.collection;
	}
}
