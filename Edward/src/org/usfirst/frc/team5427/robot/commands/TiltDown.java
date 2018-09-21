package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class TiltDown extends Command {
	
	
	@Override
	protected void initialize() 
	{
		this.setInterruptible(true);
	}
	
	@Override
	protected void execute() 
	{
		Robot.motor_pwm_Tilt.set(Config.INTAKE_TILT_DOWN_SPEED);
	}
	
	public boolean isFinished() 
	{
		Robot.ElevatorLimitUp.get();
		return (!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_TILT_DOWN));
	}
	protected void end() 
	{
		Robot.motor_pwm_Tilt.set(0);
	}

	@Override
	protected void interrupted() 
	{
		end();
	}
}
