package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TrainingCommand extends CommandGroup
{
	public TrainingCommand()
	{
		addParallel(new DriveForward(3));
		addSequential(new ElevUp(1));
		addSequential(new IntakeOut(1));
	}

	@Override
	protected void initialize()
	{
	}

	@Override
	protected void execute()
	{
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void end()
	{
	}

	@Override
	protected void interrupted()
	{
	}
}
