package graphics.shapes.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.shapes.SCollection;

public abstract class ShapeActionListener implements ActionListener {

	private ShapesView sview ;
	private SCollection model ;
	
	public void setView(ShapesView view) {
		this.sview = view ;
	}
	
	public ShapesView getView() {
		return this.sview ;
	}
	
	public void setModel(SCollection model) {
		this.model = model ;
	}
	
	public SCollection getModel() {
		return this.model ;
	}
	
	public abstract void actionPerformed(ActionEvent arg0) ;

}
