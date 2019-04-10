import java.util.ArrayList; // We choose ArrayList over Vector because...?
/**
* Use the provided enumerations and code framework to create our workouts class.
* This class should contain all the functionality we need to interact with our workout list.
* Minimize duplication of code by writing helper functions as needed.
* 
* Do not change any of the provided code, although you can, and should, add to it as needed. 
* (E.G. Do not make private attributes public, or change the parameters of a function.)
*/

public class Workouts
{
	// Use the Refactor functionality in Eclipse to rename "muscle" to "Muscle" to match our naming convention.
	public enum Muscle {ABS, BACK, BICEPS, CHEST, FOREARM, GLUTES, LOWERLEG, SHOULDER, TRICEPS, UPPERLEG, NONE} // Why didn't I have to declare this static?
	public enum Equipment {BARBELL, BODYWEIGHT, DUMBBELL, CABLE, HAMMERSTRENGTH}

	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This is a nested class, also known as an inner class. Why do we use a nested class?
	// You will need to create a number of methods for the inner class. You are not limited to
	// only the methods listed inside this class.
	private class Workout
	{
		private String name;
		private Equipment equipment;
		private Muscle primaryMuscle;
		private Muscle secondaryMuscle;
		private String desc;
		private String reminders;
	
		Workout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
		{
			this.name = name;
			this.equipment = equipment;
			this.primaryMuscle = primaryMuscle;
			this.secondaryMuscle = secondaryMuscle;
			this.desc = desc;
			this.reminders = reminders;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public Equipment getEquipment()
		{
			return equipment;
		}

		public void setEquipment(Equipment equipment)
		{
			this.equipment = equipment;
		}

		public Muscle getPrimaryMuscle()
		{
			return primaryMuscle;
		}

		public void setPrimaryMuscle(Muscle primaryMuscle)
		{
			this.primaryMuscle = primaryMuscle;
		}

		public Muscle getSecondaryMuscle()
		{
			return secondaryMuscle;
		}

		public void setSecondaryMuscle(Muscle secondaryMuscle)
		{
			this.secondaryMuscle = secondaryMuscle;
		}

		public String getDesc()
		{
			return desc;
		}

		public void setDesc(String desc)
		{
			this.desc = desc;
		}

		public String getReminders()
		{
			return reminders;
		}

		public void setReminders(String reminders)
		{
			this.reminders = reminders;
		}
		
		// How do we get the name of an enumeration value?
	}

	// This function adds a new workout to the Workouts object.
	public final void addWorkout(String name, Equipment equipment, Muscle primaryMuscle, Muscle secondaryMuscle, String desc, String reminders)
	{
		Workout workout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
		addWorkout(workout);
	}

	// This function adds a workout to the Workouts object.
	public final void addWorkout(Workout workout)
	{
		workoutList.add(workout);
	}
  
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument. The programmer has an option to get
	// Workouts that only have the Muscle in the PrimaryMuscle attribute, or to also look
	// in the secondaryMuscle category.
	public final Workouts getWorkoutsByMuscle(Muscle m, boolean includeSecondary)
	{
		// What is short-circuit evaluation?
		Workouts workoutsByMuscle = new Workouts();
		
		if (includeSecondary)
		{
			for (Workout workout : workoutList)
			{
				for (Muscle primaryMuscle : Muscle.values())
				{
					if ((workout.getPrimaryMuscle() == primaryMuscle) && (workout.getSecondaryMuscle() == Muscle.NONE))
						workoutsByMuscle.workoutList.add(workout);
				}
			}
		}
		else
		{
			for (Workout workout : workoutList)
			{
				for (Muscle primaryMuscle : Muscle.values())
				{
					if (workout.getPrimaryMuscle() == primaryMuscle)
						workoutsByMuscle.workoutList.add(workout);
				}
			}
		}
		
		return workoutsByMuscle;
	}
	
	// This list returns a new Workouts object that contains only the workouts that contain the
	// Equipment value that is provided as an argument.
	public final Workouts getWorkoutsByEquipment(Equipment e)
	{
		ArrayList<Equipment> equipment = new ArrayList<Equipment>();
		equipment.add(e);
		
		return getWorkoutsByEquipment(equipment);
	}
	
	// This returns a new Workouts object that contains only the workouts that contain an Equipment
	// value that is in the provided ArrayList of Equipment.
	public final Workouts getWorkoutsByEquipment(ArrayList<Equipment> e)
	{
		Workouts workoutsByEquip = new Workouts();
		
		for (Equipment equip : e)
		{
			for (Workout workout : workoutList)
			{
				Equipment equipment = workout.getEquipment();
				if (equipment == equip)
					workoutsByEquip.workoutList.add(workout);
			}
		}
		
		return workoutsByEquip;
	}

	// This method returns an ArrayList of Strings. Each String is a name of a workout in our Workouts list.
	public final ArrayList<String> getNames()
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Workout workout : workoutList)
			names.add(workout.getName());
		
		return names;
	}

	// This method returns all the information of the Workouts as an ArrayList of String arrays,
	// one entry in the ArrayList per Workout. The String array should contain the workout's Name,
	// Equipment, Primary and Secondary Muscles, Description, and Reminders. All of these should be strings.
	public final ArrayList<String[]> getFullInformation()
	{
		ArrayList<String[]> fullInfo = new ArrayList<String[]>();
		
		for (int i = 0; i < workoutList.size(); i++)
		{
			String[] workout = new String[6];
			workout[0] = workoutList.get(i).getName();
			workout[1] = workoutList.get(i).getEquipment().name();
			workout[2] = workoutList.get(i).getPrimaryMuscle().name();
			workout[3] = workoutList.get(i).getSecondaryMuscle().name();
			workout[4] = workoutList.get(i).getDesc();
			workout[5] = workoutList.get(i).getReminders();
			
			fullInfo.add(workout);
		}
		
		return fullInfo;
	}
}