package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveToPitchZero extends Command {

	private int offrampDetections;

	private double left;
	private double right;

	private boolean floorDetected;
	private boolean offrampDetected;

	private static final int ZERO_PITCH_DEADZONE = 2;
	private static final int OFFRAMP_DETECTIONS_REQUIRED = 5;

	public AutonomousDriveToPitchZero(double left, double right) {
		requires(Robot.driveSubsystem);
		this.left = -left;
		this.right = -right;
	}

	@Override
	protected void initialize() {
		floorDetected = false;
		offrampDetected = false;
		offrampDetections = 0;
	}

	@Override
	protected void execute() {
		// System.err.println("Pitch: " + Robot.navx.getPitch());
		System.err.println("floor detected: " + floorDetected);
		System.err.println("offrampDetected: " + offrampDetected);
		// This is a catchall...it should already be set
		// in isFinished()
		if (floorDetected) {
			// Stop the robot when the floor is found
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		// The most likely case
		if (!offrampDetected) {
			// search for offramp

			// keep moving..maybe we'll get to the offramp now
			Robot.driveSubsystem.drive(left, right);

			// Check for offramp
			// if (Robot.navx.getPitch() > (2 * ZERO_PITCH_DEADZONE)) {
			// found a possible offramp point
			// offrampDetections++;
			// } else {
			// if we're facing up, we're not on a down ramp
			// offrampDetections = 0;
			// }

			// We found enough indications that we're on the offramp
			if (offrampDetections > OFFRAMP_DETECTIONS_REQUIRED) {
				offrampDetected = true;
			}
		} else {

			// found the offramp, look for floor
			// if ((Robot.navx.getPitch() > -ZERO_PITCH_DEADZONE) &&
			// (Robot.navx.getPitch() < ZERO_PITCH_DEADZONE)) {
			floorDetected = true;
			Robot.driveSubsystem.drive(0, 0);
			// } else {
			// floor not detected, keep driving
			Robot.driveSubsystem.drive(left, right);
			// }
		}

	}

	// }

	@Override
	protected boolean isFinished() {
		return floorDetected;

	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
