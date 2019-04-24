import java.util.ArrayList;

public class Workout
{
	private String name;
	private Config.Equipment equipment;
	private Config.Muscle primaryMuscle;
	private Config.Muscle secondaryMuscle;
	private String desc;
	private String reminders;

	Workout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
	{
		this.name = name;
		this.equipment = equipment;
		this.primaryMuscle = primaryMuscle;
		this.secondaryMuscle = secondaryMuscle;
		this.desc = desc;
		this.reminders = reminders;
	}

	protected boolean hasEquipment(Config.Equipment e) { return equipment == e; }
	protected boolean hasEquipment(ArrayList<Config.Equipment> equipmentList)
	{
		for (Config.Equipment e : equipmentList)
		{// This is a ForEach, and uses an iterator in the background to loop through the collection.
			if (hasEquipment(e))
				return true;
		}
		return false;
	}
	
	protected boolean hasPrimaryMuscle(Config.Muscle m) { return primaryMuscle == m; }
	protected boolean hasSecondaryMuscle(Config.Muscle m) { return secondaryMuscle == m; }
	protected boolean hasPrimaryMuscle(ArrayList<Config.Muscle> muscleList)
	{
		for (Config.Muscle m : muscleList)
		{
			if (hasPrimaryMuscle(m))
				return true;
		}
		return false;
	}
	protected boolean hasSecondaryMuscle(ArrayList<Config.Muscle> muscleList)
	{
		for (Config.Muscle m : muscleList)
		{
			if (hasSecondaryMuscle(m))
				return true;
		}
		return false;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Config.Equipment getEquipment() { return equipment; }

	public void setEquipment(Config.Equipment equipment) { this.equipment = equipment; }
	
	public Config.Muscle getPrimaryMuscle() { return primaryMuscle; }

	public void setPrimaryMuscle(Config.Muscle primaryMuscle) { this.primaryMuscle = primaryMuscle; }

	public Config.Muscle getSecondaryMuscle() { return secondaryMuscle; }

	public void setSecondaryMuscle(Config.Muscle secondaryMuscle) { this.secondaryMuscle = secondaryMuscle; }

	public String getDesc() { return desc; }

	public void setDesc(String desc) { this.desc = desc; }

	public String getReminders() { return reminders; }

	public void setReminders(String reminders) { this.reminders = reminders; }
}