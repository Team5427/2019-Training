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
		if (speed < 0) {
			leftMotor.set(speed * LEFT_MOTOR_BIAS_BACKWARD + LEFT_MOTOR_OFFSET_BACKWARD);
			rightMotor.set(speed * RIGHT_MOTOR_BIAS_FORWARD + RIGHT_MOTOR_OFFSET_FORWARD);
		}
		else if (speed > 0) {
			leftMotor.set(speed * LEFT_MOTOR_BIAS_FORWARD + LEFT_MOTOR_OFFSET_FORWARD);
			rightMotor.set(speed * RIGHT_MOTOR_BIAS_BACKWARD + RIGHT_MOTOR_OFFSET_BACKWARD);
		}
		else {
			leftMotor.set(0);
			rightMotor.set(0);
		}
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

