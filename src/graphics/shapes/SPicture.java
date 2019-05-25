package graphics.shapes;

import javax.imageio.ImageIO;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class SPicture extends Shape {

	private BufferedImage picture;
	private Point point;
	private float rotation;
	
	public SPicture(Point point, String path) {
		this.point = point;
		try {
			if(path.startsWith("http")) {
				URL url = new URL(path);
				URLConnection urlc = url.openConnection();
				HttpURLConnection httpURLCon = (HttpURLConnection) urlc;
				httpURLCon.addRequestProperty("User-Agent", "Mozilla/4.76");
				this.picture = ImageIO.read(httpURLCon.getInputStream());
			}
			else {
				this.picture = ImageIO.read(new File(path));
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public BufferedImage getPicture() {
		return this.picture;
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

	@Override
	public float getRotation() {
		return this.rotation;
	}

	@Override
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
	
}

