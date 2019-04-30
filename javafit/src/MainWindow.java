import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Bonus points: Create an icon (or find a public domain icon). Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow
{

	private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
	private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
	private JComboBox<String> cboType, cboGoal;
	private JSpinner spnDuration;
	private final Workouts workouts;
	private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;

	MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups)
	{
		this.workouts = workouts;
		this.muscleGroups = muscleGroups;
		launchHomeScreen();
	}

	private void launchHomeScreen()
	{
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		JButton upperbody = new JButton("Upper Body Workout");
		JButton lowerbody = new JButton("Lower Body Workout");
		JButton wholebody = new JButton("Whole Body Workout");
		upperbody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("UPPERBODY")));
			}
		});
		lowerbody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("LOWERBODY")));
			}
		});
		wholebody.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.valueOf("WHOLEBODY")));
			}
		});
		panel.add(upperbody);
		panel.add(lowerbody);
		panel.add(wholebody);
		mainFrame.add(panel);
		mainFrame.setSize(600, 400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	// This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
	private void showWorkouts(ArrayList<Config.Muscle> muscles)
	{
		WorkoutsPanel workoutsPanel = new WorkoutsPanel(muscles, workouts);
		selectWorkout.add(workoutsPanel);
		selectWorkout.setSize(600, 400);
		selectWorkout.setLocationRelativeTo(null);
		selectWorkout.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		selectWorkout.setVisible(true);
	}
}