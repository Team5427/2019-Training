package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DriveBackward extends Command
{
	public DriveBackward(double time) {
		requires(Robot.driveTrain);
		setTimeout(time);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
	
	@Override
	protected void end()
	{
		Robot.driveTrain.drive.stopMotor();
	}
	
	@Override
	protected void initialize() {};
	
	

}
