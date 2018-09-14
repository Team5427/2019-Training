/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5427.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static final int FRONT_RIGHT_MOTOR = 3;
	public static final int REAR_RIGHT_MOTOR = 6;
	public static final int FRONT_LEFT_MOTOR = 1;
	public static final int REAR_LEFT_MOTOR = 0;
	
	public static final int INTAKE_MOTOR_LEFT = 7;
	public static final int INTAKE_MOTOR_RIGHT = 8;
	
	public static final int JOYSTICK = 0;
	public static final int INTAKE_BUTTON_IN = 11;
	public static final int INTAKE_BUTTON_OUT = 12;
}
