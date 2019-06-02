package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FunctionsDialog extends JDialog {

	public FunctionsDialog(JFrame parent, String title, boolean modal) {
		super (parent, title, modal);
		this.setSize(500, 200);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panText = new JPanel();
		panText.setBackground(Color.white);
		panText.setPreferredSize(new Dimension(500, 200));

		JTextArea textContent = new JTextArea("Functionalities : \n- Selection of Shape : Left Click");
		textContent.setBounds(0, 0, this.getWidth(), this.getHeight());
		panText.add(textContent);

		/*
		JLabel titleLabel = new JLabel("Functionalities : \n- Selection of Shape : Left Click");
		panText.add(titleLabel);
		*/

		/*
		JLabel function_1 = new JLabel("- Selection of Shape : Left Click");
		panText.add(function_1);
		*/

		this.getContentPane().add(panText, BorderLayout.CENTER);



		JPanel control = new JPanel();
		JButton okButton = new JButton("OK");
		this.getRootPane().setDefaultButton(okButton);

		okButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okButton);

		this.getContentPane().add(control, BorderLayout.SOUTH);
	}

}
