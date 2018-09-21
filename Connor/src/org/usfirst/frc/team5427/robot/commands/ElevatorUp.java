package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command
{
	
	public ElevatorUp()
	{
		
	}
	
	protected void initialize()
	{
		this.setInterruptible(true);
	}
	
	protected void execute()
	{
		Robot.motorPWM_ElevatorRight.set(Config.ELEVATOR_SPEEDUP);
		Robot.motorPWM_ElevatorLeft.set(-Config.ELEVATOR_SPEEDUP);
	}

	@Override
	public boolean isFinished() 
	{
		// TODO Auto-generated method stub
		Robot.elevatorLimitUp.get();
		return(!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_UP) || !Robot.elevatorLimitUp.get());
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
