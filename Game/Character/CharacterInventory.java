package Character;

import java.util.ArrayList;
import java.util.List;

import Item.Armor;
import Item.Weapon;

public class CharacterInventory 
{
	private ArrayList<Item.Slot> items;
	
	public void setItems(List<Item.Slot> items)
	{
		this.items.addAll(items);
	}
	
	//private ArrayList<Armor> armor;
}
