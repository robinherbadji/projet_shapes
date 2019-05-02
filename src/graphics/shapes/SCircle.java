package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;

public class SCircle extends Shape
{
	private int radius;
	private Point loc;
	
	public SCircle()
	{
		this(new Point(50,50),100);
	}
	
	public SCircle(Point loc, int radius)
	{
		this.loc=loc;
		this.radius=radius;
	}
	
	public int getRadius()
	{
		return this.radius;
	}
	
	public void setRadius(int radius)
	{
		this.radius=radius;
	}
	
	public Point getLoc()
	{
		return this.loc;
	}

	public void setLoc(Point loc) 
	{
		this.loc=loc;
	}

	public void translate(int dx, int dy) 
	{
		this.loc.translate(dx, dy);
	}

	public Rectangle getBounds() 
	{
		Rectangle rect = new Rectangle();
		rect.setRect(this.loc.x, this.loc.y, (2*this.radius), (2*this.radius));
		return rect ;
	}

	public void accept(ShapeVisitor v) 
	{
		v.visitCircle(this);
	}

}
