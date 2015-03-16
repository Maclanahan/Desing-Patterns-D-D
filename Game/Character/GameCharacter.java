package Character;

import javafx.scene.shape.Rectangle;

public interface GameCharacter 
{	
	public void execute(GameCharacter $target);
	
	public int attacked();
	
	public int specialed();
	
	public void setActionToAttack();
	
	public void setActionToDefend();
	
	public void setActionToSpecial();
	
	public void setActionToNoAction();

	public void takeDamage(int $damage);

	public int getTotalHitPoints();

	public int getCurrentHealth();
	
	public String getName();
	
	public Stats getStats();
	
	public Action getAction();
	
	public CharacterInventory getInv();

	public void reset();
	
	public Rectangle getImage();
}
