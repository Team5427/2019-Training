package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
	private static PWMVictorSPX left;
	private static PWMVictorSPX right;
	private static PWMVictorSPX tilt;
	
	public Intake()
	{
		left = new PWMVictorSPX(RobotMap.INTAKE_MOTOR_LEFT);
		right = new PWMVictorSPX(RobotMap.INTAKE_MOTOR_RIGHT);
		tilt = new PWMVictorSPX(RobotMap.TILT_INTAKE_MOTOR);
	}
	
	public void move(double speed)
	{
		if (speed < 0)
		{
			left.set(speed * RobotMap.LEFT_BIAS_BACKWARD + RobotMap.LEFT_OFFSET_BACKWARD);
			right.set(speed * RobotMap.RIGHT_BIAS_FORWARD + RobotMap.RIGHT_OFFSET_FORWARD);
		}
		else if (speed > 0)
		{
			left.set(speed * RobotMap.LEFT_BIAS_FORWARD + RobotMap.LEFT_OFFSET_FORWARD);
			right.set(speed * RobotMap.RIGHT_BIAS_BACKWARD + RobotMap.RIGHT_OFFSET_BACKWARD);
		}
		else
		{
			left.set(0);
			right.set(0);
		}
	}
	
	public void tilt(double speed)
	{
		tilt.set(speed);
	}
	
	public void stop()
	{
		move(0);
		tilt(0);
	}
	
	public void initDefaultCommand()
	{
		
	}
}
