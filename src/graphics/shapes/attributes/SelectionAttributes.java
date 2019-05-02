package graphics.shapes.attributes;

public class SelectionAttributes extends Attributes 
{
	private String id;
	private boolean selected;
	
	public SelectionAttributes()
	{
		this.id="Selection";
		this.selected=false;
	}
	
	public String getId() 
	{
		return this.id;
	}
	
	public boolean isSelected()
	{
		return this.selected;
	}
	
	public void select()
	{
		this.selected=true;
	}
	
	public void unselect()
	{
		this.selected=false;
	}
	
	public void toggleSelection()
	{
		this.selected=!this.selected;
	}
}
