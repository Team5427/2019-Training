package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;
import edu.wpi.first.wpilibj.command.Command;


public class ActivateIn extends Command {
	
	public ActivateIn()
	{
		requires(Robot.intake);
	}
	protected void initialize() {
		this.setInterruptible(true);
	}

	protected void execute()
	{
		Robot.intake.setSpeed(Config.INTAKE_MOTOR_SPEED_IN);
	}

	protected boolean isFinished() 
	{

		return !Robot.m_oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_IN);
		
	}
	public void end()
	{
		Robot.intake.stop();
	}
	public void interrupted()
	{
		end();
	}

}
