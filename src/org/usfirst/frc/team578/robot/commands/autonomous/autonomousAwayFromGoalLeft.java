package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class autonomousAwayFromGoalLeft extends CommandGroup {

	public autonomousAwayFromGoalLeft() {

		addSequential(new AutonomousDriveCommand(1, 1, .47));
		addSequential(new AutonomousTurnto180());
		addSequential(new AutonomousDriveCommand(1, 1, 2));

	}
}
