package org.usfirst.frc.team578.robot.commands.autonomous.crossing;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveToPitchZero;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRoughTerrain extends CommandGroup {

	// DONE
	public AutonomousCrossingRoughTerrain() {
		// moves until flat detected [down]
		addSequential(new AutonomousDriveToPitchZero(.5, .5));
		// moves from edge of O.W. to Alignment Line [down]
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));

		addSequential(new AutonomousDriveCommand(1, 1, .6));
		// sets robot yaw to 0 degrees [down]
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));
	}

}
