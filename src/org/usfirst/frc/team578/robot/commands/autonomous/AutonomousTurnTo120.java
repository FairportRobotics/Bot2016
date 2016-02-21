package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnTo120 extends Command {
	private double error = .25;
	private boolean zeroFound = false;

	public AutonomousTurnTo120() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {

		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 120 - error;
		double MIN_RIGHT_VAL = 120 + error;

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 300 || currentHeading < 120) {
			Robot.driveSubsystem.drive(-.6, .6); // right turn - increase
			// heading
		} else {
			Robot.driveSubsystem.drive(.6, -.6); // left turn - decrease
			// heading
		}

		// if ((Robot.navx.getFusedHeading() > (120 - error)) &&
		// (Robot.navx.getFusedHeading() < (120 + error))) {
		// Robot.driveSubsystem.drive(0, 0);
		// } else if ((Robot.navx.getFusedHeading() <= 300)) {
		// Robot.driveSubsystem.drive(1, -1);
		// } else {
		// Robot.driveSubsystem.drive(-1, 1);
		// }
	}

	@Override
	protected boolean isFinished() {
		return zeroFound;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
