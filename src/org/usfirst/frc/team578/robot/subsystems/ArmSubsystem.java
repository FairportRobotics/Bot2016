package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.Robot;
import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.ArmCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem {

	private CANTalon armTalon;
	private double scaleFactor = .4;

	public ArmSubsystem() {
	}

	public void initialize() {
		armTalon = new CANTalon(RobotMap.ARM_TALON);
		armTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		armTalon.ConfigFwdLimitSwitchNormallyOpen(false);
		armTalon.ConfigRevLimitSwitchNormallyOpen(true);
		armTalon.enable();

	}

	public void forward(double value) {
		armTalon.set(-value * scaleFactor);
	}

	public void backwards(double value) {
		if (Robot.oi.getHighSpeed()) {
			armTalon.set(value);
		} else {
			armTalon.set(value * scaleFactor);
		}
	}

	public void stop() {
		armTalon.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ArmCommand());

	}

}
