
package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;

public interface ShapeVisitor {
	
	public abstract void visitRectangle(SRectangle R);
	
	//public abstract void visitCircle(SCircle C);
	
	//public abstract void visitText(SText T);
	
	public abstract void visitCollection(SCollection SC);
}
