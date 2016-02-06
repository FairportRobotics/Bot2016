package org.usfirst.frc.team578.robot.subsystems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LoggingSubsystem extends Subsystem {

	private BufferedWriter output;
	private boolean Intialized = false;

	public LoggingSubsystem() {

		try {

			output = new BufferedWriter(new FileWriter("/Logs/RobotLog.txt",
					true));
			Intialized = true;

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void log(String message) {
		if (Intialized) {
			try {
				output.write(message);
				output.newLine();
				output.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
