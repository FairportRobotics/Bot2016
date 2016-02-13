package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMiddleLeftToRally extends CommandGroup {

	public AutonomousMiddleLeftToRally() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
		addSequential(new AutonomousTurnRight());
		addSequential(new AutonomousDriveCommand(1, 1, .8));
		addSequential(new AutonomousTurntoZeroCommand());

	}

}
