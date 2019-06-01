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

import graphics.shapes.SCircle;
import graphics.shapes.SCollection;
import graphics.shapes.SPicture;
import graphics.shapes.SPolygone;
import graphics.shapes.SRectangle;
import graphics.shapes.SText;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;

@SuppressWarnings("serial")
public class ControlPanel extends JPanel {
	private ShapesView shapesView;
	private ShapesController shapesController;
	private JMenuBar menuBar;
	private JMenu menuFile, menuShape, menuColor, menuGrid, menuAnim, menuHelp;
	private String sText, speed, gridState, path;
	private Map<String,Integer> speedMap;
	private boolean animationOn;
	
	public ControlPanel(ShapesView shapesView) {
		this.shapesView = shapesView;
		this.shapesController = (ShapesController) shapesView.defaultController(shapesView.getModel());
		this.menuBar = new JMenuBar();
		//this.menuBar.setBounds(0,0,this.shapesView.getWidth(),50);
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
				
				if (sText.length() > 0) {
					System.out.println("Création Texte");
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
		
		
		JMenuItem mPolygon = new JMenuItem("Polygon");
		mPolygon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Création Polygone");
				SPolygone p = new SPolygone();
				p.addAttributes(new ColorAttributes());
				p.addAttributes(new SelectionAttributes());
				((SCollection) shapesView.getModel()).add(p);
				shapesView.repaint();
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
				
				System.out.println("Création Image");
				
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
		
		menuColor = new JMenu("  Color  ");
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
				else System.out.println("Shit");
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
		mSlow.setAccelerator(KeyStroke.getKeyStroke('1'));
		mNormal.addActionListener(speedLis);
		mNormal.setAccelerator(KeyStroke.getKeyStroke('2'));
		mFast.addActionListener(speedLis);
		mFast.setAccelerator(KeyStroke.getKeyStroke('3'));
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

