package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchSubsystem extends Subsystem {

	private CANTalon winchTalonFront;
	private CANTalon winchTalonBack;
	private Relay winchBrakeRelay1;
	private Relay winchBrakeRelay2;
	private double scaleFactorFront = -1;
	private double scaleFactorBack = -1;

	public WinchSubsystem() {

	}

	public void initialize() {
		winchTalonFront = new CANTalon(RobotMap.WINCH_TALON_FRONT);
		winchTalonFront.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		winchTalonFront.enable();

		winchTalonBack = new CANTalon(RobotMap.WINCH_TALON_BACK);
		winchTalonBack.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		winchTalonBack.enable();

		winchBrakeRelay1 = new Relay(RobotMap.WINCH_BRAKE_RELAY1);
		winchBrakeRelay1.set(Relay.Value.kOn);

		winchBrakeRelay2 = new Relay(RobotMap.WINCH_BRAKE_RELAY2);
		winchBrakeRelay2.set(Relay.Value.kOn);

	}

	@Override
	protected void initDefaultCommand() {

	}

	public void extend() {
		winchTalonFront.set(1 * scaleFactorFront);
		winchTalonBack.set(1 * scaleFactorBack);
	}

	public void retract() {
		winchTalonFront.set(-1 * scaleFactorFront);
		winchTalonBack.set(-1 * scaleFactorBack);
	}

	public void stop() {
		winchBrakeRelay1.set(Relay.Value.kOff);
		winchBrakeRelay2.set(Relay.Value.kOff);
		winchTalonFront.set(0);
		winchTalonBack.set(0);
	}

}
