package org.usfirst.frc.team5427.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator extends Subsystem 
{
	
	SpeedController elevator_left;
	SpeedController elevator_right;
	
	public Elevator(SpeedController elevator_left, SpeedController elevator_right)
	{
		this.elevator_left = elevator_left;
		this.elevator_right = elevator_right;
	}
	
	
	public void stop()
	{
		this.elevator_left.set(0);
		this.elevator_right.set(0);
	}
	
	@Override
	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub
	}

}
