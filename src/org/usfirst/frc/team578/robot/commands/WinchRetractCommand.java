package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchRetractCommand extends Command {

	public static final double BACK_RUN_TIME = 2.5; // seconds
	public static final double BACK_RUN_POWER = .4; // power
	public static boolean BACK_STOPPED = false;

	public static double FRONT_RUN_TIME = 2.5;
	public static double FRONT_RUN_POWER = .4;
	public static boolean FRONT_STOPPED = false;

	public WinchRetractCommand() {
		requires(Robot.winchFrontSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

		if (!FRONT_STOPPED) {
			if (timeSinceInitialized() < FRONT_RUN_TIME) {
				Robot.winchFrontSubsystem.retract(FRONT_RUN_POWER);
			} else {
				Robot.winchFrontSubsystem.stop();
				FRONT_STOPPED = true;
			}
		}

		if (!BACK_STOPPED) {
			if (timeSinceInitialized() < BACK_RUN_TIME) {
				Robot.winchBackSubsystem.retract(BACK_RUN_POWER);
			} else {
				Robot.winchBackSubsystem.stop();
				BACK_STOPPED = true;
			}
		}

	}

	@Override
	protected boolean isFinished() {
		return (FRONT_STOPPED && BACK_STOPPED);
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
