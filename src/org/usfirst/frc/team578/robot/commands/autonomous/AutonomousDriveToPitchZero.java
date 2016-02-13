package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousDriveToPitchZero extends Command {

	private int rampcount;

	private double left;
	private double right;

	private boolean onTheFloor;
	private boolean onTheRamp;

	private static final int PITCHBOUND = 5;
	private static final int PITCHCOUNT = 5;

	public AutonomousDriveToPitchZero(double left, double right) {
		requires(Robot.driveSubsystem);
		this.left = left;
		this.right = right;
	}

	@Override
	protected void initialize() {
		onTheFloor = false;
		onTheRamp = false;
		rampcount = 0;
	}

	@Override
	protected void execute() {

		if (!onTheFloor) {
			if (onTheRamp) {
				if ((Robot.navx.getPitch() > -PITCHBOUND)
						&& (Robot.navx.getPitch() < PITCHBOUND)) {
					onTheFloor = true;
					Robot.driveSubsystem.drive(0, 0);
				} else {
					Robot.driveSubsystem.drive(left, right);
				}
			} else {
				Robot.driveSubsystem.drive(left, right);
				if (Robot.navx.getPitch() < -PITCHBOUND) {
					rampcount++;
				} else {
					rampcount = 0;
				}
				if (rampcount > PITCHCOUNT) {
					onTheRamp = true;
				}
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return onTheFloor;

	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
