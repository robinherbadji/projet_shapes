package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

public class ControlPanel extends JPanel {
	//private ShapesController shapeController;
	private ShapesView shapesView;
	private JMenuBar menuBar;
	private JMenu menuFile, menuShape, menuColor, menuHelp;
	//private SCollection model;	
	//private int width, height;
	private String text;
	
	public ControlPanel(ShapesView shapesView) {
		this.shapesView = shapesView;
		//this.shapeController = shapeController;
		this.menuBar = new JMenuBar();
		initialisation();
		//initialisationBis();
	}
	
	public void initialisationBis() {
		menuShape = new JMenu("  Shape  ");
		
		JMenuItem mRectangle = new JMenuItem("Rectangle");
		mRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				EditRectangle editRectangle = new EditRectangle(null, "Editer le Rectangle", true, getMenu());
				editRectangle.setVisible(true);
				*/
				//System.out.println("Création Rectangle : "+ width + ", " + height);				
				SRectangle r = new SRectangle();
				r.addAttributes(new ColorAttributes());
				r.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(r);					
								
				shapesView.repaint();
			}			
		});
		//mRectangle.setAccelerator(KeyStroke.getKeyStroke('r'));
		menuShape.add(mRectangle);
		
		menuBar.add(menuShape);
		
	}
	
	
	public void initialisation() {		
		
		
		menuFile = new JMenu("    File    ");
		JMenuItem mNew = new JMenuItem(" New ");
		mNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuFile.add(mNew);
		
		JMenuItem mOpen = new JMenuItem(" Open ");
		mOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuFile.add(mOpen);
		
		JMenuItem mSave = new JMenuItem(" Save ");
		mSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuFile.add(mSave);
		
		
		menuShape = new JMenu("  Shape  ");
		
		JMenuItem mRectangle = new JMenuItem("Rectangle   ");
		mRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				EditRectangle editRectangle = new EditRectangle(null, "Editer le Rectangle", true, getMenu());
				editRectangle.setVisible(true);
				*/
				//System.out.println("Création Rectangle : "+ width + ", " + height);				
				SRectangle r = new SRectangle();
				r.addAttributes(new ColorAttributes());
				r.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(r);					
								
				shapesView.repaint();
			}			
		});
		mRectangle.setAccelerator(KeyStroke.getKeyStroke('r'));
		menuShape.add(mRectangle);
		
		
		
		JMenuItem mCircle = new JMenuItem("Circle");
		mCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Création Cercle");
				SCircle c = new SCircle();
				c.addAttributes(new ColorAttributes());
				c.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(c);
				shapesView.repaint();
			}			
		});
		mCircle.setAccelerator(KeyStroke.getKeyStroke('c'));
		menuShape.add(mCircle);
		
		
		JMenuItem mText = new JMenuItem("Text");
		mText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditText editText = new EditText(null, "Edit the Text", true, getMenu());
				editText.setVisible(true);
				
				System.out.println("Création Texte");
				SText t= new SText(text);
				t.addAttributes(new ColorAttributes());
				t.addAttributes(new FontAttributes());
				t.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(t);
				shapesView.repaint();
			}			
		});
		mText.setAccelerator(KeyStroke.getKeyStroke('t'));
		menuShape.add(mText);
		
		
		menuColor = new JMenu("   Color   ");
		JMenuItem mFilled = new JMenuItem(" Filled ");
		mFilled.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuColor.add(mFilled);
		
		JMenuItem mStroked = new JMenuItem(" Stroked ");
		mStroked.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuColor.add(mStroked);
		
		menuHelp = new JMenu("   Help   ");
		JMenuItem mFunctions = new JMenuItem("How does it works ?");
		mFunctions.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuHelp.add(mFunctions);
		
		JMenuItem mAbout = new JMenuItem(" About ");
		mAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		menuHelp.add(mAbout);
		
		
		menuBar.add(menuFile);		
		menuBar.add(menuShape);
		menuBar.add(menuColor);
		menuBar.add(menuHelp);	
	}
		
	/*
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}*/
	
	public void setText(String text) {
		this.text = text;
	}
	
	
	public ControlPanel getMenu() {
		return this;
	}
	
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
	
}

