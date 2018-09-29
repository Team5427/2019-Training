package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUpAuto extends Command
{
		
	public ElevatorUpAuto(double time)
	{
		requires(Robot.elevator);
		setTimeout(time);
	}
	
	protected void initialize() {};
	
	protected void execute()
	{
		Robot.elevator.elevator_left.set(Config.ELEVATOR_SPEEDDOWN);
		Robot.elevator.elevator_right.set(Config.ELEVATOR_SPEEDUP);
	}
	
	@Override
	public boolean isFinished() {
		// TODO Auto-generated method stub
		return this.isTimedOut();
	}
	
	@Override
	protected void end() {
		Robot.elevator.elevator_left.set(0);
		Robot.elevator.elevator_right.set(0);
	}
	
	@Override
	protected void interrupted()
	{
		end();
	}

}
