package org.usfirst.frc.team578.robot.commands.autonomous.turns;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnTo125 extends Command {
	private double error = .25;
	private boolean zeroFound = false;
	private double leftTurnSpeed;
	private double rightTurnSpeed;

	public AutonomousTurnTo125(double leftTurnSpeed, double rightTurnSpeed) {
		requires(Robot.driveSubsystem);
		this.leftTurnSpeed = leftTurnSpeed;
		this.rightTurnSpeed = rightTurnSpeed;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {

		double currentHeading = Robot.navx.getFusedHeading();
		double MIN_LEFT_VAL = 125 - error;
		double MIN_RIGHT_VAL = 125 + error;

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if ((currentHeading < 130) && (currentHeading > 120)) {
			leftTurnSpeed = .325;
			rightTurnSpeed = .325;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 305 || currentHeading < 115) {
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
	}

	@Override
	protected void interrupted() {
	}

}
