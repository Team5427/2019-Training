package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.*;

import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeIn extends Command
{
	
	public IntakeIn()
	{
		requires(Robot.intake);
	}
	
	@Override
	protected void initialize()
	{
		this.setInterruptible(true);
	}
	
	@Override
	protected void execute()
	{
		Robot.intake.setSpeed(Config.INTAKE_MOTOR_SPEED_IN);
	}
	
	@Override
	protected void end()
	{
		Robot.intake.stop();
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}
	
	//returns true if the button is released
	@Override
	protected boolean isFinished() 
	{
		return !Robot.m_oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_IN);
	}

}
