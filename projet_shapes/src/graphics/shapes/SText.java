/*
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.TreeMap;

import graphics.shapes.attributes.Attributes;

public class SText extends Shape {

	private String text;
	private Point loc;
	
	public SText() {
		this.text = "hello";
		this.loc = new Point(2,3);
	}
	
	public String getText() {
		return this.text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Point getLoc() {
		return this.loc;
	}
	
	public void setLoc(Point p) {
		this.loc = new Point((int) p.getX(), (int) p.getY());
	}
	
	public void translate(int dx, int dy) {
		this.loc = new Point((int) this.loc.getX()+dx, (int) this.loc.getY()+dy);
	}
	
	
	
	public Rectangle getBounds(String text) {
		return getAttributes(text).getId().getBounds(text);
	}
	
	
	public void accept(ShapeVisitor sv) {
		
	}
}
*/
