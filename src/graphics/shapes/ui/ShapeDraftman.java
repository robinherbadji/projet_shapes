package graphics.shapes.ui;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.util.Iterator;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SPicture;
//import graphics.shapes.SPicture;
import graphics.shapes.SPolygone;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.Shape;
import graphics.shapes.ShapeVisitor;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ShapeDraftman implements ShapeVisitor {
	private Graphics g;	
	//private Shape shape;

	public ShapeDraftman(Graphics g) {
		this.g = g;
	}	
	
	// Dessin du carr� de S�lection
	public void drawSelectionShape(Rectangle rect) {
		final int size = 5;
		g.setColor(Color.black);
		g.drawRect(rect.x-size+2, rect.y-size+2, size, size);
	}
	
	// Visit Shapes
	@Override
	public void visitRectangle(SRectangle rect) {
		 Graphics2D g2d = (Graphics2D) g.create();
		if (rect != null) {
			int sX = rect.getRect().x; // ou sX = rect.getLoc().x;
			int sY = rect.getRect().y; // ou sY = rect.getLoc().y;
			int sW = rect.getRect().width;
			int sH = rect.getRect().height;
			g2d.translate(sX+sW/2,sY+sH/2);
			g2d.rotate(Math.toRadians(rect.getRotation()));
			g2d.translate(-sX-sW/2,-sY-sH/2);
			ColorAttributes cA = (ColorAttributes) rect.getAttributes("colorAttributes");
			if (cA != null) {
				if (cA.filled()) {
					g2d.setColor(cA.filledColor());
					g2d.fillRect(sX, sY, sW, sH);
					
				}
				if (cA.stroked()) {
					g2d.setColor(cA.strokedColor());
					g2d.drawRect(sX, sY, sW, sH);
					
				}			
			}
			else {
				g2d.setColor(Color.BLACK);
				g2d.fillRect(sX, sY, sW, sH);
				
			}
			
			SelectionAttributes sA = (SelectionAttributes) rect.getAttributes("selectionAttributes");
			if (sA != null && sA.isSelected()) {
				drawSelectionShape(rect.getBounds());			
			}
		}		
	}
	
	
	@Override
	public void visitCircle(SCircle scircle) {
		Graphics2D g2d = (Graphics2D) g.create();
		if (scircle != null) {
			int sX = scircle.getLoc().x;
			int sY = scircle.getLoc().y;		
			int diam = scircle.getRadius() * 2;			
			
			ColorAttributes cA = (ColorAttributes) scircle.getAttributes("colorAttributes");
			if (cA != null) {
				if (cA.filled()) {
					g2d.setColor(cA.filledColor());
					g2d.fillOval(sX, sY, diam, diam);
				}				
				if (cA.stroked()) {
					g2d.setColor(cA.strokedColor());
					g2d.drawOval(sX, sY, diam, diam);
				}
			}
			else {
				g2d.setColor(Color.BLACK);
				g2d.fillOval(sX, sY, diam, diam);
			}
			
			SelectionAttributes sA = (SelectionAttributes) scircle.getAttributes("selectionAttributes");
			if (sA != null && sA.isSelected()) {
				drawSelectionShape(scircle.getBounds());			
			}			
		}		
	}
	
	
	@Override
	public void visitText(SText stext) {
		Graphics2D g2d = (Graphics2D) g.create();
		if (stext != null) {
			Point loc = stext.getLoc();
			String text = stext.getText();
			
			FontAttributes fA = (FontAttributes) stext.getAttributes("fontAttributes");
			if (fA != null) {
				FontMetrics fMetrics = g.getFontMetrics(fA.font());
				fA.setFontMetrics(fMetrics);
				int sX = stext.getBounds().x;
				int sY = stext.getBounds().y;
				int sW = stext.getBounds().width;
				int sH = stext.getBounds().height;
				
				g2d.translate(sX+sW/2,sY+sH/2);
				g2d.rotate(Math.toRadians(stext.getRotation()));
				g2d.translate(-sX-sW/2,-sY-sH/2);
				ColorAttributes cA = (ColorAttributes) stext.getAttributes("colorAttributes");
				if (cA != null) {			
					if (cA.filled()) {
						if (stext.getBounds() != null) {
							g2d.setColor(cA.filledColor());
							g2d.fillRect(sX, sY, sW, sH);
						}				
					}					
					if (cA.stroked()) {	
						g2d.setColor(cA.strokedColor());
						g2d.drawString(text, loc.x, loc.y);
					}						
				}
				
				SelectionAttributes sA = (SelectionAttributes) stext.getAttributes("selectionAttributes");
				if (sA != null && sA.isSelected()) {
					drawSelectionShape(stext.getBounds());		
				}
			}
		}
	}
	
	
	@Override
	public void visitCollection(SCollection scollec) {
		
		Shape shape;
		if (scollec != null) {
			Iterator<Shape> itr = scollec.iterator();
			SelectionAttributes sA = (SelectionAttributes) scollec.getAttributes("selectionAttributes");
			while(itr.hasNext()) {
				shape = itr.next();
				shape.accept(this);
				if (sA != null && sA.isSelected()) {
					drawSelectionShape(shape.getBounds());
				}
			}
						
		}
	}

	@Override
	public void visitPolygone(SPolygone spolygone) {
		
		Graphics2D g2d = (Graphics2D) g.create();
		if (spolygone != null) {			
			
			int sX = spolygone.getBounds().x;
			int sY = spolygone.getBounds().y;
			int sW = spolygone.getBounds().width;
			int sH = spolygone.getBounds().height;
			
			AffineTransform affineT = g2d.getTransform();
			
			//affineT.translate(-sW/2, -sH/2);
			affineT.scale(spolygone.getScale(), spolygone.getScale());
			//affineT.translate(sW/(2*spolygone.getScale()),sH/(2*spolygone.getScale()));
			
			g2d.translate(sX+sW/2,sY+sH/2);
			g2d.rotate(Math.toRadians(spolygone.getRotation()));
			g2d.translate(-sX-sW/2,-sY-sH/2);
			//g2d.scale(spolygone.getScale(), spolygone.getScale());
			ColorAttributes cA = (ColorAttributes) spolygone.getAttributes("colorAttributes");
			if (cA != null) {
				if (cA.filled()) {
					g2d.setColor(cA.filledColor());
					g2d.fillPolygon(spolygone.getX(), spolygone.getY(), spolygone.getnPoints());
				}
				if (cA.stroked()) {
					
					g2d.setColor(cA.strokedColor());
					g2d.drawPolygon(spolygone.getX(), spolygone.getY(), spolygone.getnPoints());
				}
			}
			else {
				
				g2d.setColor(Color.BLACK);
				g2d.drawPolygon(spolygone.getX(), spolygone.getY(), spolygone.getnPoints());
			}
			
			SelectionAttributes sA = (SelectionAttributes) spolygone.getAttributes("selectionAttributes");
			if (sA != null && sA.isSelected()) {
				drawSelectionShape(spolygone.getBounds());		
			}	
			g2d.setTransform(affineT);
		}		
	}

	
	@Override
	public void visitImage(SPicture spicture) {
		Graphics g1 = spicture.getPicture().getGraphics();
		
		ColorAttributes cA = (ColorAttributes) spicture.getAttributes("colorAttributes");
		if (cA != null) {			
			if (cA.stroked()) {
				g.setColor(cA.strokedColor());
				g1.drawImage(spicture.getPicture(), spicture.getLoc().x, spicture.getLoc().y, null);
				g1.drawRect(spicture.getLoc().x, spicture.getLoc().y, spicture.getBounds().width,  spicture.getBounds().height);
			}
			
		}
		else {
			g1.drawImage(spicture.getPicture(), spicture.getLoc().x, spicture.getLoc().y, null);
		}
		
		SelectionAttributes sA = (SelectionAttributes) spicture.getAttributes("selectionAttributes");
		if (sA != null && sA.isSelected()) {
			drawSelectionShape(spicture.getBounds());
		}			
	}
	
	
}