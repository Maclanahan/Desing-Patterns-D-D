package Combat;

import java.util.ArrayList;

import Character.GameCharacter;
import Character.PlayerCharacter;

public class Selector 
{
	private ArrayList<TurnStep> _turn = new ArrayList<>();
	
	private ArrayList<CharacterHolder> _characters = new ArrayList<>();
	
	private TurnManager _turnManager;
	
	private TurnStep _currentStep;
	
	public Selector(ArrayList<CharacterHolder> $char)
	{
		_characters = $char;
		
		//_turnManager = $turnManager;
	}
	
	public void setTurnManager(TurnManager $turnManager)
	{
		_turnManager = $turnManager;
	}

	public void beginChoose(TurnStep $step) 
	{
		_currentStep = $step;
		
		setUpSelections();
	}

	private void setUpSelections() 
	{
		for(CharacterHolder ch : _characters)
		{
			ch.setButtonsToUnSelectable();
			ch.setIconToSelectable();
		}
		
		_turnManager.setTurnButtonUnSelectable();
		
	}

	public void setTarget(GameCharacter _char) 
	{
		_currentStep.setTarget(_char);
		
		for(CharacterHolder ch : _characters)
		{
			ch.setButtonsToSelectable();
			ch.setIconToUnselectable();
		}
		
		_turnManager.setTurnButtonSelectable();
	}
}
