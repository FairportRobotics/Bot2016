package org.usfirst.frc.team578.robot.commands.autonomous.rally;

import org.usfirst.frc.team578.robot.commands.autonomous.AutonomousDriveCommand;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurnLeft;
import org.usfirst.frc.team578.robot.commands.autonomous.turns.AutonomousTurntoZeroCommand;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousRightToRally extends CommandGroup {

	public AutonomousRightToRally() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5)
		addSequential(new AutonomousTurnLeft());
		addSequential(new AutonomousDriveCommand(1, 1, .68)); // 3 x middle
		addSequential(new AutonomousTurntoZeroCommand());
	}

}
