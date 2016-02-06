package org.usfirst.frc.team578.robot.commands.autonomous;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousOutputCommand extends Command {

	public double runTime = 1;

	public AutonomousOutputCommand() {
		requires(Robot.intakeSubsystem);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		Robot.intakeSubsystem.spinOutput();
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (timeSinceInitialized() >= runTime || runTime == 0);
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		Robot.intakeSubsystem.spinStop();

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
