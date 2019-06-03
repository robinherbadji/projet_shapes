package graphics.shapes.ui;

import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;

import java.awt.event.KeyEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;

import graphics.shapes.SCircle;

import javax.swing.Timer;

import graphics.shapes.SCollection;
import graphics.shapes.SPicture;
import graphics.shapes.SPolygone;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import graphics.ui.Controller;

public class ShapesController extends Controller {
	private Shape target; // The targeted shape
	private Point mouseStart; // The last Mouse position memorised
	private Timer timer; // The Timer used for the animation
	private int vx, vy; // The vertical and horizontal speed used for the animation
	private double scale;
	private double scalePolygon;
	private ArrayList<Shape> shapeCopied; // A List of the Copied shapes

	public ShapesController(Object newModel) {
		super(newModel);
		this.target = null;
		this.vx = 1; // Standard Animation speed (x)
		this.vy = 1; // Standard Animation speed (y)
		this.scale = 1;
		this.scalePolygon = 1;
	}

	// Accesseurs
	
	public Timer getTimer() {
		return this.timer;
	}

	// Methodes
	
	/**
	 * 
	 * @return The focusing shape
	 */
	protected Shape getTarget() {
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		boolean targeted = false;
		while (!targeted && itr.hasNext()) {
			shape = itr.next();
			Rectangle bounds = shape.getBounds();
			targeted = bounds.contains(this.mouseStart); // Utilisation de la classe Rectangle java
		}
		if (targeted)
			return shape;
		else
			return null;
	}
	
	/**
	 * Unselect all the shapes
	 */
	private void unselectAll() {
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null && shape != target) {
				// System.out.println("unselect all");
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null)
					sA.unselect();
			}
		}
	}
	
	/**
	 * 
	 * @param posx : New position of the MouseX
	 * @param posy : New position of the MouseY
	 */
	public void translateSelected(int posx, int posy) {
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					int dx = (int) (posx - mouseStart.getX());
					int dy = (int) (posy - mouseStart.getY());
					shape.translate(dx, dy);
				}
			}
		}
	}
	
	private void rotateSelected(float paceangle) {

		Shape shape = null;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					shape.setRotation(shape.getRotation() + paceangle);
					System.out.println(shape.getRotation());
				}
			}
		}
	}

	private void reduceShape(Shape shape) {

		if (shape instanceof SRectangle) {
			Rectangle bounds = shape.getBounds();
			Rectangle target = ((SRectangle) shape).getRect();
			if (target.getSize().width > 5 && target.getSize().height > 5) {
				target.setSize(bounds.width - 5, bounds.height - 5);
			}
		} else if (shape instanceof SCircle) {
			int radius = ((SCircle) shape).getRadius();
			if (radius > 0) {
				((SCircle) shape).setRadius(radius - 10);
			}

		} else if (shape instanceof SPolygone) {
			this.scalePolygon *= 0.9;
			((SPolygone) shape).setScale(this.scalePolygon);
			// ((SPolygone) shape).setBoundsPoly(((SPolygone)
			// shape).getBounds(),this.scalePolygon);
		} else if (shape instanceof SText) {
			if (((SText) shape).getBounds().height > 5 && ((SText) shape).getBounds().width > 5) {
				FontAttributes actualFont = (FontAttributes) shape.getAttributes("fontAttributes");
				float reduceSize = actualFont.font().getSize() - 10;
				Font newFont = actualFont.font().deriveFont(reduceSize);
				actualFont.setFont(newFont);
				((SText) shape).addAttributes(actualFont);
				((SText) shape).setSizeText(((SText) shape).getSizeText() - 10);
			}
		} else if (shape instanceof SPicture) {

			if (((SPicture) shape).getImageW() > 20) {
				this.scale *= 0.9;
				((SPicture) shape).setScale(this.scale);
			}
		} else if (shape instanceof SCollection) {
			this.reduceShapeCollection((SCollection) shape);
		}
	}

	private void growShape(Shape shape) {

		if (shape instanceof SRectangle) {
			Rectangle bounds = shape.getBounds();
			Rectangle target = ((SRectangle) shape).getRect();
			target.setSize(bounds.width + 5, bounds.height + 5);
		} else if (shape instanceof SCircle) {
			int radius = ((SCircle) shape).getRadius();
			((SCircle) shape).setRadius(radius + 10);
		} else if (shape instanceof SPolygone) {
			this.scalePolygon *= 1.1;
			((SPolygone) shape).setScale(this.scalePolygon);
			// ((SPolygone) shape).setBoundsPoly(((SPolygone)
			// shape).getBounds(),this.scalePolygon);
		} else if (shape instanceof SText) {

			FontAttributes actualFont = (FontAttributes) shape.getAttributes("fontAttributes");
			float growSize = actualFont.font().getSize() + 10;
			Font newFont = actualFont.font().deriveFont(growSize);
			actualFont.setFont(newFont);
			((SText) shape).addAttributes(actualFont);
			((SText) shape).setSizeText(((SText) shape).getSizeText() + 10);
		} else if (shape instanceof SPicture) {
			this.scale *= 1.1;
			((SPicture) shape).setScale(this.scale);

		} else if (shape instanceof SCollection) {
			this.growShapeCollection((SCollection) shape);
		}
	}

	private void growShapeCollection(SCollection scollection) {

		Shape shp = null;
		Iterator<Shape> itr = scollection.iterator();
		while (itr.hasNext()) {
			shp = itr.next();
			if (shp != null) {
				SelectionAttributes sA = (SelectionAttributes) shp.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					growShape(shp);
				}
			}
		}
	}

	private void reduceShapeCollection(SCollection scollection) {

		Shape shp = null;
		Iterator<Shape> itr = scollection.iterator();
		while (itr.hasNext()) {
			shp = itr.next();
			if (shp != null) {
				SelectionAttributes sA = (SelectionAttributes) shp.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					reduceShape(shp);
				}
			}
		}
	}
	
	/**
	 * Animate the selected shapes (Moving + Bounce on a border)
	 * 
	 * @param shapesView : The main JPanel used for display
	 * @param speed : The speed of the moving Shapes
	 */
	public void animatedSelected(ShapesView shapesView, int speed) {
		this.timer = new Timer(speed, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Shape shape = null;
				Iterator<Shape> itr = ((SCollection) model).iterator();
				while (itr.hasNext()) {
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
	
	/**
	 * 
	 * @return An SCollection of the selected shapes
	 */
	public SCollection getSelected() {
		SCollection selectedShapes = new SCollection();
		Shape shape = null;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					selectedShapes.add(shape);
				}
			}
		}
		return selectedShapes;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Evenements Listeners
	
	public void mousePressed(MouseEvent e) {
		mouseStart = new Point(e.getX(), e.getY()); // Save the mouse position
		this.target = getTarget(); // Keep the last focused shape
	}

	public void mouseClicked(MouseEvent e) {
		// If Left Click
		if (e.getButton() == 1) {
			if (this.target != null) {
				if (!e.isShiftDown()) {
					this.unselectAll();
				}
				///////////////////////////////////////
				SelectionAttributes sA = (SelectionAttributes) target.getAttributes("selectionAttributes");
				if (sA != null) {
					sA.select();
				}
			} else {
				this.unselectAll();
			}
			this.getView().repaint();
		}
		// If Right Click
		if (e.getButton() == 3) {
			RightClick rightClick = new RightClick(this); // Initialize a RightClight class Object
			rightClick.click(e); // Call its method
		}
	}

	public void mouseDragged(MouseEvent evt) {
		Shape shape = null;
		boolean containsSelected = false;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected() && shape == this.target) {
					containsSelected = true;
				}
			}
		}
		// If the click is on the correct selected shape(s)
		if (containsSelected) {
			this.translateSelected(evt.getX(), evt.getY());
			mouseStart.setLocation(evt.getX(), evt.getY());
			this.getView().repaint(); // Refresh the view
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		super.mouseWheelMoved(e);
		/*
		 * 
		 * if(e.getWheelRotation() > 0 && ! (this.target instanceof SCollection)){
		 * System.out.println("zoom -"); reduceShape(this.target);
		 * 
		 * }else if(e.getWheelRotation() > 0 && (this.target instanceof SCollection)) {
		 * System.out.println("zoom - for Collection");
		 * reduceShapeCollection((SCollection) this.target); }
		 * 
		 * else if(e.getWheelRotation() < 0 && ! (this.target instanceof SCollection)) {
		 * System.out.println("zoom +"); growShape(this.target); }
		 * 
		 * else if (e.getWheelRotation() < 0 && (this.target instanceof SCollection)) {
		 * System.out.println("zoom + for Collection");
		 * growShapeCollection((SCollection) this.target); }
		 */
		if (e.getWheelRotation() > 0) {
			reduceShape(this.target);
			System.out.println("zoom -");

		} else if (e.getWheelRotation() < 0) {
			growShape(this.target);
			System.out.println("zoom +");
		}
		this.getView().repaint();
	}

	public void keyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
			this.delete();
		}
		if (evt.getKeyCode() == KeyEvent.VK_C && evt.isControlDown()) {
			try {
				this.copy();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
		}
		if (evt.getKeyCode() == KeyEvent.VK_X && evt.isControlDown()) {
			this.cut();
		}
		if (evt.getKeyCode() == KeyEvent.VK_V && evt.isControlDown()) {
			this.paste(new Point(200, 200));

		}
		if (evt.getKeyCode() == KeyEvent.VK_A && evt.isControlDown()) {
			System.out.println("selectall");
			this.selectAll();
		}

		Shape shape = null;
		boolean containsSelected = false;
		Iterator<Shape> itr = ((SCollection) model).iterator();
		while (itr.hasNext()) {
			shape = itr.next();
			if (shape != null) {
				SelectionAttributes sA = (SelectionAttributes) shape.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected() && shape == this.target) {
					containsSelected = true;
					if (evt.getKeyCode() == KeyEvent.VK_P) {
						System.out.println("zoom +");
						growShape(shape);
					}
					if (evt.getKeyCode() == KeyEvent.VK_M) {
						System.out.println("zoom -");
						reduceShape(shape);
					}
					if (containsSelected) {
						if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
							System.out.println("left rotation");
							rotateSelected(-10);
						}
						if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
							System.out.println("right rotation");
							rotateSelected(10);
						}
					}
					this.getView().repaint();
				}
			}
		}
	}

	public void blank() {
		SCollection model = new SCollection();
		Editor self = new Editor(model);
		self.pack();
		self.setVisible(true);
	}

	public void save() {
		FilesManager xml = new FilesManager();
		xml.enregistrer((SCollection) this.getModel());
	}

	public void open() {
		FilesManager xml = new FilesManager();
		xml.lecture();
	}

	public void export() {
		Export e = new Export();
		e.takePicture((ShapesView) this.getView());
	}

	public void delete() {
		SCollection selectedShapes = this.getSelected(); // Création de la Collection des formes selectionnées
		Iterator<Shape> itr = selectedShapes.iterator(); // Crréation d'un itérateur
		Shape shape = null;
		while (itr.hasNext()) { // On parcourt la collection
			shape = itr.next(); // On itère
			if (shape != null) {
				((SCollection) model).delete(shape);
				System.out.println("Deleted");
			}
		}
		this.getView().repaint(); // Réactualise
	}

	public void copy() throws CloneNotSupportedException {
		Iterator<Shape> itr = this.getSelected().iterator();
		Shape shape;
		Shape clone;
		this.shapeCopied = new ArrayList<Shape>();
		while (itr.hasNext()) {
			shape = itr.next();
			clone = shape.clone();
			this.shapeCopied.add(clone);
		}
	}

	public void cut() {
		try {
			this.copy();
			this.delete();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public void paste(Point mousePos) {
		// this.shapeCopied.get(0).setLoc(mousePos);
		Iterator<Shape> itr = this.shapeCopied.iterator();
		Shape shape;
		while (itr.hasNext()) {
			shape = itr.next();
			((SCollection) model).add(shape);
		}
		this.getView().repaint();
	}

	public void selectAll() {
		Shape s;
		SCollection sc = (SCollection) this.getModel();
		for (Iterator<Shape> i = sc.iterator(); i.hasNext();) {
			s = (Shape) i.next();
			SelectionAttributes sa = (SelectionAttributes) s.getAttributes("selectionAttributes");
			sa.select();
		}
	}

}
