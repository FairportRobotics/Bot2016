package org.usfirst.frc.team578.robot.commands.autonomous.turns;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnLeft extends Command {
	private double error = .25;
	private boolean zeroFound = false;
	private double leftTurnSpeed;
	private double rightTurnSpeed;

	public AutonomousTurnLeft(double leftTurnSpeed, double rightTurnSpeed) {
		requires(Robot.driveSubsystem);
		this.leftTurnSpeed = leftTurnSpeed;
		this.rightTurnSpeed = rightTurnSpeed;
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

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if ((currentHeading < 275) && (currentHeading > 265)) {
			leftTurnSpeed = .325;
			rightTurnSpeed = .325;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 90 && currentHeading < 270) {
			Robot.driveSubsystem.drive(-leftTurnSpeed, rightTurnSpeed); // right
																		// turn
																		// -
																		// increase
			// heading

		} else {
			Robot.driveSubsystem.drive(leftTurnSpeed, -rightTurnSpeed); // left
																		// turn
																		// -
																		// decrease
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
