package frc.robot.commands;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOut extends Command
{
	private double timeout;
	public IntakeOut(double timeout)
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
		Robot.intake.move(RobotMap.MOTORSPEED_INTAKE_OUT);
	}

	@Override
	protected boolean isFinished()
	{
		if (this.timeout != 0)
		{
			return this.isTimedOut();
		}
		return !(OI.joystick.getRawButton(OI.BUTTON_INTAKE_OUT));
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
