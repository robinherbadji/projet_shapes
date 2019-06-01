package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {
	private boolean filled;
	private boolean stroked;	
	private Color filledColor;
	private Color strokedColor;
	
	// Constructeur par défaut
	public ColorAttributes () {
		id = "colorAttributes";
		this.filled = true;
		this.stroked = true;
		this.filledColor = randomColor();
		this.strokedColor = randomColor();
	}
	
	public ColorAttributes (boolean filled, boolean stroked, Color filledColor, Color strokedColor) {
		id = "colorAttributes";
		this.filled = filled;
		this.stroked = stroked;
		this.filledColor = filledColor;
		this.strokedColor = strokedColor;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean stroked() {
		return this.stroked;
	}
	
	public boolean filled() {
		return this.filled;
	}
	
	public Color filledColor() {
		return this.filledColor;
	}
	
	public Color strokedColor() {
		return this.strokedColor;
	}
	
	public Color randomColor() {
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random()*256);
		int blue = (int)(Math.random()*256);
		
		Color color = new Color(red,green,blue);
		return color;		
		
	}

}