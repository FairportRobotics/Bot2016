package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousMaster extends CommandGroup {

	public AutonomousMaster(Command crossing, Command movingToRally, Command scoring, Integer beforeDefenseDelayValue, Integer beforeRallyDelayValue,
			Integer beforeScoringDelayValue, Command autoBack) {

		// Just stop doing anything
		addSequential(new AutonomousDriveCommand(0, 0, beforeDefenseDelayValue));

		addSequential(crossing);

		addSequential(new AutonomousDriveCommand(0, 0, beforeRallyDelayValue));

		addSequential(movingToRally);

		addSequential(new AutonomousDriveCommand(0, 0, beforeScoringDelayValue));

		addSequential(scoring);

		// addSequential(autoBack);
	}
}
