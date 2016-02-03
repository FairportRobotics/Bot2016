package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousLeftToRally extends CommandGroup {

	public AutonomousLeftToRally() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		addSequential(new AutonomousDriveCommand(1, -1, .1));
		addSequential(new AutonomousDriveCommand(1, 1, 1.066));
		addSequential(new AutonomousDriveCommand(-1, 1, .1));
	}

}
