package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import graphics.shapes.*;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private ShapesView shapesView;
	private ShapesController shapesController;
	private JMenuBar menuBar;
	private JMenu menuFile, menuShape, menuColor, menuAnim, menuHelp;
	private String text;
	private String path;
	private String speed;
	private Map<String,Integer> speedMap;
	private boolean animationOn;

	public ControlPanel(ShapesView shapesView ) {




		this.shapesView = shapesView;
		//pour le changement de couleur il faut le controller du shapesview pas le default controller.

		this.shapesController = (ShapesController) shapesView.getController();
		this.menuBar = new JMenuBar();
		this.animationOn = false;
		this.speed = "Normal";
		this.speedMap = new TreeMap<String,Integer>();
		this.speedMap.put("Slow", 25);
		this.speedMap.put("Normal", 10);
		this.speedMap.put("Fast", 2);
		initialisation();
	}


	public void initialisation() {
		menuFile = new JMenu("   File   ");
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

		////////////////////////////////////////////////////////

		menuShape = new JMenu("  Shape  ");
		JMenuItem mRectangle = new JMenuItem("Rectangle   ");
		mRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				EditRectangle editRectangle = new EditRectangle(null, "Editer le Rectangle", true, getMenu());
				editRectangle.setVisible(true);
				*/
				//System.out.println("Cr�ation Rectangle : "+ width + ", " + height);
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
				System.out.println("Cr�ation Cercle");
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

				System.out.println("Cr�ation Texte");
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


		//------------  SPicture -------------

		JMenuItem mPathPicture = new JMenuItem("Picture");
		mPathPicture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditPathPicture setPath = new EditPathPicture(null, "Set the path picture to import", true, getMenu());
				setPath.setVisible(true);

				System.out.println("Cr�ation Image");

				SPicture sp = new SPicture(new Point(400,200), path);
				sp.addAttributes(new ColorAttributes(false,false,Color.BLUE,Color.BLUE));
				sp.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(sp);
				shapesView.repaint();
			}
		});
		mPathPicture.setAccelerator(KeyStroke.getKeyStroke('p'));
		menuShape.add(mPathPicture);

		/////////////////////////////////////////////////////////////

		menuColor = new JMenu("   Color   ");
		JMenu mFilled = new JMenu(" Filled ");

		ColorAttributes colorAtt = new ColorAttributes();


		JMenuItem vert = new JMenuItem("vert");

		vert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem rouge = new JMenuItem("rouge");

		rouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem blue = new JMenuItem("blue");

		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem black = new JMenuItem("black");

		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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



		JMenuItem white = new JMenuItem("white");

		white.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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

		JMenuItem yellow = new JMenuItem("yellow");

		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem gray = new JMenuItem("gray");

		gray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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

		JMenuItem orange = new JMenuItem("orange");

		orange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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




		JMenu mStroked = new JMenu("stroked");

		JMenuItem svert = new JMenuItem("vert");

		svert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem srouge = new JMenuItem("rouge");

		srouge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem sblue = new JMenuItem("blue");

		sblue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem sblack = new JMenuItem("black");

		sblack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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



		JMenuItem swhite = new JMenuItem("white");

		swhite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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

		JMenuItem syellow = new JMenuItem("yellow");

		syellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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


		JMenuItem sgray = new JMenuItem("gray");

		sgray.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
				if (change instanceof SCollection) {
					for (Shape shape : ((SCollection) change).getCollection()) {
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

		JMenuItem sorange = new JMenuItem("orange");

		sorange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				Shape change = shapesController.getTarget();
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

		/////////////////////////////////////////////////////////////

		menuAnim = new JMenu("   Animation   ");
		JMenuItem mStart = new JMenuItem(" Start ");
		mStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println("Lancement Anim : "+speed+" = "+speedMap.get(speed));
				shapesController.animatedSelected(shapesView,speedMap.get(speed));
				mStart.setEnabled(false);
				animationOn = true;
			}
		});
		mStart.setAccelerator(KeyStroke.getKeyStroke('1'));
		menuAnim.add(mStart);

		JMenuItem mStop = new JMenuItem(" Stop ");
		mStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mStart.setEnabled(true);
				//System.out.println("Stop Anim");
				shapesController.getTimer().stop();
				animationOn = false;
			}
		});
		mStop.setAccelerator(KeyStroke.getKeyStroke('2'));
		menuAnim.add(mStop);
		menuAnim.addSeparator();
		JMenu mSpeed = new JMenu(" Speed ");
		JRadioButtonMenuItem mSlow = new JRadioButtonMenuItem("Slow");
		JRadioButtonMenuItem mNormal = new JRadioButtonMenuItem("Normal");
		JRadioButtonMenuItem mFast = new JRadioButtonMenuItem("Fast");
		JLabel speedInfo = new JLabel("   (Normal)");
		ButtonGroup bg = new ButtonGroup();
		bg.add(mSlow);
		bg.add(mNormal);
		bg.add(mFast);

		class SpeedListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				//System.out.println(((JRadioButtonMenuItem)e.getSource()).getText());
				speed = ((JRadioButtonMenuItem)e.getSource()).getText();
				speedInfo.setText("   ("+((JRadioButtonMenuItem)e.getSource()).getText()+")");
				if (animationOn) { // On relance l'animation pour que la vitesse soit prise en compte
					shapesController.getTimer().stop();
					shapesController.animatedSelected(shapesView,speedMap.get(speed));
				}
			}
		}
		SpeedListener speedLis = new SpeedListener();
		mSlow.addActionListener(speedLis);
		mNormal.addActionListener(speedLis);
		mFast.addActionListener(speedLis);
		mSpeed.add(mSlow);
		mSpeed.add(mNormal);
		mSpeed.add(mFast);
		mNormal.setSelected(true);
		menuAnim.add(mSpeed);
		menuAnim.add(speedInfo);

		/////////////////////////////////////////////////////////////

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
		menuBar.add(menuAnim);
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

	public void setPath(String path) {
		this.path = path;
	}


	public ControlPanel getMenu() {
		return this;
	}


	public JMenuBar getMenuBar() {
		return this.menuBar;
	}

}

