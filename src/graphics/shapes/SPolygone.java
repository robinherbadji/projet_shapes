package graphics.shapes;

import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;


public class SPolygone extends Shape {
	public int nPoints;
	public int x[];
	public int y[];
	private double scale;
	
	public SPolygone() {
		this.nPoints = 5;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		Point pointRef = new Point((int)(Math.random() * 280), (int)(Math.random() * 280));
		int pointX= (int) pointRef.getX();
		int pointY= (int) pointRef.getY();
		int x[] = {pointX, pointX+100, pointX+100, pointX+50, pointX, pointX};
		int y[] = {pointY, pointY, pointY-50, pointY-70, pointY-50, pointY};
		this.x = x;
		this.y = y;
		this.scale = 1;
	}
	
	public SPolygone(int nPoints, int x[], int y[]) {
		
		this.nPoints = nPoints;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		for(int i = 0; i < nPoints; i++) {
			this.x[i] = x[i];
			this.y[i] = y[i];
			this.scale = 1;
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
	/*
	//Somme des triangle définies par chaques points
	 public double aire() {
		 
		    double sum = 0;
		    for (int i = 0; i < nPoints-1; ++i) {
		        sum += (this.x[i] * this.y[i+1]) - (this.x[i+1] * this.y[i]);
		    }
		    double area = Math.abs(sum / 2);
		    System.out.println("Polygone area: " + area);
		    return area;
	    }
	 
	 // Barycentre du polygone
	 
	 public Point barycentre() {
	        int x = 0;
	        int y = 0;
	        double bary =0;
	        
	        final double k = 1 / (6 * aire());
	        for (int i = 0; i < nPoints-1; ++i) {
	            bary =  this.x[i+1] * this.y[i] - this.x[i] * this.y[i+1];
	            x += ((this.x[i] + this.x[i+1]) * bary);
	            y += ((this.y[i] + this.y[i+1]) * bary);
	        }
	        Point barycentre = new Point((int) (k * x), (int) (k * y));
	        System.out.println("xbary: "+barycentre.getX() +", ybary: "+barycentre.getY());
	        return barycentre;
	    }
	 public void setDistanceBarycentre(int dx, int dy) {
		 
		 int xabs = this.x[0] + (int) Math.abs( (this.getLoc().x - barycentre().getX()) );
		 int yabs = this.y[0] + (int) Math.abs( (this.getLoc().y - barycentre().getY()) );
		 
		 this.setLoc( new Point( xabs + dx , yabs + dy ) );
	 }
	 */
	
	public double getScale() {
		return this.scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}


}
