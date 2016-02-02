package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRoughTerrain extends CommandGroup {

	public AutonomousCrossingRoughTerrain(double left, double right, double time) {

		addSequential(new AutonomousDriveCommand(left, right, time));
	}

}
