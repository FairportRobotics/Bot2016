package org.usfirst.frc.team578.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousScoringRight extends CommandGroup {

	public AutonomousScoringRight() {

		// The idea here is to move to a common (known)
		// point on the field and be ready for next phase

		// addSequential(new AutonomousDriveCommand(.5, .5, 5));
		addSequential(new AutonomousTurnRight());// turn right 90
													// degrees
		// addSequential(new AutonomousDriveCommand(0, 0, 0));// stops
		addSequential(new AutonomousDriveCommand(1, 1, .76));// forward 6.5 feet
		addSequential(new AutonomousDriveCommand(0, 0, 0));// stops
		addSequential(new AutonomousTurntoZeroCommand());// turn left 90
															// degrees
		// addSequential(new AutonomousDriveCommand(0, 0, 0));// stops
		addSequential(new AutonomousDriveCommand(1, 1, .88));// forward 7.54
																// feet
		// addSequential(new AutonomousDriveCommand(0, 0, 0));// stops
		addSequential(new AutonomousTurnTo120());// turn left 60
										// degrees
		// addSequential(new AutonomousDriveCommand(0, 0, 0));// stops
		addSequential(new AutonomousDriveCommand(-1, -1, .47));// forward 4 feet
		addSequential(new AutonomousOutputCommand());// shoots out the ball
		// addSequential(new AutonomousDriveCommand(0, 0, 0));// stops

	}

}
