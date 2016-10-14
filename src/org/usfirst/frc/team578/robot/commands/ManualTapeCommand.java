package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ManualTapeCommand extends Command {

	public ManualTapeCommand() {
		requires(Robot.tapeSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		double throttle = Robot.oi.getStick();

		if (Math.abs(throttle) > .1) {
			Robot.tapeSubsystem.forward(throttle);
		} else {
			Robot.tapeSubsystem.stop();
		}
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
