
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;
import graphics.shapes.ui.ShapeVisitor;

public abstract class Shape {
	
	private TreeMap<String,Attributes> map = new TreeMap<String, Attributes>();

	public Shape() {
		this.map.clear();
	}
	
	
	public void addAttributes(Attributes a) {
		this.map.put(a.getId(), a);
		System.out.println("attribute put");
	}
	
	public Attributes getAttributes(String attributeName) {
		return this.map.get(attributeName);
	}
	
	public abstract Point getLoc();
	
	public abstract void setLoc(Point p);

	public abstract void translate(int dx, int dy);
	
	public abstract Rectangle getBounds();
	
	
	public abstract void accept(ShapeVisitor sv);

}
