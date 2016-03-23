package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.RobotMap;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousOutputCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnTo240;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftRallyScoringLeft extends CommandGroup {

	public AutonomousLeftRallyScoringLeft() {

		addSequential(new AutonomousDriveCommand(1, 1, .88)); // forward 7.54 ft
		addSequential(new AutonomousTurnTo240(RobotMap.DEFAULT_LEFT_WHEEL_TURN_SPEED, RobotMap.DEFAULT_RIGHT_WHEEL_TURN_SPEED)); // turn
		// right
		addSequential(new AutonomousDriveCommand(-1, -1, .47)); // forward 4 ft
		addSequential(new AutonomousOutputCommand()); // shoots ball

	}
}
