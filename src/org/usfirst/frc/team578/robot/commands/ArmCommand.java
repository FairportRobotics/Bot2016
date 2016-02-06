package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmCommand extends Command {

	public ArmCommand() {
		requires(Robot.armSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

		double leftJoystickValue = Robot.oi.getLeft();

		double maxStopBuffer = .3;
		double minStopBuffer = -.3;

		if (leftJoystickValue > maxStopBuffer) {
			// forward
			Robot.armSubsystem.forward(leftJoystickValue);

		} else if (leftJoystickValue < minStopBuffer) {
			// backwards will negate any value passed to it
			// so we need to make sure the joystick value is positivez
			Robot.armSubsystem.backwards(Math.abs(leftJoystickValue));

		} else {
			// stop
			Robot.armSubsystem.stop();

		}

	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

	public static void main(String[] args) {

	}

}
