package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import graphics.shapes.SCollection;
import graphics.shapes.SRectangle;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.SelectionAttributes;

@SuppressWarnings("serial")
public class ControlPanel extends JMenuBar {
	private JMenu menuShape;
	private SCollection model;
	
	public ControlPanel() {
		this.model = Editor.getModel();
		menuShape = new JMenu("Nouvelle Forme");		
		
		JMenuItem mRectangle = new JMenuItem("Rectangle");
		mRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Création Rectangle");
				SRectangle r = new SRectangle(new Point(50,40),25,20);
				r.addAttributes(new ColorAttributes(true,false,Color.BLUE,Color.BLUE));
				r.addAttributes(new SelectionAttributes());
				model.add(r);
			}			
		});
		menuShape.add(mRectangle);
		
		
		// Ces formes là n'ont pas encore été codées
		JMenuItem mCircle = new JMenuItem("Cercle");
		menuShape.add(mCircle);
		
		JMenuItem mText = new JMenuItem("Texte");
		menuShape.add(mText);
		
		this.add(menuShape);
	}
}
