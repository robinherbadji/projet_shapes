package graphics.shapes.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
		super (parent, title, modal);
		this.setSize(600, 850);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panText = new JPanel();
		panText.setBackground(Color.white);
		// panText.setPreferredSize(new Dimension(500, 500));

		JTextArea textContent = new JTextArea();
		textContent.setFont(new Font("Serif", Font.PLAIN, 14));
		textContent.append("\t\tFUNCTIONALITIES :\t\t\t\n");
		
		textContent.append("\n\n- Selection of Shape : Left Click");

		textContent.append("\n\nFile : \t- New -> Create a new blank project");
		textContent.append("\n\t- Open -> Open an existing project");
		textContent.append("\n\t- Save -> Save the project in the current folder");
		textContent.append("\n\t- Export -> Export the project as jpeg format");
		
		textContent.append("\n\nShape : \t- Rectangle -> Add a random colored Rectangle");
		textContent.append("\n\t- Circle -> Add a random colored Circle");
		textContent.append("\n\t- Text -> Add a random colored Text that the user edits");
		textContent.append("\n\t- Polygon -> Add a random colored Polygon among a collection of polygons");
		textContent.append("\n\t- Image -> Import an image");
		
		textContent.append("\n\nColor : \t- Filled -> Change the Filled Color of the selected shape(s)");
		textContent.append("\n\t- Open -> Open an existing project");
		textContent.append("\n\t- Save -> Save the project in the current folder");
		textContent.append("\n\t- Export -> Export the project as Jpeg format");
		
		textContent.append("\n\nGird : \t- Activate/Desactivate the Grid display");
		
		textContent.append("\n\nAnimation : \t- Start -> Start the Animation for the selected shape(s)");
		textContent.append("\n\t- Stop -> Stop the Animation");
		textContent.append("\n\t- Speed -> Select the Animation speed");
		
		textContent.append("\n\nHelp : \t- How does it works ? -> this Help");
		textContent.append("\n\t- About -> About the Project");
		
		textContent.append("\n\n-Raccourcis : \t'+' > Zoom the selected shape(s)");
		textContent.append("\n\t'-' > About the Project");
		textContent.append("\n\t'Left_Arrow' > Rotate in the trigonometric way");
		textContent.append("\n\t'Right_Arrow' > Rotate in the anti-trigonometric way");
		textContent.append("\n\t'a' > Start the Animation");
		textContent.append("\n\t'z' > Stop the Animation");
		textContent.append("\n\t'1','2','3' > Set the Animation Speed");
		textContent.append("\n\t'/' > Activate the Grid display");
		textContent.append("\n\t'*' > Desactivate the Grid display");

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
