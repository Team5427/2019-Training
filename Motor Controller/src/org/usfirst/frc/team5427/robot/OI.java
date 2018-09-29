/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.commands.IntakeActivateIn;
import org.usfirst.frc.team5427.robot.commands.IntakeActivateOut;
import org.usfirst.frc.team5427.robot.commands.TiltDown;
import org.usfirst.frc.team5427.robot.commands.TiltUp;

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
		motorIntakeIn = new JoystickButton(joy1, 7);
		motorIntakeOut = new JoystickButton(joy1, 1);
		elevatorUp = new JoystickButton(joy1, 5);
		elevatorDown = new JoystickButton(joy1, 3);
		tiltUp = new JoystickButton(joy1, 6);
		tiltDown = new JoystickButton(joy1, 4);
		motorIntakeIn.whenPressed(new IntakeActivateIn());
		motorIntakeOut.whenPressed(new IntakeActivateOut());
		elevatorUp.whenPressed(Robot.mou);
		elevatorDown.whenPressed(Robot.mod);
		tiltUp.whenPressed(new TiltUp());
		tiltUp.whenPressed(new TiltDown());
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
