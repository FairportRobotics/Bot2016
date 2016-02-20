package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRoughTerrain extends CommandGroup {

	// DONE
	public AutonomousCrossingRoughTerrain() {
		// moves until flat detected [down]
		addSequential(new AutonomousDriveToPitchZero(.5, .5));
		// moves from edge of O.W. to Alignment Line [down]
		addSequential(new AutonomousTurntoZeroCommand());

		addSequential(new AutonomousDriveCommand(.5, .5, 1.2));
		// sets robot yaw to 0 degrees [down]
		addSequential(new AutonomousTurntoZeroCommand());
	}

}
