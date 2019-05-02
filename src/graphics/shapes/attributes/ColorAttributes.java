package graphics.shapes.attributes;

import java.awt.Color;
//import java.util.List;
//import java.util.Vector;

//import graphics.shapes.Shape;

public class ColorAttributes extends Attributes
{
	private boolean filled;
	private boolean strocked;
	private Color filledColor;
	private Color strockedColor;
	private String id;
	
	public ColorAttributes(boolean filled, boolean strocked, Color filledColor, Color strockedColor)
	{
		this.id ="Color";
		this.filled=filled;
		this.strocked=strocked;
		this.filledColor=filledColor;
		this.strockedColor=strockedColor;
	}
	
	public String getId() 
	{
		return this.id;
	}
	
	public boolean filled()
	{
		return this.filled;	
	}
	
	public boolean strocked()
	{
		return this.strocked;
	}
	
	public Color filledColor()
	{
		return this.filledColor;
	}
	
	public Color strockedColor()
	{
		return this.strockedColor;	
	}
}
