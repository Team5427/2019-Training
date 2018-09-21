package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command 
{

	public DriveForward(double time) 
	{
		requires(Robot.drivetrain);
		setTimeout(time);
	}
	protected void initialize() 
	{
	 
	}
	protected void execute() 
	{
			Robot.drivetrain.drive_Left.set(.3);
			Robot.drivetrain.drive_Right.set(-.3);
	}
    protected void end() 
	{
			Robot.drivetrain.drive_Left.set(0);
			Robot.drivetrain.drive_Right.set(0);
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
