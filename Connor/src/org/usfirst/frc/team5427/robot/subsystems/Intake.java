package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
	public SpeedController leftFlywheel;
	
	public SpeedController rightFlywheel;
	
	public Intake(SpeedController leftFlywheel, SpeedController rightFlywheel)
	{
		this.leftFlywheel = leftFlywheel;
		this.rightFlywheel = rightFlywheel;
	}
	
	public void setSpeed(double speed)
	{
		leftFlywheel.set(speed);
		rightFlywheel.set(speed);
	}

	@Override
	public void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void stop()
	{
		setSpeed(0);
	}

}
