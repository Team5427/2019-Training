package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command {
	
	
	@Override
	protected void initialize() 
	{
		this.setInterruptible(true);
	}
	@Override 
	protected void execute() 
	{
		Robot.ElevatorRightSide.set(Config.ELEVATOR_MOTOR_SPEED_UP);
		Robot.ElevatorLeftSide.set(-Config.ELEVATOR_MOTOR_SPEED_UP);
	}
	public boolean isFinished() 
	{
		Robot.ElevatorLimitUp.get();
		return (!Robot.m_oi.getJoy().getRawButton(Config.BUTTON_ELEVATOR_UP) || !Robot.ElevatorLimitUp.get());
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
