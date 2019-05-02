package graphics.shapes.attributes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class FontAttributes extends Attributes 
{
	private Font font;
	private Color fontColor;
	private String id;
	
	public FontAttributes()
	{
		this(new Font("Arial",Font.PLAIN,12),Color.BLACK);
	}
	
	public FontAttributes(Font font, Color fontColor)
	{
		this.id="Font";
		this.font=font;
		this.fontColor=fontColor;
	}
	
	public String getId() 
	{
		return this.id;
	}
	
	public Font font()
	{
		return this.font;
	}
	
	public Color fontColor()
	{
		return this.fontColor;
	}
	
	public Rectangle getBounds(String g)
	{
		Rectangle r=new Rectangle() ;
		return r;
	}
}

