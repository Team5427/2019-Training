package frc.robot.subsystems;

import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem
{
	private static PWMVictorSPX leftMotor;
	private static PWMVictorSPX rightMotor;
	private static DigitalInput limitUp;
	private static DigitalInput limitDown;

	public Elevator()
	{
		leftMotor = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_LEFT);
		rightMotor = new PWMVictorSPX(RobotMap.ELEVATOR_MOTOR_RIGHT);
		limitUp = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH_UP);
		limitDown = new DigitalInput(RobotMap.ELEVATOR_LIMIT_SWITCH_DOWN);
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
