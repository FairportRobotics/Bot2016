package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnLeft extends Command {
	private double error = .25;
	private boolean zeroFound = false;

	public AutonomousTurnLeft() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 270 - error;
		double MIN_RIGHT_VAL = 270 + error;

		System.err.println("heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 90 && currentHeading < 270) {
			Robot.driveSubsystem.drive(-.4, .4); // right turn - increase
			// heading

		} else {
			Robot.driveSubsystem.drive(.4, -.4); // left turn - decrease
			// heading
		}
	}

	@Override
	protected boolean isFinished() {
		return zeroFound;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
