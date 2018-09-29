package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class DriveForward extends Command{
	
	public DriveForward(double time)
	{
		requires(Robot.driveTrain);
		setTimeout(time);
	}
	
	@Override
	protected void initialize(){}
	
	@Override
	protected void execute() {
		Robot.driveTrain.drive_Left.set(.3);
		Robot.driveTrain.drive_Right.set(-.3);
	}
	
	

	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.driveTrain.drive_Left.set(0);
		Robot.driveTrain.drive_Right.set(0);
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}
}
