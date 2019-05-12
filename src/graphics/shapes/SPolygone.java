package graphics.shapes;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.awt.Polygon;


public class SPolygone extends Shape {
	
	private Point loc;
	private ArrayList<Point> points;

	
	
	
	public SPolygone (ArrayList<Point> points) {
		this.points = points;
		this.loc = getPoint(0);
		
	}
	
	
	public Point getPoint(int i) {
		return this.points.get(i);
	}
	
	public int numberOfPoint() {
		return this.points.size();
	}
	
	
	@Override
	public Point getLoc() {
		return this.loc;
	}

	@Override
	public void setLoc(Point point) {
		this.loc = point;
	}

	@Override
	public void translate(int dx, int dy) {	
		
		for (int i = 0 ; i < this.points.size(); i++ ) {
			
			int x = this.points.get(i).x;
			int y = this.points.get(i).y;
			this.points.get(i).setLocation(x+dx ,y+dy);
			
		}
	}

	@Override
	public Rectangle getBounds() {
		
		Polygon p = new Polygon(this.getX(), this.getY(),  numberOfPoint());
		return p.getBounds();
	}

	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitPolygone(this);
	}
	
	//
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public int[] getX() {

		int x[] = new int[numberOfPoint()];
		for (int i = 0 ; i < this.points.size(); i++ ) {
			x[i] = this.points.get(i).x;
		}
		return x;
	}
	
	public int[] getY() {

		int y[] = new int[numberOfPoint()];
		for (int i = 0 ; i < this.points.size(); i++ ) {
			y[i] = this.points.get(i).x;
		}
		return y;
	}
}
