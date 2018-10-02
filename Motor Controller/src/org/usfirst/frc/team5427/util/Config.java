package org.usfirst.frc.team5427.util;

/**
 * This file will store ALL of the variables, offsets, measurements, etc. that
 * our robot will use during the year. All variables are to be static, and
 * nothing in this file should ever have to be initiated.
 * 
 * @author Andrew Kennedy, Bo Corman
 */
public class Config {

	/**
	 * The name of our program as per the robot.
	 */
	public static final String PROGRAM_NAME = "Team5427RoboCode";

	/**
	 * Stores whether the robot code is in debug mode or not.
	 */
	public static final boolean DEBUG_MODE = true;

	/**
	 * Stores whether the robot code is sending messages to the log file.
	 */
	public static final boolean LOGGING = true;

	/******************** PWM PORTS *******************/
	/**
	 * The PWM value for the front right motor of the drive train.
	 */
	public static final int FRONT_RIGHT_MOTOR = 3;

	/**
	 * The PWM value for the rear right motor of the drive train.
	 */
	public static final int REAR_RIGHT_MOTOR = 6;

	/**
	 * The PWM value for the front left motor of the drive train.
	 */
	public static final int FRONT_LEFT_MOTOR = 1;

	/**
	 * The PWM value for the rear left motor of the drive train.
	 */
	public static final int REAR_LEFT_MOTOR = 0;

	/**
	 * The PWM value for the left motor of the intake.
	 */
	public static final int INTAKE_MOTOR_LEFT = 7;

	/**
	 * The PWM value for the right motor of the intake.
	 */
	public static final int INTAKE_MOTOR_RIGHT = 8;

	/**
	 * The PWM value for the right motor of the elevator.
	 */
	public static final int ELEVATOR_MOTOR_RIGHT = 9;
	/**
	 * The PWM value for the left motor of the elevator.
	 */
	public static final int ELEVATOR_MOTOR_LEFT = 4;

	/**
	 * The PWM value for the motor of the intake tilt.
	 */
	public static final int TILT_INTAKE_MOTOR = 5;
	/*************************************************/

	/******************** DIO PORTS *******************/
	public static final int ELEVATOR_LIMIT_SWITCH_UP = 5;

	/**
	 * The DIO port value for the limit switch located at the bottom of the
	 * elevator.
	 */
	public static final int ELEVATOR_LIMIT_SWITCH_DOWN = 4;
	/*************************************************/

	/******************** TIMEOUTS *******************/
	/**
	 * The timeout used in shooting the intake out during autonomous.
	 */
	public static final double AUTO_OUTTAKE_TIMEOUT = 1;
	
	/**
	 * The timeout used in picking up a cube during autonomous.
	 */
	public static final double AUTO_INTAKE_TIMEOUT = 3;

	/**
	 * The timeout used in tilting the intake up.
	 */
	public static final double TILT_TIMEOUT_UP = 2.4;

	/**
	 * The timeout used in tilting the intake down.
	 */
	public static final double TILT_TIMEOUT_DOWN = 1.7;

	/**
	 * The timeout used in moving the elevator to the switch position.
	 */
	public static final double ELEVATOR_TIMEOUT_SWITCH = 1;

	/**
	 * The timeout used in moving the elevator to the scale position.
	 */
	public static final double ELEVATOR_TIMEOUT_SCALE = 2.8;

	/**
	 * The timeout used in moving the elevator back to default from the scale.
	 */
	public static final double ELEVATOR_TIMEOUT_SCALE_DOWN = 2.8;
	
	/**
	 * The timeout used in moving the elevator back to default from the switch.
	 */
	public static final double ELEVATOR_TIMEOUT_SWITCH_DOWN = 50;
	/*************************************************/

	/******************** MOTOR SPEEDS *******************/
	/**
	 * The motor speed that correlates to pulling in a box.
	 */
	public static final double INTAKE_MOTOR_SPEED_IN = 0.3;

	/**
	 * The motor speed that correlates to shooting out a box.
	 */
	public static final double INTAKE_MOTOR_SPEED_OUT = -0.75;

	/**
	 * The motor speed that correlates to shooting a box out slowly.
	 */
	public static final double INTAKE_MOTOR_SPEED_SLOW_OUT = -1.0;

	/**
	 * The motor speed that correlates to moving the elevator up.
	 */
	public static final double ELEVATOR_MOTOR_SPEED_UP = 0.8;
	
	/**
	 * The motor speed that correlates to moving the elevator up auto.
	 */
	public static final double ELEVATOR_MOTOR_SPEED_UP_AUTO = 1;

	/**
	 * The motor speed that correlates to moving the elevator down.
	 */
	public static final double ELEVATOR_MOTOR_SPEED_DOWN = -.5;

	/**
	 * The motor speed that correlates to tilting the intake upward.
	 */
	public static final double INTAKE_TILTER_MOTOR_SPEED_UP = 1.0;

	/**
	 * The motor speed that correlates to tilting the intake downward.
	 */
	public static final double INTAKE_TILTER_MOTOR_SPEED_DOWN = -1.0;
	/*****************************************************/

	/******************** JOYSTICK BUTTONS *******************/
	/**
	 * The button that correlates to pulling in a box.
	 */
	public static final int BUTTON_MOTOR_INTAKE_IN = 7;

	/**
	 * The button that correlates to shooting out a box.
	 */
	public static final int BUTTON_MOTOR_INTAKE_OUT = 1;

	/**
	 * The button that correlates to shooting out a box slowly.
	 */
	public static final int BUTTON_MOTOR_INTAKE_OUT_SLOW = 0;

	/**
	 * The button that correlates to moving the elevator upward.
	 */
	public static final int BUTTON_ELEVATOR_UP = 5;

	/**
	 * The button that correlates to moving the elevator downward.
	 */
	public static final int BUTTON_ELEVATOR_DOWN = 3;

	/**
	 * The button that correlates to switching the tilt position of the intake.
	 */
	public static final int BUTTON_INTAKE_TOGGLE_TILTER = 8;

	/**
	 * The button that correlates to tilting the intake upward.
	 */
	public static final int BUTTON_INTAKE_TILTER_UP = 6;

	/**
	 * The button that correlates to tilting the intake downward.
	 */
	public static final int BUTTON_INTAKE_TILTER_DOWN = 4;

	/**
	 * The button that correlates to moving the elevator down manually without the
	 * limit switch affecting it.
	 */
	public static final int BUTTON_ELEVATOR_DOWN_MANUAL = 11;
	/*********************************************************/

	/******************** CONTROLLER PORTS *******************/
	/**
	 * The port associated with the main joystick.
	 */
	public static final int JOYSTICK_PORT = 0;

	/**
	 * The port associated with a second joystick.
	 */
	public static final int ALT_JOYSTICK_PORT = 0;


}