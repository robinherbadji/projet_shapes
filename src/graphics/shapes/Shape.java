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
	private float rotation;

	public Shape() {
		attributes = new TreeMap<String, Attributes>();
		this.rotation = 0;
	}

	public abstract Point getLoc();

	public abstract void setLoc(Point point);

	public abstract void translate(int dx, int dy);
	// public abstract void rotate(int degree);

	public abstract Rectangle getBounds();

	public void addAttributes(Attributes attribute) {
		this.attributes.put(attribute.getId(), attribute);
	}

	public void flushAttributes() {
		this.attributes.clear();
	}

	public Attributes getAttributes(String id) {
		return this.attributes.get(id);
	}

	public abstract void accept(ShapeVisitor sVisitor);

	public float getRotation() {
		return this.rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public Shape clone()  {
		Shape newShape = null;
		if (this instanceof SRectangle) {
			newShape = new SRectangle(this.getLoc(),((SRectangle) this).getRect().width, ((SRectangle) this).getRect().height);
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(),cA.stroked(),cA.filledColor(),cA.strokedColor()));
		}
		else if (this instanceof SCircle) {
			System.out.println("cercle");
			newShape = new SCircle(new Point(10,100),((SCircle)this).getRadius());
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(),cA.stroked(),cA.filledColor(),cA.strokedColor()));
		}
		else if (this instanceof SText) {
			newShape = new SText(new Point(250,50),((SText)this).getText());
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(),cA.stroked(),cA.filledColor(),cA.strokedColor()));
			newShape.addAttributes(new FontAttributes());
		}
		else if (this instanceof SPolygone) {
			newShape = new SPolygone(((SPolygone)this).nPoints,((SPolygone)this).x, ((SPolygone)this).y);
			newShape.addAttributes(new SelectionAttributes());
			ColorAttributes cA = (ColorAttributes) this.getAttributes("colorAttributes");
			newShape.addAttributes(new ColorAttributes(cA.filled(),cA.stroked(),cA.filledColor(),cA.strokedColor()));
		}
		else if (this instanceof SPicture) {
			newShape = new SPicture(new Point(220,250),((SPicture)this).getPath());
			newShape.addAttributes(new SelectionAttributes());
		}
		else if (this instanceof SCollection) {
			newShape = new SCollection();
			newShape.addAttributes(new SelectionAttributes());
			Iterator<Shape> itr = ((SCollection)this).iterator();
			Shape shape_n;
			while (itr.hasNext()) {
				shape_n = itr.next();
				System.out.println(shape_n);
				((SCollection)newShape).add(shape_n.clone());
			}
		}

		return newShape;
	}


}