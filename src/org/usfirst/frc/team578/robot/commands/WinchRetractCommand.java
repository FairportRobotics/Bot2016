package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchRetractCommand extends Command {
	private double time = 4.0;

	public WinchRetractCommand() {
		requires(Robot.winchSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.winchSubsystem.retract();
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
