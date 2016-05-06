package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchRetractCommand extends Command {

	public static final double BACK_RUN_POWER = .45; // power
	public static double FRONT_RUN_POWER = .4;

	public WinchRetractCommand() {
		requires(Robot.winchFrontSubsystem);
		requires(Robot.winchBackSubsystem);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.winchFrontSubsystem.retract(FRONT_RUN_POWER);
		Robot.winchBackSubsystem.retract(BACK_RUN_POWER);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		Robot.winchBackSubsystem.stop();
		Robot.winchFrontSubsystem.stop();
	}

}
