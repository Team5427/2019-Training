package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command 
{
	
	public IntakeOut()
	{
		requires(Robot.intake);
	}
	
	protected void initialize()
	{
		this.setInterruptible(true);
	}
	
	protected void execute()
	{
		Robot.intake.setSpeed(Config.INTAKE_MOTOR_SPEED_OUT);
	}
	
	


	protected void initDefaultCommand() 
	{
		// TODO Auto-generated method stub

	}

	@Override
	protected boolean isFinished() 
	{
		if(!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_OUT))
			return true;
		return false;
	}
	
	protected void end()
	{
		Robot.intake.setSpeed(0);
	}
	
	protected void interrupted()
	{
		end();
	}

}
