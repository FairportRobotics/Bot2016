package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.DriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingMoat;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingRamparts;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousCrossingRoughTerrain;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousLeftToRally;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousMaster;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousMidRightToRally;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousMiddleLeftToRally;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousMiddleToRally;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousRightToRally;
import org.usfirst.frc.team578.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team578.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team578.robot.subsystems.LoggingSubsystem;
import org.usfirst.frc.team578.robot.subsystems.WinchSubsystem;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
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
	public static IntakeSubsystem intakeSubsystem;
	public static WinchSubsystem winchSubsystem;
	public static LoggingSubsystem loggingSubsystem;
	public static ArmSubsystem armSubsystem;

	private SendableChooser startingPositionChooser;
	private SendableChooser defenseChooser;
	private SendableChooser scoringPositionChooser;
	Command autonomousCommand;

	private Accelerometer accel;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// instantiate the command used for the autonomous period
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.initialize();
		initializeStartingPositionChooser();
		initializeScoringPositionChooser();
		initializeDefenseChooser();

		// initialize arm
		armSubsystem = new ArmSubsystem();
		armSubsystem.initialize();

		intakeSubsystem = new IntakeSubsystem();
		intakeSubsystem.initialize();

		winchSubsystem = new WinchSubsystem();
		winchSubsystem.initialize();

		accel = new BuiltInAccelerometer();
	}

	private void initializeStartingPositionChooser() {

		startingPositionChooser = new SendableChooser();
		startingPositionChooser.addDefault("1 Left",
				new AutonomousLeftToRally());
		startingPositionChooser.addObject("2 Mid Left",
				new AutonomousMiddleLeftToRally());
		startingPositionChooser.addObject("3 Center",
				new AutonomousMiddleToRally());
		startingPositionChooser.addObject("4 Mid Right",
				new AutonomousMidRightToRally());
		startingPositionChooser.addObject("5 Right",
				new AutonomousRightToRally());
		SmartDashboard.putData("Starting Position", startingPositionChooser);
	}

	private void initializeDefenseChooser() {

		defenseChooser = new SendableChooser();
		defenseChooser.addDefault("Lowbar", new Object());
		defenseChooser.addObject("Moat", new AutonomousCrossingMoat());
		defenseChooser.addObject("Ramparts", new AutonomousCrossingRamparts());
		defenseChooser.addObject("Rock Wall", new Object());
		defenseChooser.addObject("Rough Terrain",
				new AutonomousCrossingRoughTerrain());
		SmartDashboard.putData("Defense Chooser", defenseChooser);
	}

	private void initializeScoringPositionChooser() {

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
		Command autoDef = (Command) defenseChooser.getSelected();
		Command autoRally = (Command) startingPositionChooser.getSelected();
		Command autoScore = (Command) scoringPositionChooser.getSelected();
		autonomousCommand = new AutonomousMaster(autoDef, autoRally, autoScore);

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Accel X", accel.getX());
		SmartDashboard.putNumber("Accel Y", accel.getY());
		SmartDashboard.putNumber("Accel Z", accel.getZ());
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
