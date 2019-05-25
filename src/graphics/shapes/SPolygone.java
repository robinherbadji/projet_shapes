package graphics.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;


public class SPolygone extends Shape {
	public int nPoints;
	public int x[];
	public int y[];
	private float rotation;
	
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

	public void rotate(int degree) {
	 	double rads = degree * (Math.PI/180);
	    float sin = (float) Math.sin(rads);
	    float cos = (float) Math.cos(rads);
	    int[][] matrice = new int[4][4];
	    matrice[0][0] = (int) cos;
	    matrice[0][1] = (int) -sin;
	    matrice[1][0] = (int) sin;
	    matrice[1][1] = (int) cos;
	    for(int i=0; i<this.x.length; i++) {
	        this.x[i] = (this.x[i] * matrice[0][0]) + (this.y[i] * matrice[0][1]);
	        this.y[i] = (x[i] * matrice[1][0]) + (y[i] * matrice[1][1]);
	    }
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
}
