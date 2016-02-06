package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem {

	private CANTalon armTalon;
	private double scaleFactor = .25;

	public ArmSubsystem() {
	}

	public void initialize() {
		armTalon = new CANTalon(RobotMap.ARM_TALON);
		armTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		armTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		armTalon.enable();
	}

	public void forward(double value) {
		armTalon.set(value * scaleFactor);
	}

	public void backwards(double value) {
		armTalon.set(-value * scaleFactor);
	}

	public void stop() {
		armTalon.set(0);
	}

	@Override
	protected void initDefaultCommand() {

	}

}