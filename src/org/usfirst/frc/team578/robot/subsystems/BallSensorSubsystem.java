package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.BallSensorCommand;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class BallSensorSubsystem extends Subsystem {

	private DigitalInput ballSensor;

	public BallSensorSubsystem() {
	}

	public void initialize() {
		ballSensor = new DigitalInput(RobotMap.BALL_SENSOR);
	}

	public boolean get() {
		return ballSensor.get();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new BallSensorCommand());
	}

}
