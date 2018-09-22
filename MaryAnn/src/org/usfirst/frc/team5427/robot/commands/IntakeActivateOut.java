package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;
//import org.usfirst.frc.team5427.util.SameLine;

import edu.wpi.first.wpilibj.command.Command;
public class IntakeActivateOut extends Command{

	public IntakeActivateOut()
	{
		requires(Robot.intakeSubsystem);
	}
	
	protected void Initialize()
	{
		this.setInterruptible(true);
	}
	
	protected void execute()
	{
		Robot.intakeSubsystem.setSpeed(Config.INTAKE_MOTOR_SPEED_OUT);
	}
	
	protected boolean isFinished()
	{
		if(!Robot.oi.getJoy().getRawButton(Config.BUTTON_MOTOR_INTAKE_OUT))
			return false;
		else
			return true;
	}
	protected void end()
	{
		Robot.intakeSubsystem.setSpeed(0);
	}
	protected void intterupted()
	{
		end();
	}

}