package org.usfirst.frc.team578.robot.commands.autonomous.turns;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnto180 extends Command {
	private double error = .25;
	private boolean zeroFound = false;

	public AutonomousTurnto180() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {

		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 180 - error;
		double MIN_RIGHT_VAL = 180 + error;

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 0) {
			Robot.driveSubsystem.drive(-.6, .6); // right turn - increase
			// heading

		} else {
			Robot.driveSubsystem.drive(.6, -.6); // left turn - decrease
			// heading
		}

		// TODO Auto-generated method stub
		// if (Robot.navx.getFusedHeading() > 180 - error &&
		// Robot.navx.getFusedHeading() < 180 + error) {
		// Robot.driveSubsystem.drive(0, 0);
		// } else if (Robot.navx.getFusedHeading() < 350) {
		// Robot.driveSubsystem.drive(.25, -.25);
		// } else {
		// Robot.driveSubsystem.drive(-.25, .25);
		// }
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
