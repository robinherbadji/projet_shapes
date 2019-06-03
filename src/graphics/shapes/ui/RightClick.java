package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class RightClick {


	//fields
	JPopupMenu menu = new JPopupMenu();
	private ShapesController shapesController;


	//constructor

	public RightClick(ShapesController c) {
		this.shapesController = c;
	}

	public JPopupMenu click(MouseEvent e) {

		JMenuItem cop = new JMenuItem("Copy");
		cop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					shapesController.copy();
				} catch (CloneNotSupportedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		menu.add(cop);

		JMenuItem cut = new JMenuItem("Cut");
		cut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				shapesController.cut();
			}
		});
		menu.add(cut);

		JMenuItem pas = new JMenuItem("Paste");
		pas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				shapesController.paste(e.getPoint());
			}
		});
		menu.add(pas);

		JMenuItem del = new JMenuItem("Delete");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				shapesController.delete();
			}
		});
		menu.add(del);

		menu.addSeparator();


		// Color menu in the popup
		JMenu menuColor = new JMenu("   Color    ");
		menu.add(menuColor);
		JMenu mFilled = new JMenu(" Filled ");

		class FillShapes implements ActionListener {
			private Color fillColor;


			// function that fills the selected shapes with the color ( avoid redundancy )

			public FillShapes(Color fillColor) {
				this.fillColor = fillColor;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SCollection selectedShapes = shapesController.getSelected();
				Iterator<Shape> itr = selectedShapes.iterator();
				Shape shape = null;
				while (itr.hasNext()) {
					shape = itr.next();
					if (shape != null) {
						if (shape instanceof SCollection) {
							for (Shape shapeOfCollec : ((SCollection) shape).getCollection()) {
								ColorAttributes c = (ColorAttributes) shapeOfCollec.getAttributes("colorAttributes");
								c.setFilled(true);
								c.setFilledColor(fillColor);
							}
						} else {
							ColorAttributes c = (ColorAttributes) shape.getAttributes("colorAttributes");
							c.setFilled(true);
							c.setFilledColor(fillColor);
						}
					}
				}
				shapesController.getView().repaint();
			}
		}

		JMenuItem fGreen = new JMenuItem("Green");
		fGreen.addActionListener(new FillShapes(Color.GREEN));
		mFilled.add(fGreen);

		JMenuItem fRed = new JMenuItem("Red");
		fRed.addActionListener(new FillShapes(Color.RED));
		mFilled.add(fRed);

		JMenuItem fBlue = new JMenuItem("Blue");
		fBlue.addActionListener(new FillShapes(Color.BLUE));
		mFilled.add(fBlue);

		JMenuItem fBlack = new JMenuItem("Black");
		fBlack.addActionListener(new FillShapes(Color.BLACK));
		mFilled.add(fBlack);

		JMenuItem fWhite = new JMenuItem("White");
		fWhite.addActionListener(new FillShapes(Color.WHITE));
		mFilled.add(fWhite);

		JMenuItem fYellow = new JMenuItem("Yellow");
		fYellow.addActionListener(new FillShapes(Color.YELLOW));
		mFilled.add(fYellow);

		JMenuItem fGray = new JMenuItem("Gray");
		fGray.addActionListener(new FillShapes(Color.GRAY));
		mFilled.add(fGray);

		JMenuItem fOrange = new JMenuItem("Orange");
		fOrange.addActionListener(new FillShapes(Color.ORANGE));
		mFilled.add(fOrange);
		menuColor.add(mFilled);

		class StrokeShapes implements ActionListener {
			private Color strokeColor;

			public StrokeShapes(Color strokeColor) {
				this.strokeColor = strokeColor;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SCollection selectedShapes = shapesController.getSelected();
				Iterator<Shape> itr = selectedShapes.iterator();
				Shape shape = null;
				while (itr.hasNext()) {
					shape = itr.next();
					if (shape != null) {
						if (shape instanceof SCollection) {
							for (Shape shapeOfCollec : ((SCollection) shape).getCollection()) {
								ColorAttributes c = (ColorAttributes) shapeOfCollec.getAttributes("colorAttributes");
								c.setStroked(true);
								c.setStrokedColor(strokeColor);
							}
						} else {
							ColorAttributes c = (ColorAttributes) shape.getAttributes("colorAttributes");
							c.setStroked(true);
							c.setStrokedColor(strokeColor);
						}
					}
				}
				shapesController.getView().repaint();
			}
		}

		JMenu mStroked = new JMenu("Stroked");

		JMenuItem sGreen = new JMenuItem("Green");
		sGreen.addActionListener(new StrokeShapes(Color.GREEN));
		mStroked.add(sGreen);

		JMenuItem sRed = new JMenuItem("Red");
		sRed.addActionListener(new StrokeShapes(Color.RED));
		mStroked.add(sRed);

		JMenuItem sBlue = new JMenuItem("Blue");
		sBlue.addActionListener(new StrokeShapes(Color.BLUE));
		mStroked.add(sBlue);

		JMenuItem sBlack = new JMenuItem("Black");
		sBlack.addActionListener(new StrokeShapes(Color.BLACK));
		mStroked.add(sBlack);

		JMenuItem sWhite = new JMenuItem("White");
		sWhite.addActionListener(new StrokeShapes(Color.WHITE));
		mStroked.add(sWhite);

		JMenuItem sYellow = new JMenuItem("Yellow");
		sYellow.addActionListener(new StrokeShapes(Color.YELLOW));
		mStroked.add(sYellow);

		JMenuItem sGray = new JMenuItem("Gray");
		sGray.addActionListener(new StrokeShapes(Color.GRAY));
		mStroked.add(sGray);

		JMenuItem sOrange = new JMenuItem("Orange");
		sOrange.addActionListener(new StrokeShapes(Color.ORANGE));
		mStroked.add(sOrange);
		menuColor.add(mStroked);

		this.menu.show(e.getComponent(), e.getX(), e.getY());
		return this.menu;
	}

}
