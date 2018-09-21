package org.usfirst.frc.team5427.robot;


import org.usfirst.frc.team5427.robot.commands.ActivateIn;
import org.usfirst.frc.team5427.robot.commands.ActivateOut;
import org.usfirst.frc.team5427.robot.commands.ActivateOutSlow;
import org.usfirst.frc.team5427.robot.commands.DriveForward;
import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;
import org.usfirst.frc.team5427.robot.commands.TiltDown;
import org.usfirst.frc.team5427.robot.commands.TiltUp;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public Joystick joy1;
	public Button motorIntakeIn;
	public Button motorIntakeOut;
	public Button motorIntakeOutSlow;
	public Button elevatorUp;
	public Button elevatorDown;
	public Button tiltUp;
	public Button tiltDown;
	
	
	
	
	public OI() {
		joy1 = new Joystick(Config.JOYSTICK_PORT);
		motorIntakeIn = new JoystickButton(joy1, Config.BUTTON_MOTOR_INTAKE_IN);
		motorIntakeOut = new JoystickButton(joy1, Config.BUTTON_MOTOR_INTAKE_OUT);
		motorIntakeOutSlow = new JoystickButton(joy1, Config.BUTTON_MOTOR_INTAKE_OUT_SLOW);	
		elevatorUp = new JoystickButton(joy1, Config.BUTTON_ELEVATOR_UP);
		elevatorDown = new JoystickButton(joy1, Config.BUTTON_ELEVATOR_DOWN);
		tiltUp = new JoystickButton(joy1, Config.BUTTON_TILT_UP);
		tiltDown = new JoystickButton(joy1, Config.BUTTON_TILT_DOWN);
		motorIntakeIn.whenPressed(new ActivateIn());
		motorIntakeOut.whenPressed(new ActivateOut());
		motorIntakeOutSlow.whenPressed(new ActivateOutSlow());
		elevatorUp.whenPressed(Robot.eu);
		elevatorDown.whenPressed(Robot.ed);
		tiltUp.whenPressed(new TiltUp());
		tiltDown.whenPressed(new TiltDown());
		
	}
	
	public Joystick getJoy()
	{
		return joy1;
	}
}
