package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
	public static final int INTAKE_MOTOR_LEFT = 7;
	public static final int INTAKE_MOTOR_RIGHT = 8;
	public static final int TILT_INTAKE_MOTOR = 5;

	public static final double LEFT_BIAS_FORWARD = 1;
	public static final double LEFT_BIAS_BACKWARD = 1;
	public static final double RIGHT_BIAS_FORWARD = 1;
	public static final double RIGHT_BIAS_BACKWARD = 1;

	public static final double LEFT_OFFSET_FORWARD = 0;
	public static final double LEFT_OFFSET_BACKWARD = 0;
	public static final double RIGHT_OFFSET_FORWARD = 0;
	public static final double RIGHT_OFFSET_BACKWARD = 0;

	private static PWMVictorSPX left;
	private static PWMVictorSPX right;
	private static PWMVictorSPX tilt;

	public Intake()
	{
		left = new PWMVictorSPX(INTAKE_MOTOR_LEFT);
		right = new PWMVictorSPX(INTAKE_MOTOR_RIGHT);
		tilt = new PWMVictorSPX(TILT_INTAKE_MOTOR);
	}

	public void move(double speed)
	{
		if (speed < 0)
		{
			left.set(speed * LEFT_BIAS_BACKWARD + LEFT_OFFSET_BACKWARD);
			right.set(speed * RIGHT_BIAS_FORWARD + RIGHT_OFFSET_FORWARD);
		}
		else if (speed > 0)
		{
			left.set(speed * LEFT_BIAS_FORWARD + LEFT_OFFSET_FORWARD);
			right.set(speed * RIGHT_BIAS_BACKWARD + RIGHT_OFFSET_BACKWARD);
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

	@Override
	public void initDefaultCommand()
	{
	}
}
