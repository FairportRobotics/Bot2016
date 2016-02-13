package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRamparts extends CommandGroup {

	public AutonomousCrossingRamparts() {

		addSequential(new AutonomousDriveToPitchZero(1, 1));
		addSequential(new AutonomousDriveCommand(1, 1, .173));
		addSequential(new AutonomousTurntoZeroCommand());

	}
}
