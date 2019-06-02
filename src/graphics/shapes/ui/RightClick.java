package graphics.shapes.ui;

import graphics.shapes.SCollection;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class RightClick {

	JPopupMenu menu = new JPopupMenu();

	private ShapesController shapesController;

	public RightClick(ShapesController c) {
		this.shapesController = c;
	}

	public JPopupMenu click(MouseEvent e) {

		JMenuItem del = new JMenuItem("Delete");
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// shapesController.delete();
			}
		});
		menu.add(del);

		JMenuItem cop = new JMenuItem("Copy");
		cop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// shapesController.copy();
			}
		});
		menu.add(cop);

		JMenuItem pas = new JMenuItem("Paste");
		pas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				// shapesController.paste();
			}
		});
		menu.add(pas);

		JMenu menuColor = new JMenu("Color  ");

		menu.add(menuColor);

		JMenu mFilled = new JMenu(" Filled ");

		ColorAttributes colorAtt = new ColorAttributes();

		JMenuItem vert = new JMenuItem("Green");

		vert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.GREEN);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.GREEN);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(vert);

		JMenuItem rouge = new JMenuItem("Red");

		rouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.red);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.red);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(rouge);

		JMenuItem blue = new JMenuItem("Blue");

		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.BLUE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.BLUE);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(blue);

		JMenuItem black = new JMenuItem("Black");

		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.BLACK);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.BLACK);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(black);

		JMenuItem white = new JMenuItem("White");

		white.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.WHITE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.WHITE);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(white);

		JMenuItem yellow = new JMenuItem("Yellow");

		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.YELLOW);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.YELLOW);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(yellow);

		JMenuItem gray = new JMenuItem("Gray");

		gray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.GRAY);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.GRAY);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(gray);

		JMenuItem orange = new JMenuItem("Orange");

		orange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setFilled(true);
						c.setFilledColor(Color.ORANGE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setFilled(true);
					c.setFilledColor(Color.ORANGE);
					shapesController.getView().repaint();
				}
			}

		});
		mFilled.add(orange);

		menuColor.add(mFilled);

		JMenu mStroked = new JMenu("Stroked");

		JMenuItem svert = new JMenuItem("Green");

		svert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.GREEN);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.GREEN);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(svert);

		JMenuItem srouge = new JMenuItem("Red");

		srouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.red);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.red);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(srouge);

		JMenuItem sblue = new JMenuItem("Blue");

		sblue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.BLUE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.BLUE);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(sblue);

		JMenuItem sblack = new JMenuItem("Black");

		sblack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.BLACK);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.BLACK);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(sblack);

		JMenuItem swhite = new JMenuItem("White");

		swhite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.WHITE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.WHITE);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(swhite);

		JMenuItem syellow = new JMenuItem("Yellow");

		syellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.YELLOW);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.YELLOW);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(syellow);

		JMenuItem sgray = new JMenuItem("Gray");

		sgray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (graphics.shapes.Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.GRAY);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.GRAY);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(sgray);

		JMenuItem sorange = new JMenuItem("Orange");

		sorange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				graphics.shapes.Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
						ColorAttributes c = ((ColorAttributes) shape.getAttributes(colorAtt.getId()));
						c.setStroked(true);
						c.setStrokedColor(Color.ORANGE);
						shapesController.getView().repaint();
					}
				} else {
					ColorAttributes c = ((ColorAttributes) change.getAttributes(colorAtt.getId()));
					c.setStroked(true);
					c.setStrokedColor(Color.ORANGE);
					shapesController.getView().repaint();
				}
			}

		});
		mStroked.add(sorange);

		menuColor.add(mStroked);
		this.menu.show(e.getComponent(), e.getX(), e.getY());
		return this.menu;
	}

}
