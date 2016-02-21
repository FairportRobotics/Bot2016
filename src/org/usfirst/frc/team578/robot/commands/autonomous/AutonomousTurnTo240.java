package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnTo240 extends Command {
	private double error = .25;
	private boolean zeroFound = false;

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {

		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 240 - error;
		double MIN_RIGHT_VAL = 240 + error;

		System.err.println("heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 60 && currentHeading < 240) {
			Robot.driveSubsystem.drive(.4, -.4); // left turn - increase
			// heading
		} else {
			Robot.driveSubsystem.drive(-.4, .4); // right turn - decrease
			// heading
		}
		// // TODO Auto-generated method stub
		// if ((Robot.navx.getFusedHeading() > (240 - error)) &&
		// (Robot.navx.getFusedHeading() < (240 + error))) {
		// Robot.driveSubsystem.drive(0, 0);
		// } else if ((Robot.navx.getFusedHeading() >= (240 + error)) ||
		// (Robot.navx.getFusedHeading() < 60)) {
		// Robot.driveSubsystem.drive(.4, -.4);
		// } else {
		// Robot.driveSubsystem.drive(-.4, .4);
		// }
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
