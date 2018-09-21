package org.usfirst.frc.team5427.util;



public class Config {

    //                        EXRTA
	
	public static final String PROGRAM_NAME = "Team5427RoboCode";
	
	public static final boolean DEBUG_MODE = true;
	
	public static final boolean LOGGING = true;
	
	
	//                        PWM MOTOR VALUES
	
	public static final int FRONT_RIGHT_MOTOR = 3;
	
	public static final int REAR_RIGHT_MOTOR = 6;
	
	public static final int FRONT_LEFT_MOTOR = 1;
	
	public static final int REAR_LEFT_MOTOR = 0;
	
	public static final int INTAKE_MOTOR_LEFT = 7;
	
	public static final int INTAKE_MOTOR_RIGHT = 8;
	
	public static final int ELEVATOR_MOTOR_RIGHT = 9;
	
	public static final int ELEVATOR_MOTOR_LEFT = 4;
	
	public static final int TILT_INTAKE_MOTOR = 5;
	
	public static final int CLIMBER_ARM_MOTOR = 2;
	
	public static final int CLIMBER_MOTOR = 10;
	
	public static final double INTAKE_MOTOR_SPEED_IN = 0.3;
	
	public static final double INTAKE_MOTOR_SPEED_OUT = -0.75;
	
	public static final double INTAKE_MOTOR_SPEED_SLOW_OUT = -1.0;

	public static final double ELEVATOR_MOTOR_SPEED_UP = 0.8;
	
	public static final double ELEVATOR_MOTOR_SPEED_DOWN = -.5;
	
	public static final double INTAKE_TILT_UP_SPEED = 1;
	
	public static final double INTAKE_TILT_DOWN_SPEED = -1;

	//                      BUTTON VALUES
	
	public static final int BUTTON_TILT_UP = 6;
	
	public static final int BUTTON_TILT_DOWN = 4;
	
	public static final int BUTTON_MOTOR_INTAKE_IN = 7;
	
	public static final int BUTTON_MOTOR_INTAKE_OUT = 1;
	
	public static final int BUTTON_MOTOR_INTAKE_OUT_SLOW = 12;
	
	public static final int BUTTON_ELEVATOR_UP = 5;
	
	public static final int BUTTON_ELEVATOR_DOWN = 3;
	
	public static final int BUTTON_ELEVATOR_DOWN_MANUAL = 11;
	
	//                      ELEVATOR LIMIT VALUES
	
	public static final int ELEVATOR_LIMIT_SWITCH_UP = 5;

	public static final int ELEVATOR_LIMIT_SWITCH_DOWN = 4;
	
	//                       CONTROLLER PORTS
	
	public static final int JOYSTICK_PORT = 0;
	
	//                       INCREMENT
	
	public static final double DRIVE_SPEED_INCREMENT_VALUE = .01;
}
	