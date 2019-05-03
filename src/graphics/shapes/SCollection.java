package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class SCollection extends Shape 
{
	private List<Shape> shapes;
	
	public SCollection()
	{
		this.shapes=new Vector<Shape>();
	}
	
	public Iterator<Shape> iterator()
	{
		return this.shapes.iterator();	
	}
	
	public void add(Shape s)
	{
		shapes.add(s);
	}
	
	public Point getLoc() 
	{
		return (new Point(this.getBounds().x,this.getBounds().y));
	}

	public void setLoc(Point p) 
	{
		for(Iterator<Shape> i=this.iterator(); i.hasNext();)
		{
			Shape s=(Shape)i.next() ;
			s.setLoc(p);
		}
	}

	public void translate(int dx, int dy) 
	{
		for(Iterator<Shape> i=this.iterator(); i.hasNext();)
		{
			Shape s=(Shape)i.next() ;
			s.translate(dx, dy);
		}
	}

	public Rectangle getBounds() 
	{
		Rectangle r=new Rectangle(this.shapes.iterator().next().getBounds());
		for(Iterator<Shape> i=this.iterator() ;i.hasNext();)
		{
			Shape s=(Shape)i.next() ;
			r=s.getBounds().union(r);
		}
		return r;
	}

	public void accept(ShapeVisitor v) 
	{
		v.visitCollection(this);
	}
}
