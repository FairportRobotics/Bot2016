package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TapeInCommand extends Command {

	public static final double RUN_TIME = 2.5; // seconds
	public static final double RUN_POWER = .4; // power
	public static boolean RUN_STOPPED = false;

	public TapeInCommand() {
		requires(Robot.tapeSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if (!RUN_STOPPED) {
			if (timeSinceInitialized() < RUN_TIME) {
				Robot.tapeSubsystem.forward(RUN_POWER);
			} else {
				Robot.tapeSubsystem.stop();
				RUN_STOPPED = true;
			}
		}

	}

	@Override
	protected boolean isFinished() {
		return RUN_STOPPED;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {
	}
}
