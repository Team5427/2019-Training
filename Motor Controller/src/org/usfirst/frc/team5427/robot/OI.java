/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.ElevatorDown;
import org.usfirst.frc.team5427.robot.commands.ElevatorUp;
import org.usfirst.frc.team5427.robot.commands.IntakeActivateIn;
import org.usfirst.frc.team5427.robot.commands.IntakeActivateOut;
import org.usfirst.frc.team5427.robot.commands.TiltDown;
import org.usfirst.frc.team5427.robot.commands.TiltUp;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class OI {


	public Joystick joy1;
	Button motorIntakeIn;
	Button motorIntakeOut;
	Button elevatorUp;
	Button elevatorDown;
	Button tiltUp, tiltDown;
	public OI() {
		joy1 = new Joystick(0);
		motorIntakeIn = new JoystickButton(joy1, Config.BUTTON_MOTOR_INTAKE_IN);
		motorIntakeOut = new JoystickButton(joy1, Config.BUTTON_MOTOR_INTAKE_OUT);
		elevatorUp = new JoystickButton(joy1, Config.BUTTON_ELEVATOR_UP);
		elevatorDown = new JoystickButton(joy1, Config.BUTTON_ELEVATOR_DOWN);
		tiltUp = new JoystickButton(joy1, Config.BUTTON_INTAKE_TILTER_UP);
		tiltDown = new JoystickButton(joy1, Config.BUTTON_INTAKE_TILTER_DOWN);
		motorIntakeIn.whenPressed(new IntakeActivateIn());
		motorIntakeOut.whenPressed(new IntakeActivateOut());
		elevatorUp.whenPressed(new ElevatorUp());
		elevatorDown.whenPressed(new ElevatorDown());
		tiltUp.whenPressed(new TiltUp());
		tiltDown.whenPressed(new TiltDown());
	}

	/**
	 * Accessor for the joystick we use.
	 * 
	 * @return the current joystick.
	 */
	public Joystick getJoy() {
		return joy1;
	}

}
