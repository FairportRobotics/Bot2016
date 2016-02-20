package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingMoat extends CommandGroup {

	// DONE
	public AutonomousCrossingMoat() {

		// Moves until flat surface detected
		addSequential(new AutonomousDriveToPitchZero(.6, .6));
		// Moves from the edge of the defense to the Alignment line
		addSequential(new AutonomousTurntoZeroCommand());
		addSequential(new AutonomousDriveCommand(.5, .5, 1.2));
		// Resets robot to face zero
		addSequential(new AutonomousTurntoZeroCommand());

	}
}
