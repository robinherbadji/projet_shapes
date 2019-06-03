package graphics.shapes;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
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
	
	public Shape(Shape shape) {
		attributes = new TreeMap<String, Attributes>();
		this.addAttributes(new SelectionAttributes());
		this.addAttributes(new ColorAttributes(true, true, Color.YELLOW, Color.BLUE));
		if (shape instanceof SText) {
			this.addAttributes(new FontAttributes((FontAttributes)shape.getAttributes("fontAttributes") ));
		}
		this.setLoc(shape.getLoc());		
		this.setRotation(shape.getRotation());
	}
	/*
	public Shape(Shape shape) {
		attributes = new TreeMap<String, Attributes>();
		this.addAttributes(new SelectionAttributes());
		this.addAttributes(new ColorAttributes((ColorAttributes)shape.getAttributes("colorAttributes")));
		if (shape instanceof SText) {
			this.addAttributes(new FontAttributes((FontAttributes)shape.getAttributes("fontAttributes") ));
		}
		this.setLoc(shape.getLoc());		
		this.setRotation(shape.getRotation());
	}
	*/

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

	public float getRotation() {
		return this.rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	public Shape clone() throws CloneNotSupportedException {
		Shape shape = (Shape) super.clone();
		shape.addAttributes(new SelectionAttributes());
		return shape;
	}
	
	
}