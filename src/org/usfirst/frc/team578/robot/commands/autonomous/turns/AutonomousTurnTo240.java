package org.usfirst.frc.team578.robot.commands.autonomous.turns;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnTo240 extends Command {
	private double error = .25;
	private boolean zeroFound = false;
	private double leftTurnSpeed;
	private double rightTurnSpeed;

	public AutonomousTurnTo240(double leftTurnSpeed, double rightTurnSpeed) {
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
		double MIN_LEFT_VAL = 240 - error;
		double MIN_RIGHT_VAL = 240 + error;

		System.err.println(this.getName() + " :heading : " + currentHeading + " : " + zeroFound);

		if (zeroFound) {
			Robot.driveSubsystem.drive(0, 0);
			return;
		}

		if ((currentHeading < 245) && (currentHeading > 235)) {
			leftTurnSpeed = .325;
			rightTurnSpeed = .325;
		}

		if (currentHeading > MIN_LEFT_VAL && currentHeading < MIN_RIGHT_VAL) {
			Robot.driveSubsystem.drive(0, 0);
			zeroFound = true;

		} else if (currentHeading > 60 && currentHeading < 240) {
			Robot.driveSubsystem.drive(leftTurnSpeed, -rightTurnSpeed); // left
																		// turn
																		// -
																		// increase
			// heading
		} else {
			Robot.driveSubsystem.drive(-leftTurnSpeed, rightTurnSpeed); // right
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
