package org.usfirst.frc.team5427.util;

public class Config 
{
	public static final String PROGRAM_NAME = "Team5427RoboCode";
	
	public static final boolean DEBUG_MODE = true;
	
	public static final boolean LOGGING = true;
	
	public static final int FRONT_RIGHT_MOTOR = 3;
	
	public static final int REAR_RIGHT_MOTOR = 6;
	
	public static final int FRONT_LEFT_MOTOR = 1;
	
	public static final int REAR_LEFT_MOTOR = 0;
	
	public static final int INTAKE_MOTOR_LEFT = 7; 
	
	public static final int INTAKE_MOTOR_RIGHT = 8;
	
	public static final int ELEVATOR_MOTOR_LEFT = 4; //ports needed
	
	public static final int ELEVATOR_MOTOR_RIGHT = 9; //ports needed
	
	//joystick ports
	public static final int JOYSTICK_PORT = 0;
	
	public static final int ALT_JOYSTICK_PORT = 0;
	
	public static final int ONE_JOYSTICK = 0;
	
	public static final int TWO_JOYSTICKS = 1;
	
	public static final int JOYSTICK_MODE = ONE_JOYSTICK;
	
	public static final int ELEVATOR_LIMIT_UP = 5;//port needed
	
	public static final int ELEVATOR_LIMIT_DOWN = 4;//port needed
	
	//timeouts
	public static final double AUTO_OUTTAKE_TIMEOUT = 1;
	
	public static final double AUTO_INTAKE_TIMEOUT = 3;
	
	public static final double ELEVATOR_SWITCH_TIMEOUT = 0;//ports needed 
	
	public static final double ELEVATOR_SCALE_TIMEOUT = 0;//ports needed
	
	public static final double ELEVATOR_SCALE_DOWN_TIMEOUT = 0;//ports needed
	
	public static final double ELEVATOR_SWITCH_DOWN_TIMEOUT = 0;//ports needed
	
	
	
	//motor speeds
	public static final double INTAKE_MOTOR_SPEED_IN = 0.3;

	public static final double INTAKE_MOTOR_SPEED_OUT = -0.75;

	public static final double INTAKE_MOTOR_SPEED_SLOW_OUT = -1.0;
	
	public static final double ELEVATOR_SPEEDUP = 0.8;//ports needed
	
	public static final double ELEVATOR_SPEEDUP_AUTO = 0;//ports needed
	
	public static final double ELEVATOR_SPEEDDOWN = -0.5;//ports needed
	
	//joystick buttons
	
	public static final int BUTTON_MOTOR_INTAKE_IN = 7;

	public static final int BUTTON_MOTOR_INTAKE_OUT = 1;

	public static final int BUTTON_MOTOR_INTAKE_OUT_SLOW = 0;
	
	public static final int BUTTON_ELEVATOR_UP = 5;//ports needed
	
	public static final int BUTTON_ELEVATOR_DOWN = 3;//ports needed

}
