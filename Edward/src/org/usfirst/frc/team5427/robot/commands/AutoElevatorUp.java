package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class AutoElevatorUp extends Command {

	
	public AutoElevatorUp(double time) {
		setTimeout(time);
	}
	protected void initialize() 
	{
		
	}
	protected void execute() 
	{
		Robot.ElevatorRightSide.set(Config.ELEVATOR_MOTOR_SPEED_UP);
		Robot.ElevatorLeftSide.set(-Config.ELEVATOR_MOTOR_SPEED_UP);
	}
    protected void end() 
	{
    	Robot.ElevatorLeftSide.set(0);
		Robot.ElevatorRightSide.set(0);
	}
	@Override
	public boolean isFinished() 
	{
		return this.isTimedOut();
	}
	protected void interrupted() 
	{
		end();
	}

}
