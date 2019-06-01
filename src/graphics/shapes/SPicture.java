package graphics.shapes;

import javax.imageio.ImageIO;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SPicture extends Shape {

	private BufferedImage picture;
	private Point point;
	private float rotation;
	private String path;
	
	public SPicture(Point point, String path) {
		this.point = point;
		this.setPath(path);
		try {
			if(path.startsWith("http")) {
				/*
				URL url = new URL(path);
				URLConnection urlc = url.openConnection();
				HttpURLConnection httpURLCon = (HttpURLConnection) urlc;
				httpURLCon.addRequestProperty("User-Agent", "Mozilla/4.76");
				if( (ImageIO.read(httpURLCon.getInputStream())) != null){
					this.picture = (ImageIO.read(httpURLCon.getInputStream()));
					*/
				
				} else {
				this.picture = ImageIO.read(new File(path));
			}
			
		} catch (IOException e) {
			
			System.out.println("Erreur : Aucun path trouvé");
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

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setScale(double zoom) {
		this.picture = scale(this.picture, zoom);
	}
	
	public static BufferedImage scale(BufferedImage bImage, double factor) {
		
        int destWidth=(int) (bImage.getWidth() * factor);
        int destHeight=(int) (bImage.getHeight() * factor);
        //créer l'image de destination
        GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        BufferedImage bImageNew = configuration.createCompatibleImage(destWidth, destHeight);
        Graphics2D graphics = bImageNew.createGraphics();
        graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR);
        //dessiner l'image de destination
        graphics.drawImage(bImage, 0, 0, destWidth, destHeight, 0, 0, bImage.getWidth(), bImage.getHeight(), null);
        graphics.dispose();
 
        return bImageNew;
    }
	
}

