package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousTurntoZeroCommand extends Command {
	private double error = 2.0;

	public AutonomousTurntoZeroCommand() {
		requires(Robot.driveSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (Robot.navx.getFusedHeading() > 360 - error
				|| Robot.navx.getFusedHeading() < 0 + error) {
			Robot.driveSubsystem.drive(0, 0);
		} else if (Robot.navx.getFusedHeading() <= 360 - error
				&& Robot.navx.getFusedHeading() > 180) {
			Robot.driveSubsystem.drive(1, -1);
		} else {
			Robot.driveSubsystem.drive(-1, 1);
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Robot.navx.getFusedHeading() > 360 - error || Robot.navx
				.getFusedHeading() < 0 + error);
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
