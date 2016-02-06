package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringLeft extends CommandGroup {

	public AutonomousScoringLeft() {

		addSequential(new AutonomousDriveCommand(-1, 1, .1)); // turn left
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, 1, .76)); // forward 6.5 ft
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, -1, .1)); // turn right
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, 1, .88)); // forward 7.54 ft
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, -1, .067)); // turn right
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop
		addSequential(new AutonomousDriveCommand(1, 1, .47)); // forward 4 ft
		addSequential(new AutonomousOutputCommand());// shoots ball
		addSequential(new AutonomousDriveCommand(0, 0, .1)); // stop

	}
}
