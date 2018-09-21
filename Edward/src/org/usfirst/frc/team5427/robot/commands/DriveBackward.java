package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackward extends Command {

	public DriveBackward(double time) 
	{
		requires(Robot.drivetrain);
		setTimeout(time);
	}
	protected void initialize() 
	{
	 
	}
	protected void execute() 
	{
		Robot.drivetrain.drive_Left.set(-.2);
		Robot.drivetrain.drive_Right.set(.2);
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
