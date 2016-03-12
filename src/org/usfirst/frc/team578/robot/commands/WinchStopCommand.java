package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchStopCommand extends Command {
	private double time = .5;
	private boolean brakeSet;
	private boolean finished;

	public WinchStopCommand() {
		requires(Robot.winchSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		brakeSet = false;
		finished = false;

	}

	@Override
	protected void execute() {
		if (!brakeSet) {
			Robot.winchSubsystem.initiateBrake();
			brakeSet = true;
		} else {
			if (timeSinceInitialized() > time) {
				Robot.winchSubsystem.unpowerBrake();
				Robot.winchSubsystem.stop();
				finished = true;
			}
		}

	}

	@Override
	protected boolean isFinished() {
		return finished;
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
