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
			scanner.useDelimiter(",");
			//while loop?
			for (int i = 0; i < 5; i++)
			{
				String name = scanner.next();
				Workouts.Equipment equipment = Workouts.Equipment.valueOf(scanner.next());
				Workouts.Muscle primaryMuscle = Workouts.Muscle.valueOf(scanner.next());
				Workouts.Muscle secondaryMuscle = Workouts.Muscle.valueOf(scanner.next());
				String desc = scanner.next();
				String reminders = scanner.next();

				workouts.addWorkout(name, equipment, primaryMuscle, secondaryMuscle, desc, reminders);
			}
			
			scanner.close();

		} catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return workouts;
	}
}
