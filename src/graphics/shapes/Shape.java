package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public abstract class Shape implements Cloneable {
	protected Point point;
	private Map<String, Attributes> attributes;
	

	public Shape() {
		attributes = new TreeMap<String, Attributes>();
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point point);

	public abstract void translate(int dx, int dy);
	// public abstract void rotate(int degree);

	public abstract Rectangle getBounds();

	public void addAttributes(Attributes attribute) {
		this.attributes.put(attribute.getId(), attribute);
	}

	public Attributes getAttributes(String id) {
		return this.attributes.get(id);
	}

	public abstract void accept(ShapeVisitor sVisitor);

	public abstract double getRotation();

	public abstract void setRotation(double rotation);

	/**
	 * Clone the current shape
	 */
	public Shape clone() {
		Shape newShape = null;
		if (this instanceof SRectangle) {
			newShape = new SRectangle(((SRectangle) this).getRect().width, ((SRectangle) this).getRect().height);
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(), cA.stroked(), cA.filledColor(), cA.strokedColor()));
		} else if (this instanceof SCircle) {
			newShape = new SCircle(((SCircle) this).getRadius());
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(), cA.stroked(), cA.filledColor(), cA.strokedColor()));
		} else if (this instanceof SText) {
			newShape = new SText(((SText) this).getText());
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(), cA.stroked(), cA.filledColor(), cA.strokedColor()));
			newShape.addAttributes(new FontAttributes());
		} else if (this instanceof SPolygone) {
			newShape = new SPolygone(((SPolygone) this).nPoints, ((SPolygone) this).x, ((SPolygone) this).y);
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(), cA.stroked(), cA.filledColor(), cA.strokedColor()));
		} else if (this instanceof SPicture) {
			newShape = new SPicture(((SPicture) this).getPath());
			newShape.addAttributes(new SelectionAttributes());
		} else if (this instanceof SCollection) {
			newShape = new SCollection();
			newShape.addAttributes(new SelectionAttributes());
			Iterator<Shape> itr = ((SCollection) this).iterator();
			Shape shape_n;
			while (itr.hasNext()) {
				shape_n = itr.next();
				System.out.println(shape_n);
				((SCollection) newShape).add(shape_n.clone());
			}
		}
		return newShape;
	}

}