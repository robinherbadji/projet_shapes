package graphics.shapes.ui;

import java.awt.Graphics;

import graphics.shapes.SRectangle;
import graphics.shapes.ShapeVisitor;

public class ShapeDraftman implements ShapeVisitor {
	// Attributs
	private Graphics g;
	
	// Constructeur
	public ShapeDraftman(Graphics g) {
		this.g = g;
	}
	
	// Méthodes
	@Override
	public void visitRectangle(SRectangle rect) {
		int x = rect.getRect().x; // On se sert de la classe java et de notre classe SRectangle
		int y = rect.getRect().x;
		int w = rect.getRect().x;
		int h = rect.getRect().x;
		
		g.fillRect(x, y, w, h); // Regarder cette fonction dans la doc Oracle Java
	}
	
}
