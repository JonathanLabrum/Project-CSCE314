import java.util.ArrayList; // We choose ArrayList over Vector because...?

public class Workouts
{

	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
	{
		Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
		workoutList.add(newWorkout);
	}

	public final void addWorkout(Workout workout)
	{
		workoutList.add(workout);
	}

	public final Workouts getWorkoutsByMuscle(Config.Muscle m, boolean includeSecondary)
	{
		Workouts workoutsByMuscle = new Workouts();
		for (Workout w : workoutList)
		{
			if (w.hasPrimaryMuscle(m))
				workoutsByMuscle.addWorkout(w);
			else if (includeSecondary && w.hasSecondaryMuscle(m)) // Why did I put the includeSecondary first?
				workoutsByMuscle.addWorkout(w);
		}
		return workoutsByMuscle;
	}

	public final Workouts getWorkoutsByEquipment(Config.Equipment e)
	{
		Workouts workoutsByEquip = new Workouts();
		for (Workout w : workoutList)
		{
			if (w.hasEquipment(e))
				workoutsByEquip.addWorkout(w);
		}
		return workoutsByEquip;
	}

	public final Workouts getWorkoutsByEquipment(ArrayList<Config.Equipment> e)
	{
		Workouts workoutsByEquip = new Workouts();
		for (Workout w : workoutList)
		{
			if (w.hasEquipment(e))
				workoutsByEquip.addWorkout(w);
		}
		return workoutsByEquip;
	}

	public final ArrayList<String> getNames()
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Workout w : workoutList)
		{
			names.add(w.getName());
		}
		return names;
	}

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