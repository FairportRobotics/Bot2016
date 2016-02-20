package org.usfirst.frc.team578.robot.subsystems;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;

import edu.wpi.first.wpilibj.command.Subsystem;

public class LoggingSubsystem extends Subsystem {

	private BufferedWriter output;
	private boolean intialized = false;

	public LoggingSubsystem() {

		try {

			output = new BufferedWriter(new FileWriter("/tmp/RobotLog.txt", true));
			intialized = true;
			this.log("-------Logging Subsystem Initialized-------");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void log(String message) {
		if (intialized) {

			try {
				Time now = new Time(System.currentTimeMillis());
				output.write(now.toString() + " : " + message);
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
