package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDown extends Command {
	
	
	@Override
	protected void initialize() 
	{
		this.setInterruptible(true);
	}
	
	@Override
	protected void execute() 
	{
		Robot.ElevatorRightSide.set(Config.ELEVATOR_MOTOR_SPEED_DOWN);
		Robot.ElevatorLeftSide.set(-Config.ELEVATOR_MOTOR_SPEED_DOWN);
	}
	
	public boolean isFinished() 
	{
		Robot.ElevatorLimitDown.get();
		return (!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_DOWN) || !Robot.ElevatorLimitDown.get());
	}
	protected void end() 
	{
		Robot.ElevatorRightSide.set(0);
		Robot.ElevatorLeftSide.set(0);
	}

	@Override
	protected void interrupted() 
	{
		end();
	}
}
