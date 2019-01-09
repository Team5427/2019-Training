package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleOp extends Command
{
	public TeleOp()
	{
		requires(Robot.drivetrain);
	}
	
	@Override
	protected void execute()
	{
		Robot.drivetrain.joystickDrive();
	}

	@Override
	protected boolean isFinished()
	{
		return false;
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
