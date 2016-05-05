package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TapeOutCommand extends Command {

	public static final double RUN_POWER = .2;

	public TapeOutCommand() {
		requires(Robot.tapeSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.tapeSubsystem.backwards(RUN_POWER);
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
		Robot.tapeSubsystem.stop();
	}
}
