package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousOutputCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnLeft;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnTo240;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringLeft extends CommandGroup {

	public AutonomousScoringLeft() {

		addSequential(new AutonomousTurnLeft()); // turn left
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, 1, .86)); // forward 6.5 ft
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousTurntoZeroCommand()); // turn right
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, 1, .88)); // forward 7.54 ft
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousTurnTo240()); // turn right
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(-1, -1, .47)); // forward 4 ft
		addSequential(new AutonomousOutputCommand()); // shoots ball
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop

	}
}
