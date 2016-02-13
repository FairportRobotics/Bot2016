package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousAwayFromGoalRight extends CommandGroup {

	public AutonomousAwayFromGoalRight() {
		addSequential(new AutonomousDriveCommand(1, 1, .47));
		addSequential(new AutonomousTurnto180());
		addSequential(new AutonomousDriveCommand(1, 1, 2));
	}
}