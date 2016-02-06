package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMaster extends CommandGroup {

	public AutonomousMaster(Command crossing, Command movingToRally, Command scoring) {

		addSequential(crossing);
		addSequential(movingToRally);
		addSequential(scoring);
	}
}
