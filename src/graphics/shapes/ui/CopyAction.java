package graphics.shapes.interpret;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import graphics.shapes.Shape;
import graphics.shapes.ui.ShapeActionListener;
import graphics.shapes.ui.PasteAction;

public class CopyAction extends ShapeActionListener {

	private PasteAction paste ;
	
	public CopyAction(PasteAction pa) {
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
		this.paste.setCut(false);
		this.paste.setShapes(shapes);
	}
}
