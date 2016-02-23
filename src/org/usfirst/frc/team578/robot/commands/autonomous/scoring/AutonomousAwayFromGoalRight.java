package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnto180;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousAwayFromGoalRight extends CommandGroup {

	public AutonomousAwayFromGoalRight() {
		addSequential(new AutonomousDriveCommand(1, 1, .47));
		addSequential(new AutonomousTurnto180(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));
		addSequential(new AutonomousDriveCommand(1, 1, 2));
	}
}