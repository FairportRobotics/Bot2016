package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCrossingRockWall extends CommandGroup {

	public AutonomousCrossingRockWall(double left, double right, double time) {

		addSequential(new AutonomousDriveCommand(left, right, time));
	}

}
