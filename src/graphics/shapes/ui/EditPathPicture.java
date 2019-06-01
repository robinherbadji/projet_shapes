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

public class EditPathPicture extends JDialog {
	
	private JTextField jPath;// locX, locY, width, height;	
	private ControlPanel menu;	  
	
	public EditPathPicture(JFrame parent, String title, boolean modal, ControlPanel menu){
		super(parent, title, modal);
		this.setSize(300, 120);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		this.menu = menu;
	}
	
	
	private void initComponent(){
		JPanel panPath = new JPanel();
		panPath.setBackground(Color.white);
		panPath.setPreferredSize(new Dimension(180, 120));
	    JLabel xLabel = new JLabel("Path : ");
	    
	    jPath = new JTextField();
	    jPath.setPreferredSize(new Dimension(100, 25));
	    panPath.add(xLabel);
	    panPath.add(jPath);
		
	  
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);

	    content.add(panPath);
	   
	    JPanel control = new JPanel();
	    JButton okButton = new JButton("OK");
	    this.getRootPane().setDefaultButton(okButton);
	    
	    okButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		menu.setPath(jPath.getText());
	    		setVisible(false);
	    	}
  
	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		menu.setPath("");
	    		setVisible(false);
	    	}
	    });
	    
	    control.add(okButton);
	    control.add(cancelBouton);

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	  }
	
}