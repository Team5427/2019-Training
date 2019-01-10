package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorUp extends Command{

	public ElevatorUp(double time)
	{
		setTimeout(time);
	}
	
	protected void intialize() {}
	
	protected void execute()
	{
		Robot.elevator_Left.set(-.3);
		Robot.elevator_Right.set(.3);
	}
	
	@Override
	public boolean isFinished() 
	{
		return this.isTimedOut();
	}
	
	protected void end()
	{
		Robot.elevator_Left.set(0);
		Robot.elevator_Right.set(0);
	}
	
	protected void interrupted() {end();}
	
	

}
