package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbWallCommandGroup extends CommandGroup {
	public ClimbWallCommandGroup() {
		addSequential(new TapeOutCommand());
		addSequential(new TapeInCommand());
		addSequential(new WinchRetractCommand());
	}

}
