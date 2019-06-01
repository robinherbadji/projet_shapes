package graphics.shapes.interpret;

import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import graphics.shapes.Shape;
import graphics.shapes.ui.ShapeActionListener;

public class DeleteAction extends ShapeActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		List<Shape> shapes;
		shapes=new Vector<Shape>();
		for(Iterator<Shape> i=this.getModel().iterator(); i.hasNext();)
		{
			Shape s=(Shape)i.next();
			if(s.getSelect().isSelected()) shapes.add(s);
		}
		for(Iterator<Shape> i=shapes.iterator(); i.hasNext();)
		{
			Shape w=(Shape)i.next();
			this.getModel().remove(w);
		}
		this.getView().requestFocus();
	}

}
