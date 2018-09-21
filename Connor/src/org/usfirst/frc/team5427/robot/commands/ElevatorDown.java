package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDown extends Command
{
	
	public ElevatorDown()
	{
		
	}
	
	protected void initialize()
	{
		this.setInterruptible(true);
		Robot.motorPWM_ElevatorRight.set(Config.ELEVATOR_SPEEDDOWN);
		Robot.motorPWM_ElevatorLeft.set(-Config.ELEVATOR_SPEEDDOWN);
	}
	
	protected void execute()
	{
		
	}

	@Override
	public boolean isFinished() 
	{
		// TODO Auto-generated method stub
		Robot.elevatorLimitDown.get();
		return(!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_DOWN) || !Robot.elevatorLimitDown.get());
	}
	
	protected void end()
	{
		Robot.motorPWM_ElevatorLeft.set(0);
		Robot.motorPWM_ElevatorRight.set(0);
	}
	
	protected void interrupted()
	{
		end();
	}

}
