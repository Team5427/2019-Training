package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Tilt extends Subsystem
{
	SpeedController tilt_speedcontroller;
	
	public Tilt(SpeedController tilt_speedcontroller)
	{
		this.tilt_speedcontroller = tilt_speedcontroller;
	}
	
	@Override
	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void stop()
	{
		this.tilt_speedcontroller.set(0);
	}
	

}
