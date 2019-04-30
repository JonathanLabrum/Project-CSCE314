import java.util.ArrayList;

public class Workouts
{

	private final ArrayList<Workout> workoutList = new ArrayList<Workout>();

	// This should return the number of workouts in the class.
	public final int size()
	{
		return workoutList.size();
	}

	public final void addWorkout(String name, Config.Equipment equipment, Config.Muscle primaryMuscle, Config.Muscle secondaryMuscle, String desc, String reminders)
	{
		Workout newWorkout = new Workout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
		workoutList.add(newWorkout);
	}

	public final void addWorkout(Workout workout)
	{
		workoutList.add(workout);
	}

	// This should return an instance of the workout class that matches the index in the workoutList.
	public final Workout getWorkout(int index)
	{
		return workoutList.get(index);
	}

	// This should return the equipment of the workout at the given index.
	public final String getWorkoutEquipment(int index)
	{
		Workout workout = getWorkout(index);
		return workout.getEquipment().name();
	}

	// This searches through the list of workouts in the class and returns the index of the workout with that name.
	public final int findWorkoutByName(String name)
	{
		int counter = 0;
		for (Workout workout : workoutList)
		{
			if (name.equals(workout.getName()))
				return counter;
			counter++;
		}
		return -1;
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

	// This should function just like the getWorkoutsByEquipment equivalent.
	public final Workouts getWorkoutsByMuscle(ArrayList<Config.Muscle> m, boolean includeSecondary)
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

	public final ArrayList<String> getNames()
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Workout w : workoutList)
		{
			names.add(w.getName());
		}
		return names;
	}

	// This should function just like the getNames equivalent.
	public final ArrayList<String> getEquipment()
	{
		ArrayList<String> equip = new ArrayList<String>();
		for (Workout w : workoutList)
		{
			if (!equip.contains(w.getEquipment().name()))
					equip.add(w.getEquipment().name());
		}
		return equip;
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