package graphics.shapes;

public interface ShapeVisitor {
	// Pas de constructeur pour une interface
	public void visitRectangle(SRectangle rect);
	public abstract void visitCircle(SCircle c);
}
