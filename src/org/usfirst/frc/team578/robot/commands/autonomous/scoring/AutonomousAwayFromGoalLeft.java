package org.usfirst.frc.team578.robot.commands.autonomous.scoring;

import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnto180;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousAwayFromGoalLeft extends CommandGroup {

	public AutonomousAwayFromGoalLeft() {

		addSequential(new AutonomousDriveCommand(1, 1, .47));
		addSequential(new AutonomousTurnto180());
		addSequential(new AutonomousDriveCommand(1, 1, 2));

	}
}
