package graphics.shapes.ui;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.Timer;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	// Implémente donc les Listeners via Controller
	private Shape target;
	private Point mouseStart;
	private Timer timer;
	private int vx;
	private int vy;
	
	public ShapesController(Object newModel) {
		super(newModel);	
		this.target = null;
		this.vx = 1;
		this.vy = 1;
	}
	
	// Accesseurs
	
	public Timer getTimer() {
		return this.timer;
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
	
	public void translateSelected(int posx, int posy) {
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
	
	public void animatedSelected(ShapesView shapesView, int speed) {
		this.timer = new Timer(speed, new ActionListener() {			
		    public void actionPerformed(ActionEvent evt) {
		    	Shape shape = null;		    	
				Iterator<Shape> itr = ((SCollection)model).iterator();
				while(itr.hasNext()) {
					shape = itr.next();
					if (shape != null) {
						SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
						if (sA != null && sA.isSelected()) {
							if (shape.getBounds().x <= 0) {
								vx = 1;
							}
							if (shape.getBounds().x + shape.getBounds().width >= shapesView.getWidth()) {
								vx = -1;
							}
							if (shape.getBounds().y <= 0) {
								vy = 1;
							}
							if (shape.getBounds().y + shape.getBounds().height >= shapesView.getHeight()) {
								vy = -1;
							}
							shape.translate(vx, vy);
						}				
					}
				}
				shapesView.repaint();				
		    }    
		});
		this.timer.start();
	}
	
	//public void selectedInside()
	
	
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
				JMenuItem delShape = new JMenuItem("Delete");
				delShape.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Suppression de : " + target.getClass());						
					}
				});
				jpm.add(delShape);
				
				JMenuItem copy = new JMenuItem("Copy");
				copy.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Copie de : " + target.getClass());						
					}					
				});
				jpm.add(copy);
				
				JMenuItem cut = new JMenuItem("Cut");
				cut.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Coupage de : " + target.getClass());						
					}					
				});
				jpm.add(cut);				
			}
			else {
				System.out.println("vide");
				
				/*
				JRadioButtonMenuItem gridOn = new JRadioButtonMenuItem("ON");
				JRadioButtonMenuItem gridOff = new JRadioButtonMenuItem("OFF");
				ButtonGroup bg = new ButtonGroup();
				gridOn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Grille On");
						
					}					
				});
				gridOff.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println("Grille Off");						
					}					
				});
				
				bg.add(gridOn);
				bg.add(gridOff);				
				jpm.add(gridOn);
				gridOff.setSelected(true);
				jpm.add(gridOff);
				*/				
			}			
			
			jpm.show(getView(), e.getX(), e.getY());			
		}
		
	}
}
