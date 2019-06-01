package graphics.shapes.interpret;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;

import graphics.shapes.Shape;
import graphics.shapes.ui.ShapeActionListener;
import graphics.shapes.ui.ShapesController;

public class PasteAction extends ShapeActionListener {

	private List<Shape> shapes;
	private ShapesController mouse ;
	private boolean cut ;
	
	public PasteAction(ShapesController mLoc) {
		this.mouse = mLoc ;
	}
	
	public void setShapes(List<Shape> s) {
		this.shapes = s ;
	}
	
	public void setCut(boolean c) {
		this.cut = c ;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(this.shapes != null) {
			for(Iterator<Shape> i=this.shapes.iterator(); i.hasNext();)
			{
				Shape w = null; 
				if(this.cut) {
					w=(Shape)i.next();
				}
				else {
					w=(Shape)((Shape)i.next());
				}
				w.setLoc(this.mouse.getLastClick());
				this.getModel().add(w);
			}
		}
		if(this.cut) this.shapes = null ;
	}

}
