// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.*;
import java.util.Scanner;

public class FileAccess
{
	public static Workouts loadWorkouts()
	{
		// What is a try/catch block and why do we need one?
		// What is an exception?
		Workouts workouts = new Workouts();
		String file = Config.WORKOUTFILE;

		try
		{
			Scanner scanner = new Scanner(new File(file));
			
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String [] lineSplit = line.split(",");
				String name = lineSplit[0];
				Workouts.Equipment equipment = Workouts.Equipment.valueOf(lineSplit[1]);
				Workouts.Muscle primaryMuscle = Workouts.Muscle.valueOf(lineSplit[2]);
				Workouts.Muscle secondaryMuscle = Workouts.Muscle.valueOf(lineSplit[3]);
				String desc = lineSplit[4];
				String reminders = lineSplit[5];

				workouts.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
			}
			
			scanner.close();

		} catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		}

		return workouts;
	}
}
