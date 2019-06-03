package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SPicture;
import graphics.shapes.SPolygone;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Editor extends JFrame {

	private ShapesView sview;
	private SCollection model;
	private ControlPanel controlPanel;

	public Editor() {
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);
			}
		});

		this.buildModel();

		// Affichage Modele :
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(300, 300));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);

		// Affichage Menu Principal :
		controlPanel = new ControlPanel(this.sview);
		this.setJMenuBar(controlPanel.getMenuBar());

	}

	public Editor(SCollection model) {
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent evt) {
				System.exit(0);
			}
		});

		this.buildModel();

		// Affichage Modele :
		this.sview = new ShapesView(model);
		this.sview.setPreferredSize(new Dimension(300, 300));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);

		// Affichage Menu Principal :
		controlPanel = new ControlPanel(this.sview);
		this.setJMenuBar(controlPanel.getMenuBar());
	}

	private void buildModel() {
		model = new SCollection();
		this.model.addAttributes(new SelectionAttributes());

		SRectangle r = new SRectangle(new Point(10, 10), 20, 30);
		r.addAttributes(new ColorAttributes(true, false, Color.BLUE, Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		this.model.add(r);

		SCircle c = new SCircle(new Point(100, 100), 10);
		c.addAttributes(new ColorAttributes(false, true, Color.BLUE, Color.BLUE));
		c.addAttributes(new SelectionAttributes());
		this.model.add(c);

		SText t = new SText(new Point(100, 100), "hello");
		t.addAttributes(new ColorAttributes(true, true, Color.YELLOW, Color.BLUE));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		this.model.add(t);

		/*
		 * int[] x={50,70,50,70,50}; int[] y={100,200,200,100,100}; int np = 4;
		 * SPolygone p = new SPolygone(np,x,y);
		 */
		
		String path = "Files/ensisa.png";
		BufferedImage buffImage;
		try {
			buffImage = ImageIO.read(new File(path));
			if (buffImage != null) {
				SPicture sp = new SPicture(new Point(100, 200), path);
				sp.addAttributes(new SelectionAttributes());
				this.model.add(sp);
			}
		} catch (IOException e) {
			System.out.println("Invalid path for the picture");
		}
		

		SPolygone p = new SPolygone(new Point(200, 250));
		p.addAttributes(new ColorAttributes(true, true, Color.red, Color.green));
		p.addAttributes(new SelectionAttributes());
		// p.barycentre();
		this.model.add(p);

		
		/*
		SCollection sc = new SCollection();
		sc.addAttributes(new SelectionAttributes());
		SRectangle r1 = new SRectangle(new Point(20, 30), 30, 30);
		r1.addAttributes(new ColorAttributes(true, false, Color.MAGENTA, Color.BLUE));
		r1.addAttributes(new SelectionAttributes());
		sc.add(r1);
		SCircle c1 = new SCircle(new Point(150, 100), 20);
		c1.addAttributes(new ColorAttributes(false, true, Color.BLUE, Color.DARK_GRAY));
		c1.addAttributes(new SelectionAttributes());
		sc.add(c1);
		this.model.add(sc);
		*/
	}

	public static void main(String[] args) {
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);

	}
}
