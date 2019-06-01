package graphics.ui;


import java.awt.event.MouseWheelListener;

import java.awt.event.ActionListener;


import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class View extends JPanel implements ActionListener
{
	protected Object model;
	private Controller controller;

	public View(Object model)
	{
		this.model = model;
		this.controller = defaultController(model);
		this.controller.setView(this);
		this.addMouseListener(this.controller);
		this.addMouseMotionListener(this.controller);
		this.addKeyListener(this.controller);
		this.addMouseWheelListener(this.controller);
		setFocusable(true);
	}

	public void setModel(Object model)
	{
		this.model = model;
		this.controller.setModel(model);
	}

	public Object getModel()
	{
		return this.model;
	}

	public Controller defaultController(Object model)
	{
		return new Controller(model);
	}

	final public Controller getController()
	{
		return this.controller;
	}
}