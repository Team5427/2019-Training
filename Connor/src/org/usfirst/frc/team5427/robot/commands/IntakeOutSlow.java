package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOutSlow extends Command
{
	
	double speed;
	
	public IntakeOutSlow(double speed)
	{
		requires(Robot.intake);
		this.speed = speed;
	}
	
	protected void initialize()
	{
		this.setInterruptible(true);
	}
	
	protected void execute()
	{
		Robot.intake.setSpeed(speed);
	}
	
	@Override
	protected boolean isFinished()
	{
		if(Robot.m_oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_OUT_SLOW))
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
