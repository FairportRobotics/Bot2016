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

	public void initialize() {
		rightMaster = new CANTalon(RobotMap.RIGHT_MASTER);
		rightSlave = new CANTalon(RobotMap.RIGHT_SLAVE);
		leftMaster = new CANTalon(RobotMap.LEFT_MASTER);
		leftSlave = new CANTalon(RobotMap.LEFT_SLAVE);

		rightMaster.setSafetyEnabled(false);
		rightSlave.setSafetyEnabled(false);
		leftMaster.setSafetyEnabled(false);
		leftSlave.setSafetyEnabled(false);

		rightMaster.setExpiration(.25);
		// rightSlave.setExpiration(.25);
		leftMaster.setExpiration(.25);
		// leftSlave.setExpiration(.25);

		rightMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		leftMaster.changeControlMode(CANTalon.TalonControlMode.PercentVbus);

		rightSlave.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftSlave.changeControlMode(CANTalon.TalonControlMode.Follower);

		leftMaster.enableControl();
		leftSlave.enableControl();
		rightMaster.enableControl();
		rightSlave.enableControl();

		rightSlave.set(RobotMap.RIGHT_MASTER);
		leftSlave.set(RobotMap.LEFT_MASTER);

		rightMaster.set(0);
		leftMaster.set(0);
	}

	public void drive(double left, double right) {

		leftMaster.set(left);
		rightMaster.set(right);

	}

}
