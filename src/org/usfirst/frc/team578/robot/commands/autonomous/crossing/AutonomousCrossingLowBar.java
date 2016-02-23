package org.usfirst.frc.team578.robot.commands.autonomous.crossing;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveToPitchZero;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingLowBar extends CommandGroup {

	// DONE
	public AutonomousCrossingLowBar() {

		// Moves until flat surface detected
		addSequential(new AutonomousDriveToPitchZero(.5, .5));
		// Moves from the edge of the defense to the Alignment line
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));

		addSequential(new AutonomousDriveCommand(1, 1, .6));
		// Resets robot to face zero
		addSequential(new AutonomousTurntoZeroCommand(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED));

	}
}
