package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.camera.CameraFeeds;
import org.usfirst.frc.team578.robot.commands.DriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousMaster;
import org.usfirst.frc.team578.robot.commands.autonomous.crossing.AutonomousCrossingLowBar;
import org.usfirst.frc.team578.robot.commands.autonomous.crossing.AutonomousCrossingMoat;
import org.usfirst.frc.team578.robot.commands.autonomous.crossing.AutonomousCrossingRamparts;
import org.usfirst.frc.team578.robot.commands.autonomous.crossing.AutonomousCrossingRockWall;
import org.usfirst.frc.team578.robot.commands.autonomous.crossing.AutonomousCrossingRoughTerrain;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.PositionEnum;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.left.AutonomousLeftToLeftRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.left.AutonomousMiddleLeftToLeftRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.left.AutonomousMiddleRightToLeftRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.left.AutonomousMiddleToLeftRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.left.AutonomousRightToLeftRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.right.AutonomousLeftToRightRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.right.AutonomousMiddleLeftToRightRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.right.AutonomousMiddleRightToRightRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.right.AutonomousMiddleToRightRally;
import org.usfirst.frc.team578.robot.commands.autonomous.dualrally.right.AutonomousRightToRightRally;
import org.usfirst.frc.team578.robot.commands.autonomous.scoring.AutonomousAwayFromGoalLeft;
import org.usfirst.frc.team578.robot.commands.autonomous.scoring.AutonomousAwayFromGoalRight;
import org.usfirst.frc.team578.robot.commands.autonomous.scoring.AutonomousScoringLeft;
import org.usfirst.frc.team578.robot.commands.autonomous.scoring.AutonomousScoringNone;
import org.usfirst.frc.team578.robot.commands.autonomous.scoring.AutonomousScoringRight;
import org.usfirst.frc.team578.robot.subsystems.ArmSubsystem;
import org.usfirst.frc.team578.robot.subsystems.BallSensorSubsystem;
import org.usfirst.frc.team578.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team578.robot.subsystems.IntakeSubsystem;
import org.usfirst.frc.team578.robot.subsystems.LoggingSubsystem;
import org.usfirst.frc.team578.robot.subsystems.WinchSubsystem;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SPI;
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
 * resource directory.time
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveSubsystem driveSubsystem;
	public static IntakeSubsystem intakeSubsystem;
	public static WinchSubsystem winchSubsystem;
	public static LoggingSubsystem loggingSubsystem;
	public static ArmSubsystem armSubsystem;
	public static AHRS navx;
	public static BallSensorSubsystem ballSensorSubsystem;
	CameraFeeds cameraFeeds;

	private SendableChooser startingPositionChooser;
	private SendableChooser defenseChooser;
	private SendableChooser scoringPositionChooser;
	private Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {

		loggingSubsystem = new LoggingSubsystem();
		loggingSubsystem.log("robot startup");

		oi = new OI();

		// instantiate the command used for the autonomous period
		driveSubsystem = new DriveSubsystem();
		driveSubsystem.initialize();

		// initialize arm
		armSubsystem = new ArmSubsystem();
		armSubsystem.initialize();

		intakeSubsystem = new IntakeSubsystem();
		intakeSubsystem.initialize();

		winchSubsystem = new WinchSubsystem();
		winchSubsystem.initialize();

		ballSensorSubsystem = new BallSensorSubsystem();
		ballSensorSubsystem.initialize();

		navx = new AHRS(SPI.Port.kMXP);

		cameraFeeds = new CameraFeeds();

		// These need to happen after
		// the subsystems are initialized
		oi.initialize();

		initializeStartingPositionChooser();
		initializeScoringPositionChooser();
		initializeDefenseChooser();
		initializeDelayChooser();
		initializeScoringBackAwayChooser();
	}

	private void initializeDelayChooser() {
		SmartDashboard.putBoolean("beforeDefenseDelay", false);
		SmartDashboard.putBoolean("beforeRallyDelay", false);
		SmartDashboard.putBoolean("beforeScoringDelay", false);

		SmartDashboard.putInt("beforeDefenseDelayValue", 0);
		SmartDashboard.putInt("beforeRallyDelayValue", 0);
		SmartDashboard.putInt("beforeScoringDelayValue", 0);

	}

	private void initializeStartingPositionChooser() {

		startingPositionChooser = new SendableChooser();
		startingPositionChooser.addDefault("1 Left", PositionEnum.LEFT);
		startingPositionChooser.addObject("2 Mid Left", PositionEnum.MIDDLE_LEFT);
		startingPositionChooser.addObject("3 Center", PositionEnum.MIDDLE);
		startingPositionChooser.addObject("4 Mid Right", PositionEnum.MIDDLE_RIGHT);
		startingPositionChooser.addObject("5 Right", PositionEnum.RIGHT);

		SmartDashboard.putData("Starting Position", startingPositionChooser);
	}

	private void initializeDefenseChooser() {

		defenseChooser = new SendableChooser();
		defenseChooser.addDefault("Lowbar", new AutonomousCrossingLowBar());
		defenseChooser.addObject("Moat", new AutonomousCrossingMoat());
		defenseChooser.addObject("Ramparts", new AutonomousCrossingRamparts());
		defenseChooser.addObject("Rock Wall", new AutonomousCrossingRockWall());
		defenseChooser.addObject("Rough Terrain", new AutonomousCrossingRoughTerrain());
		SmartDashboard.putData("Defense Chooser", defenseChooser);
	}

	private void initializeScoringPositionChooser() {

		scoringPositionChooser = new SendableChooser();
		scoringPositionChooser.addDefault("Left", new AutonomousScoringLeft());
		scoringPositionChooser.addObject("Right", new AutonomousScoringRight());
		scoringPositionChooser.addObject("None", new AutonomousScoringNone());
		SmartDashboard.putData("Scoring Position", scoringPositionChooser);

	}

	private void initializeScoringBackAwayChooser() {
		SmartDashboard.putBoolean("backFromGoal", false);

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		navx.zeroYaw();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		Command autoDef = (Command) defenseChooser.getSelected();
		PositionEnum positionEnum = (PositionEnum) startingPositionChooser.getSelected();
		Command autoScore = (Command) scoringPositionChooser.getSelected();
		Command autoBack = null;

		if (SmartDashboard.getBoolean("backFromGoal")) {
			if (autoScore.getClass().getSimpleName().equals("AutonomousScoringLeft")) {
				autoBack = new AutonomousAwayFromGoalLeft();
			} else if (autoScore.getClass().getSimpleName().equals("AutonomousScoringRight")) {
				autoBack = new AutonomousAwayFromGoalRight();
			}
		}

		Integer beforeDefenseDelayValue = SmartDashboard.getInt("beforeDefenseDelayValue", 0);
		Integer beforeRallyDelayValue = SmartDashboard.getInt("beforeRallyDelayValue", 0);
		Integer beforeScoringDelayValue = SmartDashboard.getInt("beforeScoringDelayValue", 0);

		// Default
		Command autoRally = new AutonomousScoringNone();

		if (autoScore.getClass().getSimpleName().equals("AutonomousScoringLeft")) {
			if (positionEnum == PositionEnum.RIGHT) {
				autoRally = new AutonomousRightToLeftRally();
			} else if (positionEnum == PositionEnum.MIDDLE_RIGHT) {
				autoRally = new AutonomousMiddleRightToLeftRally();
			} else if (positionEnum == PositionEnum.MIDDLE) {
				autoRally = new AutonomousMiddleToLeftRally();
			} else if (positionEnum == PositionEnum.MIDDLE_LEFT) {
				autoRally = new AutonomousMiddleLeftToLeftRally();
			} else {
				autoRally = new AutonomousLeftToLeftRally();
			}
		} else if (autoScore.getClass().getSimpleName().equals("AutonomousScoringRight")) {
			if (positionEnum == PositionEnum.RIGHT) {
				autoRally = new AutonomousRightToRightRally();
			} else if (positionEnum == PositionEnum.MIDDLE_RIGHT) {
				autoRally = new AutonomousMiddleRightToRightRally();
			} else if (positionEnum == PositionEnum.MIDDLE) {
				autoRally = new AutonomousMiddleToRightRally();
			} else if (positionEnum == PositionEnum.MIDDLE_LEFT) {
				autoRally = new AutonomousMiddleLeftToRightRally();
			} else {
				autoRally = new AutonomousLeftToRightRally();
			}
		}

		autonomousCommand = new AutonomousMaster(autoDef, autoRally, autoScore, beforeDefenseDelayValue, beforeRallyDelayValue, beforeScoringDelayValue,
				autoBack);

		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("navxConnected", navx.isConnected());

		boolean beforeDefenseDelay = SmartDashboard.getBoolean("beforeDefenseDelay");
		boolean beforeRallyDelay = SmartDashboard.getBoolean("beforeRallyDelay");
		boolean beforeScoringDelay = SmartDashboard.getBoolean("beforeScoringDelay");

		int beforeDefenseDelayValue = SmartDashboard.getInt("beforeDefenseDelayValue");
		int beforeRallyDelayValue = SmartDashboard.getInt("beforeRallyDelayValue");
		int beforeScoringDelayValue = SmartDashboard.getInt("beforeScoringDelayValue");

		if (beforeDefenseDelay) {
			System.err.println("beforeDefenseDelayValue : " + beforeDefenseDelayValue);
		}

		if (beforeRallyDelay) {
			System.err.println("beforeRallyDelay : " + beforeRallyDelayValue);
		}

		if (beforeScoringDelay) {
			System.err.println("beforeScoringDelay : " + beforeScoringDelayValue);
		}

		System.err.println("HEADING : " + navx.getFusedHeading());
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();

		cameraFeeds.init();
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

		cameraFeeds.end();

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		DriveCommand driveCommand = new DriveCommand();
		driveCommand.start();
		Scheduler.getInstance().run();

		cameraFeeds.run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();

	}

}
