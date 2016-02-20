package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRockWall extends CommandGroup {

	// DONE
	public AutonomousCrossingRockWall() {
		// moves until flat detected [down]
		addSequential(new AutonomousDriveToPitchZero(.3, .3));
		// moves from edge of O.W. to Alignment Line [down]
		// Resets robot to face zero
		addSequential(new AutonomousTurntoZeroCommand());
		addSequential(new AutonomousDriveCommand(.5, .5, 1.2));
		// sets robot yaw to 0 degrees [down]
		addSequential(new AutonomousTurntoZeroCommand());
	}

}
