package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRamparts extends CommandGroup {

	public AutonomousCrossingRamparts() {

		// Moves until flat surface detected
		addSequential(new AutonomousDriveToPitchZero(1, 1));
		// Moves from the edge of the defense to the Alignment line
		addSequential(new AutonomousDriveCommand(1, 1, .173));
		// Resets robot to face zero
		addSequential(new AutonomousTurntoZeroCommand());

	}
}
