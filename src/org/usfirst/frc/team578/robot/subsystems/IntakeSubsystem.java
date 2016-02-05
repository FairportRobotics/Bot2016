package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private CANTalon intakeTalon;
	private int scaleFactor = 1;

	public IntakeSubsystem() {

	}

	public void initializeIntakeSubsystem() {
		intakeTalon = new CANTalon(RobotMap.INTAKE_TALON);
		intakeTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeTalon.enable();
	}

	public void spinIntake() {
		intakeTalon.set(1 * scaleFactor);
	}

	public void spinOutput() {
		intakeTalon.set(-1 * scaleFactor);
	}

	public void spinStop() {
		intakeTalon.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
