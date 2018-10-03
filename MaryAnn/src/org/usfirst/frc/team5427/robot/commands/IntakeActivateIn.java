package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeActivateIn extends Command{
	
	public IntakeActivateIn()
	{
		requires(Robot.intakeSubsystem);
	}
	
	protected void Initialize()
	{
		this.setInterruptible(true);
	}
	
	protected void execute()
	{
		Robot.intakeSubsystem.setSpeed(Config.INTAKE_MOTOR_SPEED_IN);
	}
	
	protected boolean isFinished()
	{
		return (!Robot.oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_IN));
		
	}
	protected void end()
	{
		Robot.intakeSubsystem.setSpeed(0);
	}
	protected void interupted()
	{
		end();
	}
	
}
