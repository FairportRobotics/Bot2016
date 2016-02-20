package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRamparts extends CommandGroup {

	// DONE
	public AutonomousCrossingRamparts() {

		// Moves until flat surface detected
		addSequential(new AutonomousDriveToPitchZero(.5, .5));

		addSequential(new AutonomousTurntoZeroCommand());

		// Moves from the edge of the defense to the Alignment line
		addSequential(new AutonomousDriveCommand(.5, .5, 1.2));
		// Resets robot to face zero
		addSequential(new AutonomousTurntoZeroCommand());

	}
}
