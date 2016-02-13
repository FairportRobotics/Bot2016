package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingLowBar extends CommandGroup {

	public AutonomousCrossingLowBar() {

		addSequential(new AutonomousDriveToPitchZero(1, 1));
		addSequential(new AutonomousDriveCommand(1, 1, .173));
		addSequential(new AutonomousTurntoZeroCommand());

	}
}
