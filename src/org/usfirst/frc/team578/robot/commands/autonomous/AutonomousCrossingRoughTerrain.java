package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRoughTerrain extends CommandGroup {

	public AutonomousCrossingRoughTerrain() {
		// moves until flat detected [down]
		addSequential(new AutonomousDriveToPitchZero(.5, .5));
		// moves from edge of O.W. to Alignment Line [down]
		addSequential(new AutonomousTurnto180());

		addSequential(new AutonomousDriveCommand(.75, .75, .173));
		// sets robot yaw to 0 degrees [down]
		addSequential(new AutonomousTurnto180());
	}

}
