package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

	private SpeedController leftMotor;
	private SpeedController rightMotor;
	public static final double LEFT_MOTOR_BIAS_FORWARD = 1;
	public static final double LEFT_MOTOR_BIAS_BACKWARD = 1;
	public static final double RIGHT_MOTOR_BIAS_FORWARD = 1;
	public static final double RIGHT_MOTOR_BIAS_BACKWARD = 1;
	public static final double LEFT_MOTOR_OFFSET_FORWARD = 0;
	public static final double LEFT_MOTOR_OFFSET_BACKWARD = 0;
	public static final double RIGHT_MOTOR_OFFSET_FORWARD = 0;
	public static final double RIGHT_MOTOR_OFFSET_BACKWARD = 0;

	public Elevator(SpeedController leftMotor, SpeedController rightMotor) {
		this.leftMotor = leftMotor;
		this.rightMotor = rightMotor;
	}

	public void setSpeed(double speed) {
		leftMotor.set(-1*speed);
		rightMotor.set(speed);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

