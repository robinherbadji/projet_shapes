package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class FunctionsDialog extends JDialog {

	public FunctionsDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panText = new JPanel();
		panText.setBackground(Color.white);
		// panText.setPreferredSize(new Dimension(500, 500));

		JTextArea textContent = new JTextArea();
		textContent.append("\tFunctionalities :\t\t\t\n");

		textContent.append("\n\n- Selection of Shape : Left Click");

		textContent.append("\n\nFile : \t- New -> Create a new blank project");
		textContent.append("\n\t- Open -> Open an existing project");
		textContent.append("\n\t- Save -> Save the project in the current folder");
		textContent.append("\n\t- Export -> Export the project as jpeg format");

		textContent.append("\n\nShape : \t- Rectangle -> Add a random colored rectangle");
		textContent.append("\n\t- Circle -> Add a random colored circle");
		textContent.append("\n\t- Text -> Add a random colored text that the user types");
		textContent.append("\n\t- Polygon -> Add a random colored polygon among a collection of polygons");
		textContent.append("\n\t- Image -> Import an image");

		textContent.append("\n\nColor : \t- Filled -> Change the filled color of the selected shape(s)");
		textContent.append("\n\t- Open -> Open an existing project");
		textContent.append("\n\t- Save -> Save the project in the current folder");
		textContent.append("\n\t- Export -> Export the project as jpeg format");

		panText.add(textContent);
		this.getContentPane().add(panText, BorderLayout.CENTER);

		JPanel control = new JPanel();
		JButton okButton = new JButton("OK");
		this.getRootPane().setDefaultButton(okButton);

		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okButton);

		this.getContentPane().add(control, BorderLayout.SOUTH);
	}

}
