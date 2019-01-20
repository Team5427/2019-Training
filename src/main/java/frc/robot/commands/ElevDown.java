package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevDown extends Command
{
	private double timeout;
	public ElevDown(double timeout)
	{
		if (timeout != 0)
		{
			this.timeout = timeout;
			setTimeout(timeout);
		}
		requires(Robot.elevator);
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
		Robot.elevator.setLeft(-RobotMap.MOTORSPEED_ELEVATOR_DOWN);
		Robot.elevator.setRight(RobotMap.MOTORSPEED_ELEVATOR_DOWN);
	}

	@Override
	protected boolean isFinished()
	{
		boolean limitReached = Robot.elevator.limitDownReached();
		if (this.timeout != 0)
		{
			return this.isTimedOut() || limitReached;
		}
		return limitReached;
	}

	@Override
	protected void end()
	{
		Robot.elevator.stop();
	}

	@Override
	protected void interrupted()
	{
		this.end();
	}
}
