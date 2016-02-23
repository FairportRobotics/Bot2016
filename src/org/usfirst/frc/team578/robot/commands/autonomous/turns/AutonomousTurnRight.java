package org.usfirst.frc.team578.robot.commands.autonomous.turns;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnRight extends Command {
	private double error = .25;
	private boolean zeroFound = false;

	// DONE
	public AutonomousTurnRight() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {

		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {

		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 90 - error;
		double MIN_RIGHT_VAL = 90 + error;

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 270 || currentHeading < 90) {
			Robot.driveSubsystem.drive(-.6, .6); // right turn - increase
			// heading

		} else {
			Robot.driveSubsystem.drive(.6, -.6); // left turn - decrease
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