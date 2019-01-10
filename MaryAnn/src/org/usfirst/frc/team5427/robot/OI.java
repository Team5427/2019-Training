package org.usfirst.frc.team5427.robot;
import org.usfirst.frc.team5427.robot.commands.IntakeActivateIn;
import org.usfirst.frc.team5427.robot.commands.IntakeActivateOut;
import org.usfirst.frc.team5427.robot.commands.TiltDown;
import org.usfirst.frc.team5427.robot.commands.TiltUp;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
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
	
	public Joystick joy;
	public Button motorIntakeIn;
	public Button motorIntakeOut;
	public Button elevatorUp;
	public Button elevatorDown;
	public Button tiltUp;
	public Button tiltDown;
	
	public OI()
	{
		joy = new Joystick(Config.JOYSTICK_PORT);
		motorIntakeIn 	= new JoystickButton(joy, Config.BUTTON_MOTOR_INTAKE_IN);
		motorIntakeOut 	= new JoystickButton(joy, Config.BUTTON_MOTOR_INTAKE_OUT);
		elevatorUp = new JoystickButton(joy,Config.BUTTON_ELEVATOR_UP);
		elevatorDown = new JoystickButton(joy,Config.BUTTON_ELEVATOR_DOWN);
		tiltUp = new JoystickButton(joy,Config.BUTTON_INTAKE_TILTER_UP);
		tiltDown = new JoystickButton(joy,Config.BUTTON_INTAKE_TILTER_DOWN);
		
		motorIntakeIn.whenPressed(new IntakeActivateIn());
		motorIntakeOut.whenPressed(new IntakeActivateOut());
		elevatorUp.whenPressed(Robot.meu);
		elevatorDown.whenPressed(Robot.med);
		tiltUp.whenPressed(new TiltUp());
		tiltDown.whenPressed(new TiltDown());
		
		
		
	}
	public Joystick getJoy() {
		// TODO Auto-generated method stub
		return joy;
	}

	
}
