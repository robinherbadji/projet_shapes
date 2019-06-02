package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class SCollection extends Shape {
	private ArrayList<Shape> collection;
	private float rotation;

	public SCollection() {
		collection = new ArrayList<Shape>();
		this.rotation = 0;
	}

	/*
	 * public ArrayList<Shape> getCollection() { return this.collection; }
	 */

	public void add(Shape shape) {
		this.collection.add(shape);
	}

	public Iterator<Shape> iterator() {
		return collection.iterator();
	}

	@Override
	public Point getLoc() {

		// On retourne la position de la 1ere forme
		if (collection != null)
			return collection.get(0).getLoc();
		else
			return null;
	}

	@Override
	public void setLoc(Point point) {

		Iterator<Shape> itr = collection.iterator();
		while (itr.hasNext()) {
			itr.next().setLoc(point);
		}
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
		Rectangle bounds = new Rectangle(-1, -1); // Rectangle trait� comme non-existant (bounds = null ne fonctionnant
													// pas)
		// Deux fa�ons de faire pour d�clarer bounds:
		// 1
		/*
		 * Rectangle bounds = itr.next().getBounds(); while (itr.hasNext()) { Shape
		 * shape = itr.next(); bounds = bounds.union(shape.getBounds()); }
		 */
		// 2
		while (itr.hasNext()) {
			Shape shape = itr.next();
			bounds = bounds.union(shape.getBounds());
		}
		return bounds;

		// 3 -> Bugs
		/*
		 * Rectangle bounds = new Rectangle(); for (Iterator<Shape> itr =
		 * collection.iterator(); itr.hasNext();) { bounds.union(((Shape)
		 * itr.next()).getBounds()); } return bounds;
		 */

	}

	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitCollection(this);
	}

	public float getRotation() {
		return collection.get(0).getRotation();
	}

	public void setRotation(float rotation) {
		Iterator<Shape> itr = collection.iterator();
		while (itr.hasNext()) {
			Shape shape = itr.next();
			shape.setRotation(rotation);
		}
	}

	public ArrayList<Shape> getCollection() {
		return this.collection;
	}
}
