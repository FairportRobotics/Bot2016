package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GrappleArmOutCommand extends Command {

	public static final double RUN_TIME_1 = .75; // seconds
	public static final double RUN_POWER_1 = 1; // power
	public static final double RUN_TIME_2 = .75; // seconds
	public static final double RUN_POWER_2 = 1; // power
	public static boolean RUN_STOPPED = false;

	public GrappleArmOutCommand() {
		requires(Robot.tapeSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

		if (!RUN_STOPPED) {
			if (timeSinceInitialized() < RUN_TIME_1) {
				Robot.tapeSubsystem.forward(RUN_POWER_1);
			} else {
				// second phase
				if (timeSinceInitialized() < (RUN_TIME_1 + RUN_TIME_2)) {
					Robot.tapeSubsystem.forward(RUN_POWER_2);
				} else {
					Robot.tapeSubsystem.stop();
					RUN_STOPPED = true;
				}
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
