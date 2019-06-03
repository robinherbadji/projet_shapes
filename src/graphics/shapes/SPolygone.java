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
		Point pointRef = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
		int pointX = (int) pointRef.getX();
		int pointY = (int) pointRef.getY();
		int x[] = { pointX, pointX + 100, pointX + 100, pointX + 50, pointX, pointX };
		int y[] = { pointY, pointY, pointY - 50, pointY - 70, pointY - 50, pointY };
		this.x = x;
		this.y = y;
		this.scale = 1;
	}
	
	public SPolygone(Point pointRef) {
		this.nPoints = 5;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		int pointX = (int) pointRef.getX();
		int pointY = (int) pointRef.getY();
		int x[] = { pointX, pointX + 100, pointX + 100, pointX + 50, pointX, pointX };
		int y[] = { pointY, pointY, pointY - 50, pointY - 70, pointY - 50, pointY };
		this.x = x;
		this.y = y;
		this.scale = 1;
	}

	public SPolygone(String typePolygon) {
		Point pointRef;
		this.scale = 1;
		switch (typePolygon) {
		case "Pentagone":
			this.nPoints = 5;
			this.x = new int[nPoints];
			this.y = new int[nPoints];
			pointRef = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
			int pointX1 = (int) pointRef.getX();
			int pointY1 = (int) pointRef.getY();
			int x1[] = { pointX1, pointX1 + 100, pointX1 + 100, pointX1 + 50, pointX1, pointX1 };
			int y1[] = { pointY1, pointY1, pointY1 - 50, pointY1 - 70, pointY1 - 50, pointY1 };
			this.x = x1;
			this.y = y1;
			System.out.println("Pentagone");
			break;

		case "Triangle":
			this.nPoints = 3;
			this.x = new int[nPoints];
			this.y = new int[nPoints];
			pointRef = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
			int pointX2 = (int) pointRef.getX();
			int pointY2 = (int) pointRef.getY();
			int x2[] = { pointX2, pointX2 + 100, pointX2 + 50, pointX2 };
			int y2[] = { pointY2, pointY2, pointY2 - 50, pointY2 };
			this.x = x2;
			this.y = y2;
			System.out.println("Triangle");
			break;

		case "Losange":
			this.nPoints = 4;
			this.x = new int[nPoints];
			this.y = new int[nPoints];
			pointRef = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
			int pointX3 = (int) pointRef.getX();
			int pointY3 = (int) pointRef.getY();
			int x3[] = { pointX3, pointX3 + 50, pointX3 + 100, pointX3 + 50, pointX3 };
			int y3[] = { pointY3, pointY3 + 110, pointY3, pointY3 - 110, pointY3 };
			this.x = x3;
			this.y = y3;
			System.out.println("Losange");
			
		case "Maison":
			this.nPoints = 5;
			this.x = new int[nPoints];
			this.y = new int[nPoints];
			pointRef = new Point((int) (Math.random() * 280), (int) (Math.random() * 280));
			int pointX = (int) pointRef.getX();
			int pointY = (int) pointRef.getY();
			int x[] = { pointX, pointX + 100, pointX + 100, pointX + 50, pointX, pointX };
			int y[] = { pointY, pointY, pointY - 50, pointY - 70, pointY - 50, pointY };
			this.x = x;
			this.y = y;
			System.out.println("Maison");
			this.scale = 1;
			break;
		default:
			System.out.println("no match");
		}
	}

	public SPolygone(int nPoints, int x[], int y[]) {
		this.scale = 1;
		this.nPoints = nPoints;
		this.x = new int[nPoints];
		this.y = new int[nPoints];
		for (int i = 0; i < nPoints; i++) {
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
		for (int i = 0; i < nPoints; i++) {
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
		for (int i = 0; i < nPoints; i++) {
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

	public double getScale() {
		return this.scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

}
