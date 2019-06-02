package graphics.shapes.ui;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
	private JMenu menuFile, menuShape, menuColor, menuGrid, menuAnim, menuHelp;
	private String sText, path, speed, gridState;
	private Map<String,Integer> speedMap;
	private boolean animationOn;

	public ControlPanel(ShapesView shapesView ) {
		this.shapesView = shapesView;
		this.shapesController = (ShapesController) shapesView.getController();
		this.menuBar = new JMenuBar();
		this.menuBar.setSize(this.shapesView.getWidth(), 100);
		this.animationOn = false;
		this.speed = "Normal";
		this.speedMap = new TreeMap<String,Integer>();
		this.speedMap.put("Slow", 18);
		this.speedMap.put("Normal", 8);
		this.speedMap.put("Fast", 2);
		initialisation();
	}


	public void initialisation() {
		menuFile = new JMenu("   File    ");
		JMenuItem mNew = new JMenuItem(" New ");
		mNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				shapesController.blank();
			}
		});
		menuFile.add(mNew);

		JMenuItem mOpen = new JMenuItem(" Open ");
		mOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				shapesController.open();
			}
		});
		menuFile.add(mOpen);

		JMenuItem mSave = new JMenuItem(" Save ");
		mSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				shapesController.save();
			}
		});
		menuFile.add(mSave);


		JMenuItem mExport = new JMenuItem("Export");
		mExport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shapesController.export();
			}
		});
		menuFile.add(mExport);

		////////////////////////////////////////////////////////

		menuShape = new JMenu("  Shape  ");
		JMenuItem mRectangle = new JMenuItem("Rectangle   ");
		mRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
				System.out.println("Creation Cercle");
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
				sText = JOptionPane.showInputDialog(null, "set Text : ", "Text Creation", JOptionPane.QUESTION_MESSAGE);
				if ((sText != null) && (sText.length() > 0)) {
					System.out.println("Creation Texte");
					SText t= new SText(sText);
					t.addAttributes(new ColorAttributes());
					t.addAttributes(new FontAttributes());
					t.addAttributes(new SelectionAttributes());
					((SCollection) shapesView.getModel()).add(t);
					shapesView.repaint();
				}
			}
		});
		mText.setAccelerator(KeyStroke.getKeyStroke('t'));
		menuShape.add(mText);

		//////////////////////////////////////////////////////

		JMenuItem mPolygon = new JMenuItem("Polygon");
		mPolygon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Creation Polygone");
				SPolygone p = new SPolygone();
				p.addAttributes(new ColorAttributes());
				p.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(p);
			}
		});

		mPolygon.setAccelerator(KeyStroke.getKeyStroke('p'));
		menuShape.add(mPolygon);


		//------------  SPicture -------------

		JMenuItem mPathPicture = new JMenuItem("Picture");
		mPathPicture.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditPathPicture setPath = new EditPathPicture(null, "Set the path picture to import", true, getMenu());
				setPath.setVisible(true);

				System.out.println("Creation Image");

				SPicture sp = new SPicture(new Point(400,200), path);
				sp.addAttributes(new ColorAttributes(false,false,Color.BLUE,Color.BLUE));
				sp.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(sp);
				shapesView.repaint();
			}
		});
		mPolygon.setAccelerator(KeyStroke.getKeyStroke('p'));
		menuShape.add(mPolygon);

		/////////////////////////////////////////////////////////////

		menuColor = new JMenu("   Color    ");
		JMenu mFilled = new JMenu(" Filled ");
		
		class FillShapes implements ActionListener {
			private Color fillColor;			
			public FillShapes(Color fillColor) {
				this.fillColor = fillColor;
			}
			@Override
			public void actionPerformed(ActionEvent arg0) {
				SCollection selectedShapes = shapesController.getSelected();
				Iterator<Shape> itr = selectedShapes.iterator();
				Shape shape = null;				
				while(itr.hasNext()) {
					shape = itr.next();					
					if (shape != null) {
						if (shape instanceof SCollection) {
							for (Shape shapeOfCollec : ((SCollection) shape).getCollection()) {
								ColorAttributes c = (ColorAttributes) shapeOfCollec.getAttributes("colorAttributes");
								c.setFilled(true);
								c.setFilledColor(fillColor);
							}
						}
						else {					
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
				while(itr.hasNext()) {
					shape = itr.next();					
					if (shape != null) {
						if (shape instanceof SCollection) {
							for (Shape shapeOfCollec : ((SCollection) shape).getCollection()) {
								ColorAttributes c = (ColorAttributes) shapeOfCollec.getAttributes("colorAttributes");
								c.setStroked(true);
								c.setStrokedColor(strokeColor);
							}
						}
						else {					
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
		

		/////////////////////////////////////////////////////////////

		menuGrid = new JMenu("   Grid   ");
		JRadioButtonMenuItem mGridOn = new JRadioButtonMenuItem("ON");
		JRadioButtonMenuItem mGridOff = new JRadioButtonMenuItem("OFF");
		ButtonGroup bgGrid = new ButtonGroup();
		bgGrid.add(mGridOn);
		bgGrid.add(mGridOff);

		class GridListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
				gridState = ((JRadioButtonMenuItem)e.getSource()).getText();
				if (gridState == "ON") {
					shapesView.setGridState(true);
				}
				else if (gridState == "OFF") {
					shapesView.setGridState(false);
				}
				shapesView.repaint();
			}
		}

		GridListener gridLis = new GridListener();
		mGridOn.addActionListener(gridLis);
		mGridOn.setAccelerator(KeyStroke.getKeyStroke('/'));
		mGridOff.addActionListener(gridLis);
		mGridOff.setAccelerator(KeyStroke.getKeyStroke('*'));

		mGridOff.setSelected(true);
		menuGrid.add(mGridOn);
		menuGrid.add(mGridOff);

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
		mStart.setAccelerator(KeyStroke.getKeyStroke('a'));
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
		mStop.setAccelerator(KeyStroke.getKeyStroke('z'));
		menuAnim.add(mStop);
		menuAnim.addSeparator();

		JMenu mSpeed = new JMenu(" Speed ");
		JRadioButtonMenuItem mSlow = new JRadioButtonMenuItem("Slow");
		JRadioButtonMenuItem mNormal = new JRadioButtonMenuItem("Normal");
		JRadioButtonMenuItem mFast = new JRadioButtonMenuItem("Fast");
		JLabel speedInfo = new JLabel("   (Normal)");

		ButtonGroup bgSpeed = new ButtonGroup();
		bgSpeed.add(mSlow);
		bgSpeed.add(mNormal);
		bgSpeed.add(mFast);

		class SpeedListener implements ActionListener {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		mSlow.setAccelerator(KeyStroke.getKeyStroke('1'));
		mNormal.addActionListener(speedLis);
		mNormal.setAccelerator(KeyStroke.getKeyStroke('2'));
		mFast.addActionListener(speedLis);
		mFast.setAccelerator(KeyStroke.getKeyStroke('3'));
		mFast.addActionListener(speedLis);
		mSpeed.add(mSlow);
		mSpeed.add(mNormal);
		mSpeed.add(mFast);
		mNormal.setSelected(true);
		menuAnim.add(mSpeed);
		menuAnim.add(speedInfo);

		/////////////////////////////////////////////////////////////

		menuHelp = new JMenu("   Help   ");
		JMenuItem mFunctions = new JMenuItem("How does it work ?");
		mFunctions.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				FunctionsDialog fDialog = new FunctionsDialog(null, "How does it work ?", true);
				fDialog.setVisible(true);
			}
		});
		mFunctions.setAccelerator(KeyStroke.getKeyStroke('?'));
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
		menuBar.add(menuGrid);
		menuBar.add(menuAnim);
		menuBar.add(menuHelp);
	}

	public void setText(String text) {
		this.sText = text;
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

