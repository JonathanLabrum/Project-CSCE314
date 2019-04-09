// Write code to load the workouts from the provided workouts.csv file. The function should return a Workouts object.
import java.io.*;

public class FileAccess
{
	public static Workouts loadWorkouts()
	{
		// What is a try/catch block and why do we need one?
		// What is an exception?
		Workouts workouts = new Workouts();
		File file = new File(Config.WORKOUTFILE);
		try
		{
			
		}
		catch (IOException e)
		{
			
		}
		return workouts;
	}
}
