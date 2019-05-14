package graphics.shapes;
import javax.imageio.ImageIO;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SPicture extends Shape {

	private BufferedImage picture;
	private Point point;
	
	public SPicture(Point point, String path) {
		this.point = point;
		try {
			this.picture = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Point getLoc() {
		return this.point;
	}

	@Override
	public void setLoc(Point point) {
		this.point = point;
		
	}

	@Override
	public void translate(int dx, int dy) {
		Point point = this.point;
		point.x += dx;
		point.y += dy;
		this.setLoc(point);
		
	}

	@Override
	public Rectangle getBounds() {
		int width = this.picture.getWidth();
		int height = this.picture.getHeight();
		return new Rectangle(this.point.x, this.point.y , width, height);
	}
	
	public void accept(ShapeVisitor sVisitor) {
		sVisitor.visitImage(this);
	}
	
	
}
