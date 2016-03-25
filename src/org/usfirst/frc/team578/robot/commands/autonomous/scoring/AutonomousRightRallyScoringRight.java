package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousOutputCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnTo120;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightRallyScoringRight extends CommandGroup {

	public AutonomousRightRallyScoringRight() {

		addSequential(new AutonomousDriveCommand(1, 1, 1.13));// forward 7.54
																// feet
		addSequential(new AutonomousTurnTo120(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));// turn
		// left
		// 60
		// degrees
		addSequential(new AutonomousDriveCommand(-1, -1, .37));// forward 4 feet
		addSequential(new AutonomousOutputCommand());// shoots out the ball
	}

}
