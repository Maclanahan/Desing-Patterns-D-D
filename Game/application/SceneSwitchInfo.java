package application;

public class SceneSwitchInfo 
{
	private String _sceneToSwitchTo;
	private int _difficulty;
	
	public SceneSwitchInfo(String $sceneToSwitchTo, int $difficulty)
	{
		_sceneToSwitchTo = $sceneToSwitchTo;
		_difficulty = $difficulty;
	}
	
	public String getSceneInfo()
	{
		return _sceneToSwitchTo;
	}
	
	public int getDifficulty()
	{
		return _difficulty;
	}
}
