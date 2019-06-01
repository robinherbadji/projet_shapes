package graphics.shapes.ui;

import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;

import graphics.shapes.Shape;
import graphics.ui.Controller;
import graphics.ui.View;

@SuppressWarnings("serial")
public class ShapesView extends View {
	// H�rite du JPanel via View

	public ShapesView(Object model) {
		super(model);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ShapeDraftman draftman = new ShapeDraftman(g);
		((Shape) model).accept(draftman);

	}

	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
