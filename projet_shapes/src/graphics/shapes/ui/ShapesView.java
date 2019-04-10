package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.Shape;
import graphics.ui.View;


@SuppressWarnings("serial")
public class ShapesView extends View {

	
	public ShapesView(Shape model) {
		super(model);
	}

	public void paintComponent(Graphics g) {
		ShapeDraftman user = new ShapeDraftman(g);
		((Shape) model).accept(user);
		
	}
}
