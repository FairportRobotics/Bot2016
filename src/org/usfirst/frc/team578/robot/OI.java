package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.IntakeCommand;
import org.usfirst.frc.team578.robot.commands.OutputCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	// // CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	// // TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
	Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);

	Joystick gamePad = new Joystick(RobotMap.GAMEPAD);
	Button buttonSix = new JoystickButton(gamePad, 6);
	Button buttonFive = new JoystickButton(gamePad, 5);

	public void initializeOI() {
		buttonSix.whileHeld(new IntakeCommand());
		buttonFive.whileHeld(new OutputCommand());
	}

	public double getLeft() {
		return leftJoystick.getY();
	}

	public double getRight() {
		return rightJoystick.getY();
	}

	public boolean getButtonSix() {

		return buttonSix.get();

	}

	public boolean getButtonFive() {
		return buttonFive.get();
	}
}
