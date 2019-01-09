package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeSlow extends Command
{
	private double timeout;
	public IntakeSlow(double timeout)
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
		this.setInterruptible(true);
	}

	@Override
	protected void execute()
	{
		Robot.intake.move(RobotMap.MOTORSPEED_INTAKE_SLOW);
	}

	@Override
	protected boolean isFinished()
	{
		if (this.timeout != 0)
		{
			return this.isTimedOut();
		}
		return !(OI.joystick.getRawButton(RobotMap.BUTTON_INTAKE_SLOW));
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
