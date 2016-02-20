package org.usfirst.frc.team578.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive subsytem
	public static final int RIGHT_MASTER = 3;
	public static final int RIGHT_SLAVE = 2;
	public static final int LEFT_MASTER = 16;
	public static final int LEFT_SLAVE = 15;

	public static final int WINCH_TALON_FRONT = 14;
	public static final int WINCH_TALON_BACK = 4;
	public static final int WINCH_BRAKE_RELAY = 1;

	// Intake Subsystem
	public static final int INTAKE_TALON = 1;

	public static final int BRAKE_SENSOR = 1;

	// Arm Subsystem
	public static final int ARM_TALON = 13;

	// Driver Station IDs
	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int GAMEPAD = 2;
	public static final int INTAKE_BUTTON = 3;

}