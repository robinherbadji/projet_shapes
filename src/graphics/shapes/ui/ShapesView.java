package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.Shape;
import graphics.ui.View;
import graphics.ui.Controller;

public class ShapesView extends View {
	// Hérite du JPanel via View
	private ShapeDraftman draftman;
	
	// Constructeur
	public ShapesView(Object model) {
		super(model);
		this.draftman = new ShapeDraftman();
		this.setFocusable(true); //rend le clavier focus
	}
	
	///////////////////////////////////////////////////////
	
	// Méthodes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		ShapeDraftman draftman = new ShapeDraftman(g);
		((Shape) model).accept(draftman);
	}
	
	public ShapesController defaultController(Object model) {
		return new ShapesController(model);
	}
}
