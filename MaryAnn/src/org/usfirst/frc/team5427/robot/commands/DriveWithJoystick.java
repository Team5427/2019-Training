package org.usfirst.frc.team5427.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5427.robot.Robot;

public class DriveWithJoystick extends Command 
{
	public DriveWithJoystick() {requires(Robot.driveTrain);}
	
	protected void initialize() {}

	protected void execute() {Robot.driveTrain.takeJoystickInputs(Robot.oi.getJoy());}

	protected boolean isFinished() {return false;}

	protected void end() {Robot.driveTrain.stop();}

	protected void interrupted() {end();}
}
