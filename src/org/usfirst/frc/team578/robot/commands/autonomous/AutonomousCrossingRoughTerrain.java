package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRoughTerrain extends CommandGroup {

	public AutonomousCrossingRoughTerrain() {
		// moves until flat detected [down]
		addSequential(new AutonomousDriveToPitchZero(1, 1));
		// moves from edge of O.W. to Alignment Line [down]
		addSequential(new AutonomousDriveCommand(1, 1, .173));
		// sets robot roll to 0 degrees [down]
		addSequential(new AutonomousTurntoZeroCommand());
	}

}
