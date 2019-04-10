package graphics.shapes.ui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import graphics.shapes.Shape;
import graphics.shapes.attributes.Attributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends  Controller {

public ShapesController(Object newModel) {
		super(newModel);
}

public void translateSelected(int dx, int dy) {
		((Shape) this.getModel()).translate(dx,dy);
}
	
	
public Shape getTarget(MouseEvent e){
		
		/*
		if ((e.getX() < ((Shape) this.getModel()).getLoc().getX()) && (e.getX() < ((Shape) this.getModel()).getBounds().getLength())     
				&&
		  ((e.getY() < ((Shape) this.getModel()).getLoc().getY()) && (e.getY() < ((Shape) this.getModel()).getBounds().getWidth()))) {
			
			((Shape) this.getModel()).getAttributes("SelectionAttributes").select();
			
			return ((Shape) this.getModel());
		}
		*/
		
	if ( ((Shape) this.getModel()).getBounds().contains(e.getPoint()) )
		{
			Shape s = (Shape) this.getModel();
			SelectionAttributes att = (SelectionAttributes) s.getAttributes("SelectionAttributes");
			att.select();
			System.out.println("selected");
		}
		
		return ((Shape) this.getModel());
		
}
	
	
public void unselectAll(MouseEvent e) {
	
	if ( ! ((Shape) this.getModel()).getBounds().contains(e.getPoint()) )
		{
			Shape s = (Shape) this.getModel();
			SelectionAttributes att = (SelectionAttributes) s.getAttributes("SelectionAttributes");
			att.unselect();
			System.out.println("unselected");
		}
		
}
	
	
public void mousePressed(MouseEvent e){
		this.getTarget(e);
	}

public void mouseReleased(MouseEvent e)
	{
	}

public void mouseClicked(MouseEvent e)
	{
	}
	
public void mouseEntered(MouseEvent e)
	{
	}

public void mouseExited(MouseEvent e)
	{
	}
	
public void mouseMoved(MouseEvent evt)
	{
	}
	
public void mouseDragged(MouseEvent evt)
	{
	}
	
public void keyTyped(KeyEvent evt)
	{
	}
	
public void keyPressed(KeyEvent evt)
	{
	}

public void keyReleased(KeyEvent evt)
	{
	}
}

