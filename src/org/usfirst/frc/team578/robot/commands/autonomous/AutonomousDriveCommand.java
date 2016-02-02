package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command {

	public double left;
	public double right;
	public double time;

	public AutonomousDriveCommand(double left, double right, double time) {
		this.left = left;
		this.right = right;
		this.time = time;
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.driveSubsystem.drive(left, right);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (timeSinceInitialized() >= time || time == 0);
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
