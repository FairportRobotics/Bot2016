package org.usfirst.frc.team578.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ClimbWallCommandGroup extends CommandGroup {
	public ClimbWallCommandGroup() {
		addSequential(new TapeOutCommand());
		addSequential(new TapeInCommand());

		// use for grapple arm and comment out tapeoutcommand and tapeincommand
		// addSequential(new GrappleArmOutCommand());
		// addSequential(new GrappleArmInCommand());

		addSequential(new WinchRetractCommand());

	}

}
