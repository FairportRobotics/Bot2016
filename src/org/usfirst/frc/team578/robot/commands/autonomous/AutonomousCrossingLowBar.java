package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingLowBar extends CommandGroup {

	public AutonomousCrossingLowBar() {

		addSequential(new AutonomousDriveCommand(1, 1, 1.75));
		addSequential(new AutonomousTurntoZeroCommand());

	}

}
