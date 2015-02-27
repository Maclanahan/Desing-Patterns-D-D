package Character;

public class BaseStats 
{
	public int HitPoints;
	public int Strength;
	public int Defence;
	public int Speed;
	public int Intelligence;
	
	//private BaseStats base;
	
	public BaseStats()
	{
		setDefaultStats();
	}

	private void setDefaultStats() 
	{
		HitPoints = Strength = Defence = Speed = Intelligence = 5;
	}
}
