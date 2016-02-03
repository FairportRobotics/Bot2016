package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMiddleToRally extends CommandGroup {

	public AutonomousMiddleToRally() {

		addSequential(new AutonomousDriveCommand(1, -1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, .21317829));
		addSequential(new AutonomousDriveCommand(-1, 1, .1));

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
	}

}
