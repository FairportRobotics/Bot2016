package org.usfirst.frc.team578.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Drive subsytem
	public static final int RIGHT_MASTER = 15;
	public static final int RIGHT_SLAVE = 16;
	public static final int LEFT_MASTER = 13;
	public static final int LEFT_SLAVE = 14;

	public static final int WINCH_TALON = 78;

	public static final int INTAKE_TALON = 99;

	public static final int LEFT_JOYSTICK = 0;
	public static final int RIGHT_JOYSTICK = 1;
	public static final int GAMEPAD = 2;

	public static final int INTAKE_BUTTON = 3;

}