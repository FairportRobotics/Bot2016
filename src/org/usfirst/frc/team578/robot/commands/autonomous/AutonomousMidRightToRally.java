package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMidRightToRally extends CommandGroup {

	public AutonomousMidRightToRally() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
		// turn left 90 degrees then move forward 22 inches then turn right 90
		// degrees
		addSequential(new AutonomousDriveCommand(-1, 1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .21));
		addSequential(new AutonomousDriveCommand(1, -1, 1));
	}

}
