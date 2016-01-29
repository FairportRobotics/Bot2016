package org.usfirst.frc.team578.robot.subsystems;

import org.usfirst.frc.team578.robot.RobotMap;

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
	
	public void initialize(){
		rightMaster= new CANTalon(RobotMap.RIGHT_MASTER);
		rightSlave= new CANTalon(RobotMap.RIGHT_SLAVE);
		leftMaster= new CANTalon(RobotMap.LEFT_MASTER);
		leftSlave= new CANTalon(RobotMap.LEFT_SLAVE);
		
		rightMaster.setSafetyEnabled(true);
	}

}
