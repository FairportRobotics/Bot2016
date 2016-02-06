package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmCommand extends Command {

	public static final double MAX_STOP_BUFFER = 0.3;
	public static final double MIN_STOP_BUFFER = -0.3;

	public ArmCommand() {
		requires(Robot.armSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

		double armJoystickValue = Robot.oi.getArmJoystick();

		if (armJoystickValue > MAX_STOP_BUFFER) {
			// forward
			Robot.armSubsystem.forward(armJoystickValue);

		} else if (armJoystickValue < MIN_STOP_BUFFER) {
			// backwards will negate any value passed to it
			// so we need to make sure the joystick value is positive
			Robot.armSubsystem.backwards(Math.abs(armJoystickValue));

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
}
