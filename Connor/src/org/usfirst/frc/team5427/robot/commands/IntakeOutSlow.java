package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeOutSlow extends Command
{
	
	
	public IntakeOutSlow(double time)
	{
		requires(Robot.intake);
		setTimeout(time);
	}
	
	protected void initialize()
	{	}
	
	protected void execute()
	{
		Robot.intake.leftFlywheel.set(0.3);
		Robot.intake.rightFlywheel.set(-0.3);
	}
	
	@Override
	protected boolean isFinished()
	{
		return this.isTimedOut();
	}

	protected void end()
	{
		Robot.intake.leftFlywheel.set(0);
		Robot.intake.rightFlywheel.set(0);
	}
	
	protected void interrupted()
	{
		end();
	}

}
