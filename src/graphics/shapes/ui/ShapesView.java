package graphics.shapes.ui;

import java.awt.Color;
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
	private boolean gridState;
	
	public ShapesView(Object model) {
		super(model);
		this.gridState = false;
	}
	
	public void setGridState(boolean gridState) {
		this.gridState = gridState;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		ShapeDraftman draftman = new ShapeDraftman(g);
		((Shape) model).accept(draftman);
		if (this.gridState)	this.drawGrid(g);
	}	
	
	public Controller defaultController(Object model) {
		return new ShapesController(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub		
	}
	
	public void drawGrid(Graphics g) {
		g.setColor(Color.BLACK);
		final int step = 50;
		for (int i = step; i < this.getWidth(); i += step) {
			g.drawLine(i, -5, i, this.getHeight());
		}
		for (int i = step; i < this.getHeight(); i += step) {
			g.drawLine(0, i, this.getWidth(), i);
		}
	}
	
}
