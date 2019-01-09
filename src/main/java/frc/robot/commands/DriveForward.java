package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveForward extends Command
{
	public DriveForward(double timeout)
	{
		if (timeout != 0)
		{
			setTimeout(timeout);
		}
		requires(Robot.drivetrain);
	}

	@Override
	protected void initialize()
	{
		
	}

	@Override
	protected void execute()
	{
		Robot.drivetrain.setLeft(RobotMap.MOTORSPEED_DRIVE);
		Robot.drivetrain.setRight(-RobotMap.MOTORSPEED_DRIVE);
	}

	@Override
	protected boolean isFinished()
	{
		return this.isTimedOut();
	}

	@Override
	protected void end()
	{
		Robot.drivetrain.stop();
	}

	@Override
	protected void interrupted()
	{
		this.end();
	}
}
