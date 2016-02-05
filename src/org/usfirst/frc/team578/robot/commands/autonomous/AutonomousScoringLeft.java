package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringLeft extends CommandGroup {

	public AutonomousScoringLeft() {

		addSequential(new AutonomousDriveCommand(-1, 1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .76));
		addSequential(new AutonomousDriveCommand(1, -1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .88));
		addSequential(new AutonomousDriveCommand(1, -1, .067));
		addSequential(new AutonomousDriveCommand(1, 1, .47));

	}

}
