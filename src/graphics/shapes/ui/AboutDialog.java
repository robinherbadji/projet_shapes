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
public class AboutDialog extends JDialog {

	public AboutDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(350, 260);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setFocusable(true);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		JPanel panText = new JPanel();
		panText.setBackground(Color.white);

		JTextArea textContent = new JTextArea();
		textContent.setEditable(false);
		textContent.setFont(new Font("Serif", Font.PLAIN, 18));
		textContent.append("             JAVA PROJECT\n");

		textContent.append("\n\nAuthors : \t- Bahrallil Khadija");
		textContent.append("\n\t- Brugger Marie-Camille");
		textContent.append("\n\t- Herbadji Robin");
		textContent.append("\n\t- Sameh Yassine");

		panText.add(textContent);

		/*
		 * JLabel l = new
		 * JLabel("<html><a href=\"https://github.com/robinherbadji/projet_shapes\">Lien</a></html>"
		 * ); panText.add(l);
		 */

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