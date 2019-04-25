// This file gives access to the underlying datafile and stores the data in the Workout class.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Scanner;

public class FileAccess
{

	public static Workouts loadWorkouts()
	{
		Workouts workouts = new Workouts();

		try
		{
			Scanner scanner = new Scanner(new File(Config.WORKOUTFILE));
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] fields = line.split(",");
				// Check to make sure glen didn't bork the data file.
				if (fields.length != 6)
					System.out.println("Line has " + fields.length + " fields instead of 6. Check your commas.");
				String name = fields[0];
				Config.Equipment equipment = Config.Equipment.valueOf(fields[1]);
				Config.Muscle primaryMuscle = Config.Muscle.valueOf(fields[2]);
				Config.Muscle secondaryMuscle = Config.Muscle.valueOf(fields[3]);
				String desc = fields[4];
				String reminders = fields[5];
				workouts.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
			}
			scanner.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Unable to find workouts file. Is it in the same directory as the executable?\nError:" + e.toString());
		}
		return workouts;
	}

	public static EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> loadFormats()
	{

		EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> enumMap = new EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>>(Config.MuscleGroup.class);

		try
		{
			Scanner scanner = new Scanner(new File(Config.WORKOUTFORMATFILE));
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] fields = line.split(",");
				ArrayList<Config.Muscle> muscleArray = new ArrayList<Config.Muscle>();
				// start at second value and go to the end
				for (int i = 1; i < fields.length; i++)
					muscleArray.add(Config.Muscle.valueOf(fields[i])); // add muscles to array
				enumMap.put(Config.MuscleGroup.valueOf(fields[0]), muscleArray);
			}
			scanner.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Unable to find workout formats file. Is it in the same directory as the executable?\nError:" + e.toString());
		}
		return enumMap;
	}
}
