package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRockWall extends CommandGroup {

	public AutonomousCrossingRockWall() {

		addSequential(new AutonomousDriveCommand(1, 1, 1.75));
		addSequential(new AutonomousTurntoZeroCommand());
	}

}
