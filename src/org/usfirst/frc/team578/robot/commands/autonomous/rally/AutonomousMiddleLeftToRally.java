package org.usfirst.frc.team578.robot.commands.autonomous.rally;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnRight;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMiddleLeftToRally extends CommandGroup {

	public AutonomousMiddleLeftToRally() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
		addSequential(new AutonomousTurnRight(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));
		addSequential(new AutonomousDriveCommand(1, 1, .68)); // 3 x middle
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));

	}

}
