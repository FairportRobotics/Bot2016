package org.usfirst.frc.team578.robot;

import org.usfirst.frc.team578.robot.commands.IntakeCommand;
import org.usfirst.frc.team578.robot.commands.OutputCommand;
import org.usfirst.frc.team578.robot.commands.TapeInCommand;
import org.usfirst.frc.team578.robot.commands.TapeOutCommand;
import org.usfirst.frc.team578.robot.commands.WinchRetractCommand;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
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
	Joystick gamepad = new Joystick(RobotMap.GAMEPAD);

	JoystickButton buttonSix = new JoystickButton(gamepad, 6);
	JoystickButton buttonFive = new JoystickButton(gamepad, 5);
	JoystickButton buttonFour = new JoystickButton(gamepad, 4);
	JoystickButton buttonThree = new JoystickButton(gamepad, 3);
	JoystickButton buttonTwo = new JoystickButton(gamepad, 2);
	JoystickButton buttonOne = new JoystickButton(gamepad, 1);
	JoystickButton buttonNine = new JoystickButton(gamepad, 9);
	JoystickButton buttonSeven = new JoystickButton(gamepad, 7);
	JoystickButton buttonEight = new JoystickButton(gamepad, 8);

	public double getArmJoystick() {
		return gamepad.getY(Hand.kLeft);
	}

	public double getLeft() {
		return leftJoystick.getY();
	}

	public double getRight() {
		return rightJoystick.getY();
	}

	public void initialize() {
		buttonFive.whileHeld(new OutputCommand());
		buttonSix.whileHeld(new IntakeCommand());
		buttonFour.whileHeld(new TapeOutCommand());
		buttonTwo.whileHeld(new TapeInCommand());
		buttonSeven.whileHeld(new WinchRetractCommand());
	}

	public boolean getHighSpeed() {
		return buttonNine.get();
	}
}
