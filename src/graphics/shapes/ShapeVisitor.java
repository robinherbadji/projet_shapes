package graphics.shapes;


public interface ShapeVisitor {
	public void visitRectangle(SRectangle rect);
	public void visitCircle(SCircle circle);
	public void visitText(SText text);
	public void visitCollection(SCollection collec);
	public void visitPolygone(SPolygone polygone);
	public void visitImage(SPicture sPicture);
}
