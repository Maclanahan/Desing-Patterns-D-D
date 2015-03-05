package Character;

import java.util.ArrayList;
import java.util.List;

import Item.Armor;
import Item.Weapon;

public class CharacterInventory 
{
	private ArrayList<Item.Slot> items = new ArrayList<Item.Slot>();
	
	public void setItems(List<Item.Slot> list)
	{
		this.items.addAll(list);
	}
	
	//private ArrayList<Armor> armor;
}
