package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveCommand extends Command {

	public DriveCommand() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub

		double leftJoystickValue = Robot.oi.getLeft();
		double rightJoystickValue = Robot.oi.getRight();

		Robot.driveSubsystem.drive(leftJoystickValue, rightJoystickValue);

		// System.out.println("pitch : " + Robot.navx.getPitch());

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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
