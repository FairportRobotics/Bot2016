package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringRight extends CommandGroup {

	public AutonomousScoringRight() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
		addSequential(new AutonomousDriveCommand(1, -1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .76));
		addSequential(new AutonomousDriveCommand(-1, 1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .88));
		addSequential(new AutonomousDriveCommand(-1, 1, .067));
		addSequential(new AutonomousDriveCommand(1, 1, .47));

	}

}
