package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

	private CANTalon winchTalon;

	public WinchSubsystem() {

	}

	public void initializeWinchSubsystem() {
		winchTalon = new CANTalon(RobotMap.WINCH_TALON);
		winchTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		winchTalon.enable();
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
