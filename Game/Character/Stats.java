package Character;

public class Stats {
	public int HitPointsMod;
	public int StrengthMod;
	public int DefenceMod;
	public int SpeedMod;
	public int IntelligenceMod;

	private BaseStats base;

	public int CurrentHitPoints;

	public Stats(BaseStats $base) {
		base = $base;
		CurrentHitPoints = base.HitPoints;
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

	public void takeDamage(int $damage) {
		if ($damage < CurrentHitPoints)
			CurrentHitPoints -= $damage;

		else
			CurrentHitPoints = 0;

	}

	public int getHitPoints() {
		return HitPointsMod + base.HitPoints;
	}

	public void reset() 
	{
		CurrentHitPoints = base.HitPoints;
	}
}
