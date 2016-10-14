package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.ManualTapeCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class TapeSubsystem extends Subsystem {

	private CANTalon tapeTalon;

	public void initialize() {
		tapeTalon = new CANTalon(RobotMap.TAPE_TALON);
		tapeTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		tapeTalon.enable();
	}

	public void forward(double value) {
		tapeTalon.set(value);
	}

	public void backwards(double value) {
		tapeTalon.set(-value);
	}

	public void stop() {
		tapeTalon.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new ManualTapeCommand());
	}

}
