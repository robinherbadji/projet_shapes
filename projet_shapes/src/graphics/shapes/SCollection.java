
package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import graphics.shapes.ui.ShapeVisitor;

public class SCollection extends Shape {

	List<Shape> listofShapes;
	private Point locmoyen; 
	
	public SCollection() {
		this.listofShapes = new ArrayList<Shape>();
		this.locmoyen = null;
	}
	
	public Iterator iterator() {
		
		ListIterator<Shape> it = listofShapes.listIterator();
		return it;
	}
	
	public void add(Shape s) {
		this.listofShapes.add(s);
	}
	
	public Point getLoc() {
		return null;
	}
	
	public void setLoc(Point p) {
		while(iterator().hasNext()) {
			((Shape) iterator().next()).setLoc(p);
		}
	}
	
	public void translate(int dx, int dy) {
		while(iterator().hasNext()) {
			//((Shape) iterator().next()).setLoc(getLoc().x + dx);
			//((Shape) iterator().next()).setLoc(getLoc().y + dy);
		}
		
	}
	
	
	public Rectangle getBounds() {
		Rectangle r = new Rectangle();
		for(Iterator it = this.iterator(); it.hasNext();) {
			r.union(((Shape) it.next()).getBounds());
		}
		return r;
	}
	
	
	public void accept(ShapeVisitor sv) {
		sv.visitCollection(this);
	}
}


