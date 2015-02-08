package Character;

public class Stats 
{
	public int HitPoints;
	public int Strength;
	public int Defence;
	public int Speed;
	public int Intelligence;
	
	//private BaseStats base;
	
	public Stats()
	{
		setDefaultStats();
	}

	private void setDefaultStats() 
	{
		HitPoints = Strength = Defence = Speed = Intelligence = 5;
	}
}
