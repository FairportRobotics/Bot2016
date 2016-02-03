package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.DriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingLowBar;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingMoat;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingRamparts;
import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentITableation. If you change the name of this class or the package
 * after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem driveSubsystem;

	private SendableChooser startingPositionChooser;
	private SendableChooser defenseChooser;
	private SendableChooser scoringPositionChooser;
	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.initialize();
		initializestartingPositionChooser();
	}

	private void initializestartingPositionChooser() {

		startingPositionChooser = new SendableChooser();
		startingPositionChooser.addDefault("1 Left", new Object());
		startingPositionChooser.addObject("2 Mid Left", new Object());
		startingPositionChooser.addObject("3 Center", new Object());
		startingPositionChooser.addObject("4 Mid Right", new Object());
		startingPositionChooser.addObject("5 Right", new Object());
		SmartDashboard.putData("Starting Position", startingPositionChooser);
	}

	private void initalizedefenseChooser() {

		defenseChooser = new SendableChooser();
		defenseChooser.addDefault("Lowbar", new AutonomousCrossingLowBar());
		defenseChooser.addObject("Moat", new AutonomousCrossingMoat());
		defenseChooser.addObject("Ramparts", new AutonomousCrossingRamparts());
		defenseChooser.addObject("Rock Wall", new Object());
		defenseChooser.addObject("Rough Terrain", new Object());
		SmartDashboard.putData("Defense Chooser", defenseChooser);
	}

	private void initalizescoringPositionChooser() {

		scoringPositionChooser = new SendableChooser();
		scoringPositionChooser.addDefault("Left", new Object());
		scoringPositionChooser.addObject("Right", new Object());
		scoringPositionChooser.addObject("None", new Object());
		SmartDashboard.putData("Scoring Position", scoringPositionChooser);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		DriveCommand driveCommand = new DriveCommand();
		driveCommand.start();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();

	}

}
