package frc.robot.commands;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class DriveWithJoystick extends Command 
{
	public DriveWithJoystick() {requires(Robot.driveTrain);}
	
	protected void initialize() {}

	protected void execute() {Robot.driveTrain.takeJoystickInputs(Robot.oi.getJoy());}

	protected boolean isFinished() {return false;}

	protected void end() {Robot.driveTrain.stop();}

	protected void interrupted() {end();}
}
