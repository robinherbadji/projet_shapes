package graphics.shapes.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Export {

	void takePicture(ShapesView sview) {
		BufferedImage img = new BufferedImage(sview.getWidth(), sview.getHeight(), BufferedImage.TYPE_INT_RGB);
		sview.print(img.getGraphics()); // or: panel.printAll(...);
		try {
			String name = JOptionPane.showInputDialog("File Name  :  ");
			ImageIO.write(img, "jpg", new File(name + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
