package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class TiltUp extends Command
{
	private double timeout;
	public TiltUp(double timeout)
	{
		if (timeout != 0)
		{
			this.timeout = timeout;
			setTimeout(timeout);
		}
		requires(Robot.intake);
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		Robot.intake.tilt(RobotMap.MOTORSPEED_TILTER_UP);
	}

	@Override
	protected boolean isFinished()
	{
		if (this.timeout != 0)
		{
			return this.isTimedOut();
		}
		return false;
	}

	@Override
	protected void end()
	{
		Robot.intake.stop();
	}

	@Override
	protected void interrupted()
	{
		this.end();
	}
}
