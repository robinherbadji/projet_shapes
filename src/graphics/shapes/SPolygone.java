package graphics.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.ArrayList;


public class SPolygone extends Shape {
	/*
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
		
		for (int i = 0 ; i < numberOfPoint(); i++ ) {
			
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

	
	
	//
	public ArrayList<Point> getPoints() {
		return this.points;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public int[] getX() {
		int np = numberOfPoint();
		System.out.println(np);
		int x[] = new int[np];
		for (int i = 0 ; i < np; i++ ) {
			x[i] = this.points.get(i).x;
		}
		return x;
	}
	
	public int[] getY() {
		
		int np = numberOfPoint();
		int y[] = new int[np];
		for (int i = 0 ; i < np; i++ ) {
			y[i] = this.points.get(i).x;
		}
		return y;
	}
	@Override
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitPolygone(this);
	}
	*/
	public int nPoints;
	public int x[];
	public int y[];
	
	public SPolygone() {
		this.nPoints = 5;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		int x[] = {200, 300, 300, 250, 200, 200};
		int y[] ={100, 100, 50, 30, 50, 100};
		this.x = x;
		this.y = y;
	}
	
	public SPolygone(int nPoints, int x[], int y[]) {
		this.nPoints = nPoints;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		for(int i = 0; i < nPoints; i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
	}
	
	public int getnPoints() {
		return nPoints;
	}
	
	public void setnPoints(int nPoints) {
		this.nPoints = nPoints;
	}
	
	public int[] getX() {
		return x;
	}
	
	public void setX(int[] x) {
		this.x = x;
	}
	
	public int[] getY() {
		return y;
	}
	
	public void setY(int[] y) {
		this.y = y;
	}
	
	public SPolygone getPolygone() {
		return this;
	}
	
	public void setPolygon(int nPoints, int x[], int y[]) {
		this.nPoints = nPoints;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		for(int i = 0; i < nPoints; i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
		}
	}
	
	public Point getLoc() {
		return this.getBounds().getLocation();
	}
	
	public void setLoc(Point p) {
		int dx = p.x - this.getBounds().x; 
		int dy = p.y - this.getBounds().y;
		for(int i = 0; i < nPoints; i++) {
			x[i] += dx;
			y[i] += dy;
		}
	}
	
	public Rectangle getBounds() {
		Polygon p = new Polygon(this.getX(), this.getY(), this.nPoints);
		return p.getBounds();
	}
	
	public void translate(int dx, int dy) {
		this.setLoc(new Point(dx + this.getLoc().x, dy + this.getLoc().y));
	}
	
	public void accept(ShapeVisitor visitor) {
		visitor.visitPolygone(this);
	}
}
