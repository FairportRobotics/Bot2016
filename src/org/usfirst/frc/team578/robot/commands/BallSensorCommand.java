package org.usfirst.frc.team578.robot.commands;

import org.usfirst.frc.team578.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BallSensorCommand extends Command {

	public BallSensorCommand() {
		requires(Robot.ballSensorSubsystem);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		boolean ballSensor = Robot.ballSensorSubsystem.get();
		SmartDashboard.putBoolean("Ball Sensor", ballSensor);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
