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

public class EditText extends JDialog {
	private JTextField jText;// locX, locY, width, height;	
	private ControlPanel menu;	  
	
	public EditText(JFrame parent, String title, boolean modal, ControlPanel menu){
		super(parent, title, modal);
		this.setSize(300, 120);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.initComponent();
		this.menu = menu;
	}
	
	
	private void initComponent(){
		JPanel panText = new JPanel();
		panText.setBackground(Color.white);
		panText.setPreferredSize(new Dimension(180, 120));
	    JLabel xLabel = new JLabel("Text : ");
	    
	    jText = new JTextField();
	    jText.setPreferredSize(new Dimension(100, 25));
	    panText.add(xLabel);
	    panText.add(jText);
		
	 
	    
	    JPanel content = new JPanel();
	    content.setBackground(Color.white);
	    content.add(panText);
	   
	    JPanel control = new JPanel();
	    JButton okButton = new JButton("OK");
	    this.getRootPane().setDefaultButton(okButton);
	    
	    okButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		menu.setText(jText.getText());
	    		setVisible(false);
	    	}
  
	    });

	    JButton cancelBouton = new JButton("Annuler");
	    cancelBouton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent arg0) {
	    		menu.setText("");
	    		setVisible(false);
	    	}
	    });
	    
	    control.add(okButton);
	    control.add(cancelBouton);

	    this.getContentPane().add(content, BorderLayout.CENTER);
	    this.getContentPane().add(control, BorderLayout.SOUTH);
	  }
	
}
