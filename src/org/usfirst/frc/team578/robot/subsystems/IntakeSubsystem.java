package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {

	private CANTalon intakeTalon;
	private double intakeScaleFactor = .7;
	private double outputScaleFactor = 1;

	public IntakeSubsystem() {

	}

	public void initialize() {
		intakeTalon = new CANTalon(RobotMap.INTAKE_TALON);
		intakeTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		intakeTalon.enable();
	}

	public void spinIntake() {
		intakeTalon.set(-1 * intakeScaleFactor);
	}

	public void spinOutput() {
		intakeTalon.set(1 * outputScaleFactor);
	}

	public void spinStop() {
		intakeTalon.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
