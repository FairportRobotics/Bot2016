package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousOutputCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnRight;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnTo120;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringRight extends CommandGroup {

	public AutonomousScoringRight() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		addSequential(new AutonomousTurnRight(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));// turn
		// right
		// 90
		// degrees
		addSequential(new AutonomousDriveCommand(1, 1, .86));// forward 6.5 feet
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));// turn
		// left
		// 90
		// degrees
		addSequential(new AutonomousDriveCommand(1, 1, .88));// forward 7.54
																// feet
		addSequential(new AutonomousTurnTo120(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));// turn
		// left
		// 60
		// degrees
		addSequential(new AutonomousDriveCommand(-1, -1, .47));// forward 4 feet
		addSequential(new AutonomousOutputCommand());// shoots out the ball
	}

}
