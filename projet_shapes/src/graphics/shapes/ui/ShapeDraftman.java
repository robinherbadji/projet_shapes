
package graphics.shapes.ui;

import java.awt.Graphics;
import java.util.Iterator;

import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.Shape;


public class ShapeDraftman implements ShapeVisitor {

	//private ColorAttributes DEFAUTCOLORATTRIBUTES;
	private Graphics g;
	
	public ShapeDraftman(Graphics g) {
		this.g = g;
	}
	
	
	public void visitRectangle(SRectangle R) {
		
		this.g.fillRect(R.getLoc().x,R.getLoc().y, R.getRect().height, R.getRect().width);
		
	}
	
	/*
	public void visitCircle(SCircle C) {
		
	}
	
	public void visitText(SText T) {
		
	}
	*/
	public void visitCollection(SCollection sc) {
		for(Iterator it = sc.iterator(); it.hasNext();) {
			((Shape) it.next()).accept(this);
		}
	}
	
	
}
