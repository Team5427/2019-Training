package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class AutoIntakeOut extends Command {

	public AutoIntakeOut(double time) 
	{
		requires(Robot.intake);
		setTimeout(time);
	}
	protected void initialize() 
	{
		
	}
	protected void execute() 
	{
		Robot.intake.setSpeed(Config.INTAKE_MOTOR_SPEED_OUT);
	}
    protected void end() 
	{
    	Robot.intake.setSpeed(Config.INTAKE_MOTOR_SPEED_OUT);
	}
	@Override
	public boolean isFinished() 
	{
		return this.isTimedOut();
	}
	protected void interrupted() 
	{
		end();
	}

}
