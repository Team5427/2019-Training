package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command 
{

	public Drive()
	{
		requires(Robot.driveTrain);
		//setTimeout(.9);
	}
	
	@Override 
	protected void initialize()
	{
		
	}
	
	@Override
	protected void execute()
	{
		Robot.driveTrain.takeJoystickInputs(Robot.m_oi.getJoy());
	}
	
	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	protected void end()
	{
		Robot.driveTrain.stop();
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}

}
