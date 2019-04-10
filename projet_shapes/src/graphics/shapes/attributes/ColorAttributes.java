
package graphics.shapes.attributes;

import java.awt.Color;

public class ColorAttributes extends Attributes {

	private static final String ID = "ColorAttributes";
	private boolean filled;
	private boolean stroked;
	private Color filledColor;
	private Color strokedColor;
	
	public ColorAttributes() {
		this.filled = true;
		this.stroked = true;
		this.filledColor = Color.white;
		this.strokedColor = Color.black;
	}
	
	public String getId() {
		return ID;
	}
	
	public boolean filled() {
		return this.filled;
	}
	
	public boolean stroked() {
		return this.stroked;
	}
	
	public Color filledColor() {
		return this.filledColor;
	}
	
	public Color strokedColor() {
		return this.strokedColor;
	}
}
