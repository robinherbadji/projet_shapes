package graphics.shapes.interpret;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import graphics.shapes.Shape;
import graphics.shapes.ui.ShapeActionListener;

public class CutAction extends ShapeActionListener {

	private PasteAction paste ;
	
	public CutAction(PasteAction pa) {
		this.paste = pa ;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		List<Shape> shapes;
		shapes=new Vector<Shape>();
		for(Iterator<Shape> i=this.getModel().iterator(); i.hasNext();)
		{
			Shape s=(Shape)i.next();
			if(s.getSelect().isSelected()) shapes.add((Shape)s);
		}
		for(Iterator<Shape> it=shapes.iterator(); it.hasNext();)
		{
			Shape w=(Shape)it.next();
			this.getModel().remove(w);
		}
		this.paste.setCut(true);
		this.paste.setShapes(shapes);
	}

}
