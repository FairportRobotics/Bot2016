package org.usfirst.frc.team578.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
	
	private CANTalon rightMaster;
	private CANTalon rightSlave;
	private CANTalon leftMaster;
	private CANTalon leftSlave;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
