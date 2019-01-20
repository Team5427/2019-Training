package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem
{
	public static final int ELEVATOR_MOTOR_RIGHT = 9;
	public static final int ELEVATOR_MOTOR_LEFT = 4;
	public static final int ELEVATOR_LIMIT_SWITCH_UP = 5;
	public static final int ELEVATOR_LIMIT_SWITCH_DOWN = 4;

	private PWMVictorSPX leftMotor;
	private PWMVictorSPX rightMotor;
	private DigitalInput limitUp;
	private DigitalInput limitDown;

	public Elevator()
	{
		leftMotor = new PWMVictorSPX(ELEVATOR_MOTOR_LEFT);
		rightMotor = new PWMVictorSPX(ELEVATOR_MOTOR_RIGHT);
		limitUp = new DigitalInput(ELEVATOR_LIMIT_SWITCH_UP);
		limitDown = new DigitalInput(ELEVATOR_LIMIT_SWITCH_DOWN);
	}

	public void setLeft(double speed)
	{
		leftMotor.set(speed);
	}

	public void setRight(double speed)
	{
		rightMotor.set(speed);
	}

	public boolean limitUpReached()
	{
		return !(limitUp.get());
	}

	public boolean limitDownReached()
	{
		return !(limitDown.get());
	}

	public void stop()
	{
		this.setLeft(0);
		this.setRight(0);
	}

	@Override
	public void initDefaultCommand()
	{
	}
}
