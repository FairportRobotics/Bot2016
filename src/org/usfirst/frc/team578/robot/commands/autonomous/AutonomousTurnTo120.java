package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurnTo120 extends Command {
	private double error = 2.0;

	public AutonomousTurnTo120() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		if ((Robot.navx.getFusedHeading() > (120 - error)) && (Robot.navx.getFusedHeading() < (120 + error))) {
			Robot.driveSubsystem.drive(0, 0);
		} else if ((Robot.navx.getFusedHeading() <= 300)) {
			Robot.driveSubsystem.drive(1, -1);
		} else {
			Robot.driveSubsystem.drive(-1, 1);
		}
	}

	@Override
	protected boolean isFinished() {
		return ((Robot.navx.getFusedHeading() > (120 - error)) && (Robot.navx.getFusedHeading() < (120 + error)));
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}

}
