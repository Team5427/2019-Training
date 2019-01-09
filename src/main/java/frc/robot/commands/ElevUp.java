package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ElevUp extends Command
{
	private double timeout;
	public ElevUp(double timeout)
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
		this.setInterruptible(true);
	}

	@Override
	protected void execute()
	{
		Robot.elevator.setLeft(-RobotMap.MOTORSPEED_ELEVATOR_UP);
		Robot.elevator.setRight(RobotMap.MOTORSPEED_ELEVATOR_UP);
	}

	@Override
	protected boolean isFinished()
	{
		boolean limitReached = Robot.elevator.limitUpReached();
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
