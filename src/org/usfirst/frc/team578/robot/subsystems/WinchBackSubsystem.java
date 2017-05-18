package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchBackSubsystem extends Subsystem {

	private CANTalon winchTalonBack;

	public WinchBackSubsystem() {

	}

	public void initialize() {

		winchTalonBack = new CANTalon(RobotMap.WINCH_TALON_BACK);
		winchTalonBack.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		winchTalonBack.enable();
		// winchTalonBack.set(.4);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		// setDefaultCommand(new WinchBackCommand());
	}

	public void extend(double value) {

		winchTalonBack.set(-value);
	}

	public void retract(double value) {
		winchTalonBack.set(value);
	}

	public void stop() {
		winchTalonBack.set(0);
	}

}
