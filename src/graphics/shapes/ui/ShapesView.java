package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.Shape;
import graphics.ui.View;
import graphics.ui.Controller;

public class ShapesView extends View {
	// H�rite du JPanel via View
	
	// Constructeur
	public ShapesView(Object model) {
		super(model);
	}
	
	///////////////////////////////////////////////////////
	
	// M�thodes
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		ShapeDraftman draftman = new ShapeDraftman(g);
		((Shape) model).accept(draftman);
	}
}
