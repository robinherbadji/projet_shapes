package graphics.shapes.ui;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SPicture;
//import graphics.shapes.SPicture;
import graphics.shapes.SPolygone;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Editor extends JFrame
{
	
	private ShapesView sview;
	//Shape model;
	private static SCollection model;
	private ControlPanel controlPanel;
	private ColorPanel colorPanel;
	
	public Editor()
	{
		super("Shapes Editor");

		this.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent evt)
			{
				System.exit(0);
			}
		});
		
		this.buildModel(); 
		
		// Affichage Mod�le :
		this.sview = new ShapesView(this.model);
		this.sview.setPreferredSize(new Dimension(300,300));
		this.getContentPane().add(this.sview, java.awt.BorderLayout.CENTER);
		
	    // Affichage Menu :
		controlPanel = new ControlPanel();
	    this.getContentPane().add(this.controlPanel, java.awt.BorderLayout.NORTH);
	    
	    // Affichage Menu :
	    colorPanel = new ColorPanel();
	 	this.getContentPane().add(this.colorPanel, java.awt.BorderLayout.EAST);
	}

	
	private void buildModel()
	{
		model = new SCollection();
		this.model.addAttributes(new SelectionAttributes());
		
		SRectangle r = new SRectangle(new Point(10,10),20,30);
		r.addAttributes(new ColorAttributes(true,false,Color.BLUE,Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		this.model.add(r);
		
		SCircle c = new SCircle(new Point(100,100),10);
		c.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.BLUE));
		c.addAttributes(new SelectionAttributes());
		this.model.add(c);
		
		SText t= new SText(new Point(100,100),"hello");
		t.addAttributes(new ColorAttributes(true,true,Color.YELLOW,Color.BLUE));
		t.addAttributes(new FontAttributes());
		t.addAttributes(new SelectionAttributes());
		this.model.add(t);
		
		
		int[] x={50,70,50,70,50};
		int[] y={100,200,200,100,100};
		int np = 4;
		
		SPolygone p = new SPolygone(np,x,y);
		//SPolygone p = new SPolygone();
		p.addAttributes(new ColorAttributes(true,true,Color.red,Color.BLUE));
		p.addAttributes(new SelectionAttributes());
		this.model.add(p);
		
		
		
		SPicture sp = new SPicture(new Point(100,200), "C:\\Documentutile\\ENSISA-logo-base-droite-RVB.jpg");
		sp.addAttributes(new SelectionAttributes());
		this.model.add(sp);
		
		
		SCollection sc = new SCollection();
		sc.addAttributes(new SelectionAttributes());
		r= new SRectangle(new Point(20,30),30,30);
		r.addAttributes(new ColorAttributes(true,false,Color.MAGENTA,Color.BLUE));
		r.addAttributes(new SelectionAttributes());
		sc.add(r);
		c = new SCircle(new Point(150,100),20);
		c.addAttributes(new ColorAttributes(false,true,Color.BLUE,Color.DARK_GRAY));
		c.addAttributes(new SelectionAttributes());
		sc.add(c);
		this.model.add(sc);
	}
	
	public static SCollection getModel() {
		return model;
	}
	
	public static void main(String[] args)
	{
		Editor self = new Editor();
		self.pack();
		self.setVisible(true);
	}
}
