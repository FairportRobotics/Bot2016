package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveCommand extends Command {

	public double left;
	public double right;
	public double time;

	public AutonomousDriveCommand(double left, double right, double time) {
		requires(Robot.driveSubsystem);
		this.left = -left;
		this.right = -right;
		this.time = time;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		Robot.driveSubsystem.drive(left, right);
	}

	@Override
	protected boolean isFinished() {
		return (timeSinceInitialized() >= time || time == 0);
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
