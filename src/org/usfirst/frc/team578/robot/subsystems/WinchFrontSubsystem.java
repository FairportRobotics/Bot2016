package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchFrontSubsystem extends Subsystem {

	private CANTalon winchTalonFront;

	public WinchFrontSubsystem() {

	}

	public void initialize() {
		winchTalonFront = new CANTalon(RobotMap.WINCH_TALON_FRONT);
		winchTalonFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		winchTalonFront.enable();
		// winchTalonFront.set(-.4);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		// setDefaultCommand(new WinchFrontCommand());
	}

	public void extend(double value) {
		winchTalonFront.set(value);
	}

	public void retract(double value) {
		winchTalonFront.set(-value);
	}

	public void stop() {
		winchTalonFront.set(0);
	}
}
