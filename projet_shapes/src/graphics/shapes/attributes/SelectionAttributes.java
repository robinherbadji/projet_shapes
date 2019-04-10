
package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes {

	private static final String ID = "SelectionAttributes";
	private boolean selected;
	
	public SelectionAttributes() {
		this.selected = false;
	}
	
	public String getId() {
		return ID;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public void select() {
		this.selected = true;
	}
	
	public void unselect() {
		this.selected = false;
	}
	
	public void toggleSelection(){
		this.selected = ! selected;
	}
}

