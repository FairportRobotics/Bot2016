package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchExtendCommand extends Command {

	private double time = 4.0;

	public WinchExtendCommand() {
		requires(Robot.winchSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		Robot.winchSubsystem.extend();

	}

	@Override
	protected boolean isFinished() {
		return (timeSinceInitialized() >= time);

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
