package Combat;

import javafx.scene.shape.Rectangle;

public interface Command 
{
	public void execute();
	
	public void setCommand();
	
	public Rectangle getButton();
	
	public void setToUnselectable();
	
	public void setToSelectable();
}
