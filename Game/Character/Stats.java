package Character;

public class Stats {
	private int HitPointsMod;
	private int StrengthMod;
	private int DefenceMod;
	private int SpeedMod;
	private int IntelligenceMod;

	private BaseStats base;

	public int CurrentHitPoints;

	public Stats(BaseStats $base) {
		base = $base;
		CurrentHitPoints = base.HitPoints + HitPointsMod;
	}

	private void setDefaultStats() {
		HitPointsMod = StrengthMod = DefenceMod = SpeedMod = IntelligenceMod = 0;
	}

	public int getStrength() {
		return base.Strength + StrengthMod;
	}

	public int getDefense() {
		return base.Defence + DefenceMod;
	}

	public int getSpeed() {
		return base.Speed + SpeedMod;
	}

	public int getIntelligence() {
		return base.Intelligence + IntelligenceMod;
	}
	
	public void setStrength(int $mod) {
		StrengthMod = $mod;
	}

	public void setDefense(int $mod) {
		DefenceMod = $mod;
	}

	public void setSpeed(int $mod) {
		SpeedMod = $mod;
	}

	public void setIntelligence(int $mod) {
		IntelligenceMod = $mod;
	}

	public void takeDamage(int $damage) {
		if ($damage < CurrentHitPoints)
			CurrentHitPoints -= $damage;

		else
			CurrentHitPoints = 0;

	}

	public int getHitPoints() {
		return HitPointsMod + base.HitPoints;
	}
	
	public void setHitPoints(int $mod)
	{
		HitPointsMod = $mod;
		CurrentHitPoints = base.HitPoints + HitPointsMod;
	}

	public void reset() 
	{
		CurrentHitPoints = base.HitPoints + HitPointsMod;
	}
}
