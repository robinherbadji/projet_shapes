package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EditRectangle extends JDialog {
	private JTextField nom, locX, locY, width, height;	
	private ControlPanel menu;	  
	
	public EditRectangle(JFrame parent, String title, boolean modal, ControlPanel menu){
		super(parent, title, modal);
		this.setSize(500, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		//this.setVisible(true);
		
		this.menu = menu;
	}
	
	
	private void initComponent(){
	  //La position
	    JPanel panPosition = new JPanel();
	    panPosition.setBackground(Color.white);
	    panPosition.setPreferredSize(new Dimension(170, 100));
	    panPosition.setBorder(BorderFactory.createTitledBorder("Position"));
	    JLabel xLabel = new JLabel("Axe X : ");
	    JLabel pxLabel1 = new JLabel(" px");
	    locX = new JTextField("100");
	    locX.setPreferredSize(new Dimension(50, 25));
	    panPosition.add(xLabel);
	    panPosition.add(locX);
	    panPosition.add(pxLabel1);
	    
	    JLabel yLabel = new JLabel("Axe Y : ");
	    JLabel pxLabel2 = new JLabel(" px");
	    locY = new JTextField("100");
	    locY.setPreferredSize(new Dimension(50, 25));
	    panPosition.add(yLabel);
	    panPosition.add(locY);
	    panPosition.add(pxLabel2);
	    
	    
	    //La dimension
	    JPanel panTaille = new JPanel();
	    panTaille.setBackground(Color.white);
	    panTaille.setPreferredSize(new Dimension(170, 100));
	    panTaille.setBorder(BorderFactory.createTitledBorder("Dimensions"));
	    JLabel largeurLabel = new JLabel("Largeur : ");
	    JLabel pxLabel3 = new JLabel(" px");
	    width = new JTextField("100");
	    width.setPreferredSize(new Dimension(50, 25));
	    panTaille.add(largeurLabel);
	    panTaille.add(width);
	    panTaille.add(pxLabel3);
	    
	    JLabel hauteurLabel = new JLabel("Hauteur : ");
	    JLabel pxLabel4 = new JLabel(" px");
	    height = new JTextField("100");
	    height.setPreferredSize(new Dimension(50, 25));
	    panTaille.add(hauteurLabel);
	    panTaille.add(height);
	    panTaille.add(pxLabel4);
	   
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	   
	    //content.add(panPosition);
	    content.add(panTaille);
	   
	    JPanel control = new JPanel();
	    JButton okBouton = new JButton("OK");
	    
	    okBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	    	  this.collectInfos();
	    	  setVisible(false);
	      }

	      private void collectInfos() {
	    	  System.out.println(width.getText());
	    	  
	    	  menu.setWidth(Integer.parseInt(width.getText()));
	    	  menu.setHeight(Integer.parseInt(height.getText()));
	    	  
			
		}

	      public String getTaille(){
	        return (width.getText().equals("")) ? "180" : width.getText();
	      }      
	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	      public void actionPerformed(ActionEvent arg0) {
	    	  setVisible(false);
	      }      
	    });

	    control.add(okBouton);
	    control.add(cancelBouton);

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	  }
	
}
