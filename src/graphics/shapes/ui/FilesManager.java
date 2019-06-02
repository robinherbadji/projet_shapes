package graphics.shapes.ui;

import graphics.shapes.*;
import graphics.shapes.Shape;
import graphics.shapes.attributes.ColorAttributes;
import graphics.shapes.attributes.FontAttributes;
import graphics.shapes.attributes.SelectionAttributes;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class FilesManager {

	// fields
	private String nomDuFichier;
	private String Chemin;
	private PrintWriter d;

	// constructor

	public FilesManager() {
		this.nomDuFichier = "Monfichier.xml";
		this.Chemin = "Files/";
	}

	public void serialisation(Shape shape) {

		ColorAttributes colorAttribute = new ColorAttributes();
		FontAttributes fontAttribute = new FontAttributes();

		if (shape instanceof SRectangle) {
			SRectangle rectangle = (SRectangle) shape;
			ColorAttributes colorAtt = (ColorAttributes) rectangle.getAttributes(colorAttribute.getId());
			int f = 0;
			int s = 0;
			if (colorAtt.filled()) {
				f = colorAtt.filledColor().getRGB();
			}
			if (colorAtt.stroked()) {
				s = colorAtt.strokedColor().getRGB();
			}
			d.println(" <rectangle x=\"" + rectangle.getLoc().x + "\" y=\"" + rectangle.getLoc().y + "\"" + " height=\""
					+ rectangle.getRect().height + "\"" + " width=\"" + rectangle.getRect().width + "\"" + " filled=\""
					+ colorAtt.filled() + "\"" + " stroked=\"" + colorAtt.stroked() + "\"" + " filledColor=\"" + f
					+ "\"" + " strokedColor=\"" + s + "\"/>");
		}

		if (shape instanceof SCircle) {
			SCircle circle = (SCircle) shape;
			ColorAttributes colorAttributes = (ColorAttributes) circle.getAttributes(colorAttribute.getId());
			int f = 0;
			int s = 0;
			if (colorAttributes.filled()) {
				f = colorAttributes.filledColor().getRGB();
			}
			if (colorAttributes.stroked()) {
				s = colorAttributes.strokedColor().getRGB();
			}
			d.println(" <circle x=\"" + circle.getLoc().x + "\" y= \"" + circle.getLoc().y + "\"" + " radius =\""
					+ circle.getRadius() + "\"" + " filled=\"" + colorAttributes.filled() + "\"" + " stroked=\""
					+ colorAttributes.stroked() + "\"" + " filledColor=\"" + f + "\"" + " strokedColor=\"" + s
					+ "\"/>");
		}

		if (shape instanceof SText) {

			SText text = (SText) shape;
			ColorAttributes colorAttributes = (ColorAttributes) text.getAttributes(colorAttribute.getId());
			FontAttributes fontAttributes = (FontAttributes) text.getAttributes(fontAttribute.getId());
			int f = 0;
			int s = 0;

			if (colorAttributes.filled())
				f = colorAttributes.filledColor().getRGB();
			if (colorAttributes.stroked())
				s = colorAttributes.strokedColor().getRGB();
			int t = fontAttributes.fontColor().getRGB();
			d.println(" <text text=\"" + text.getText() + "\"" + " x=\"" + text.getLoc().x + "\" y=\"" + text.getLoc().y
					+ "\"" + " filled=\"" + colorAttributes.filled() + "\"" + " stroked=\"" + colorAttributes.stroked()
					+ "\"" + " filledColor=\"" + f + "\"" + " strokedColor=\"" + s + "\" />");
		}
		if (shape instanceof SCollection) {
			SCollection collection = (SCollection) shape;
			d.println("<collection>");
			for (Iterator<Shape> it = collection.iterator(); it.hasNext();) {
				Shape realShape = it.next();
				serialisation(realShape);
			}
			d.println("</collection>");
		}

		if (shape instanceof SPolygone) {
			SPolygone polygone = (SPolygone) shape;
			ColorAttributes colorAttributes = (ColorAttributes) polygone.getAttributes(colorAttribute.getId());
			int filled = 0;
			int stroked = 0;
			if (colorAttributes.filled()) {
				filled = colorAttributes.filledColor().getRGB();
			}
			if (colorAttributes.stroked()) {
				stroked = colorAttributes.strokedColor().getRGB();
			}
			d.println(" <polygone x=\"" + polygone.getLoc().x + "\" y=\"" + polygone.getLoc().y + "\"" + " np=\""
					+ polygone.nPoints + "\"" + " X=\"" + toString(polygone.x) + "\"" + " Y=\"" + toString(polygone.y)
					+ "\"" + " filled=\"" + colorAttributes.filled() + "\"" + " stroked=\"" + colorAttributes.stroked()
					+ "\"" + " filledColor=\"" + filled + "\"" + " strokedColor=\"" + stroked + "\"/>");
		}

		if (shape instanceof SPicture) {
			SPicture picture = (SPicture) shape;

			d.println(" <picture x=\"" + picture.getLoc().x + "\" y=\"" + picture.getLoc().y + "\" path=\""
					+ picture.getPath() + "\"/>");
		}

	}

	private String toString(int[] x) {
		return Arrays.toString(x);
	}

	private int[] toArray(String string) {

		String part = string.substring(1);

		String[] parts;

		parts = part.split("]");

		string = parts[0];

		String[] strings = string.split(",");

		int[] res = new int[strings.length];

		res[0] = Integer.parseInt(strings[0]);

		for (int i = 1; i < strings.length; i++) {

			if (strings[i].split(" ") instanceof String[]) {

				res[i] = Integer.parseInt(strings[i].substring(1));

				System.out.println(res[i]);

			} else {

				res[i] = Integer.parseInt(strings[i]);
			}

		}
		// System.out.println(array);
		return res;
	}

	public void lecture() {
		SCollection model = new SCollection();
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			final DocumentBuilder builder = factory.newDocumentBuilder();

			// this.nomDuFichier = JOptionPane.showInputDialog("Please enter file name : ");
			this.nomDuFichier = JOptionPane.showInputDialog(null, "Please enter file name : ", "Import File",
					JOptionPane.QUESTION_MESSAGE);
			final Document document = builder.parse(new File(Chemin + nomDuFichier + ".xml"));

			final Element root = document.getDocumentElement();

			System.out.println(root.getNodeName());

			final NodeList rootNodes = root.getChildNodes();
			final int nbRootNodes = rootNodes.getLength();

			for (int i = 0; i < nbRootNodes; i++) {
				if (rootNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element shape = (Element) rootNodes.item(i);
					model.add(deserialisation(shape));
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		Editor self = new Editor(model);
		self.pack();
		self.setVisible(true);

	}

	public void enregistrer(SCollection model) {

		try {
			// Enregistrer le fichier Sous (sans extension)
			this.nomDuFichier = JOptionPane.showInputDialog(null, "File name.*: ", "Save As",
					JOptionPane.QUESTION_MESSAGE);
			this.d = new PrintWriter(new BufferedOutputStream(new FileOutputStream(Chemin + nomDuFichier + ".xml")),
					true);
			System.out.println("jj");
			d.println("<shape>");
			for (Iterator<Shape> i = model.iterator(); i.hasNext();) {
				Shape shape = (Shape) i.next();
				serialisation(shape);
			}
			d.println("</shape>");
			d.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Shape deserialisation(Element shape) {
		String type = shape.getNodeName();

		if (type == "rectangle") {

			int x = Integer.parseInt(shape.getAttribute("x"));
			int y = Integer.parseInt(shape.getAttribute("y"));
			int height = Integer.parseInt(shape.getAttribute("height"));
			int width = Integer.parseInt(shape.getAttribute("width"));
			SRectangle r = new SRectangle(new Point(x, y), width, height);

			boolean filled = Boolean.parseBoolean(shape.getAttribute("filled"));
			boolean stroked = Boolean.parseBoolean(shape.getAttribute("stroked"));
			Color filledColor = Color.decode(shape.getAttribute("filledColor"));
			Color strokedColor = Color.decode(shape.getAttribute("strokedColor"));

			r.addAttributes(new ColorAttributes(filled, stroked, filledColor, strokedColor));
			r.addAttributes(new SelectionAttributes());

			return (r);
		}

		if (type == "circle") {

			int x = Integer.parseInt(shape.getAttribute("x"));

			int y = Integer.parseInt(shape.getAttribute("y"));

			int radius = Integer.parseInt(shape.getAttribute("radius"));

			SCircle c = new SCircle(new Point(x, y), radius);

			boolean filled = Boolean.parseBoolean(shape.getAttribute("filled"));
			boolean stroked = Boolean.parseBoolean(shape.getAttribute("stroked"));
			Color filledColor = Color.decode(shape.getAttribute("filledColor"));
			Color strokedColor = Color.decode(shape.getAttribute("strokedColor"));
			c.addAttributes(new ColorAttributes(filled, stroked, filledColor, strokedColor));
			c.addAttributes(new SelectionAttributes());

			return (c);
		}

		if (type == "polygone") {

			int np = Integer.parseInt(shape.getAttribute("np"));

			int[] x = new int[np + 1];
			int[] y = new int[np + 1];

			x = toArray(shape.getAttribute("X"));
			y = toArray(shape.getAttribute("Y"));
			SPolygone p = new SPolygone(np, x, y);

			boolean filled = Boolean.parseBoolean(shape.getAttribute("filled"));
			boolean stroked = Boolean.parseBoolean(shape.getAttribute("stroked"));
			Color filledColor = Color.decode(shape.getAttribute("filledColor"));
			Color strokedColor = Color.decode(shape.getAttribute("strokedColor"));

			p.addAttributes(new ColorAttributes(filled, stroked, filledColor, strokedColor));
			p.addAttributes(new SelectionAttributes());

			return (p);
		}

		if (type == "picture") {

			int x = Integer.parseInt(shape.getAttribute("x"));
			int y = Integer.parseInt(shape.getAttribute("y"));

			String path = shape.getAttribute("path");

			SPicture pic = new SPicture(new Point(x, y), path);

			return (pic);
		}

		if (type == "text") {

			int x = Integer.parseInt(shape.getAttribute("x"));

			int y = Integer.parseInt(shape.getAttribute("y"));

			String text = shape.getAttribute("text");
			SText t = new SText(new Point(x, y), text);

			t.addAttributes(new FontAttributes());

			boolean filled = Boolean.parseBoolean(shape.getAttribute("filled"));

			boolean stroked = Boolean.parseBoolean(shape.getAttribute("stroked"));

			Color filledColor = Color.decode(shape.getAttribute("filledColor"));

			Color strokedColor = Color.decode(shape.getAttribute("strokedColor"));

			t.addAttributes(new ColorAttributes(filled, stroked, filledColor, strokedColor));
			t.addAttributes(new FontAttributes());
			t.addAttributes(new SelectionAttributes());

			return (t);
		}

		if (type == "collection") {

			SCollection collection = new SCollection();
			final NodeList collectionNodes = shape.getChildNodes();
			final int nbColNodes = collectionNodes.getLength();

			for (int i = 0; i < nbColNodes; i++) {
				if (collectionNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element realShape = (Element) collectionNodes.item(i);
					collection.add(deserialisation(realShape));
				}
			}
			return (collection);
		}
		return null;
	}
}
