package graphics.shapes.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	// Implémente donc les Listeners via Controller	
	private Shape target;
	private Point mouseStart;
	private ControlPanel2 controlPanel;
	
	public ShapesController(Object newModel) {
		super(newModel);
		//controlPanel = new ControlPanel2(this);
		this.target = null;
	}
	
	// Méthodes	
	private Shape getTarget() {
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection)model).iterator();
		boolean targeted = false;		
		while(!targeted && itr.hasNext()) {
			shape = itr.next();
			Rectangle bounds = shape.getBounds();
			targeted = bounds.contains(this.mouseStart); // Utilisation de la classe Rectangle java		
		}
		if (targeted) return shape;
		else return null;		
	}
	
	private void unselectAll() {
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection)model).iterator();
		while(itr.hasNext()) {
			shape = itr.next();			
			if (shape != null && shape!=target) {
				//System.out.println("unselect all");
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null)	sA.unselect();
			}
		}
	}
	
	private void translateSelected(int posx, int posy) {
		Shape shape = null;		
		Iterator<Shape> itr = ((SCollection)model).iterator();
		while(itr.hasNext()) {
			shape = itr.next();	
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					int dx = (int)(posx - mouseStart.getX());
					int dy = (int)(posy - mouseStart.getY());
					shape.translate(dx, dy);
				}				
			}
		}
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// Evenements Listeners
	public void mousePressed(MouseEvent e)
	{
		mouseStart = new Point(e.getX(),e.getY());
		this.target = getTarget();
		// selection de la forme?
	}

	public void mouseClicked(MouseEvent e)
	{
		if (this.target != null) {
			if (e.isShiftDown()) {
			}
			else {
				this.unselectAll();
			}
			///////////////////////////////////////
			SelectionAttributes sA = (SelectionAttributes) target.getAttributes("selectionAttributes");
			if (sA != null) {
				sA.select();
			}			
		}
		else {
			this.unselectAll();
		}
		this.getView().repaint();		
	}
	
	public void mouseDragged(MouseEvent evt)
	{
		Shape shape = null;	
		boolean containsSelected = false;
		Iterator<Shape> itr = ((SCollection)model).iterator();
		while(itr.hasNext()) {
			shape = itr.next();	
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected() && shape == this.target) {
					containsSelected = true;
				}
			}
		}
		
		
		//if (((SCollection) model).getCollection().contains(this.target)) {
		if (containsSelected) {
			this.translateSelected(evt.getX(), evt.getY());
			mouseStart.setLocation(evt.getX(),evt.getY());
			this.getView().repaint();		
		}
	}
	
	public void mouseReleased(MouseEvent e) {
		if (e.isPopupTrigger()) {
			mouseStart = new Point(e.getX(),e.getY());
			this.target = getTarget();
			
			JPopupMenu jpm = new JPopupMenu();
			if (this.target != null) {
				System.out.println("forme");
				JMenu menuShape = new JMenu("Shape");
				JMenuItem delShape = new JMenuItem("Delete");
				delShape.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Suppression de : " + target.getClass());
						
					}
					
				});
				menuShape.add(delShape);
				jpm.add(menuShape);
			}
			else System.out.println("vide");
			
			
			jpm.show(getView(), e.getX(), e.getY());			
		}
		
	}
}
