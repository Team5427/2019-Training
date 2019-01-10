package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;
import edu.wpi.first.wpilibj.command.Command;

public class TiltUp extends Command
{
	public TiltUp() {}
	
	protected void initialize() {this.setInterruptible(true);}

	protected void execute() {Robot.tilt.set(Config.INTAKE_TILTER_MOTOR_SPEED_UP);}
	
	protected boolean isFinished(){return (!Robot.oi.getJoy().getRawButton(Config.BUTTON_INTAKE_TILTER_UP));}
	
	protected void end() {Robot.tilt.set(0);}
	
	protected void interrupted() {end();}
}

