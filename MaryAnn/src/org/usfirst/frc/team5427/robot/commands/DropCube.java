package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class DropCube extends Command{

	public DropCube(double time)
	{
		setTimeout(time);
	}
	
	protected void intialize() {}
	
	protected void execute()
	{
		Robot.intakeSubsystem.setSpeed(Config.INTAKE_MOTOR_SPEED_OUT);
	}
	
	@Override
	protected boolean isFinished() 
	{
		return this.isTimedOut();
	}
	
	protected void end()
	{
		Robot.intakeSubsystem.setSpeed(0);
	}
	
	protected void interrupted() {end();}
	
	

}
