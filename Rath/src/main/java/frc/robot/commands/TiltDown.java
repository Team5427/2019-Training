package frc.robot.commands;

import frc.robot.Robot;
import frc.util.Config;
import edu.wpi.first.wpilibj.command.Command;

public class TiltDown extends Command
{
	public TiltDown() {}
	
	protected void initialize() {this.setInterruptible(true);}

	protected void execute() {Robot.tilt.set(Config.INTAKE_TILTER_MOTOR_SPEED_DOWN);}
	
	protected boolean isFinished(){return (!Robot.oi.getJoy().getRawButton(Config.BUTTON_INTAKE_TILTER_DOWN));}
	
	protected void end() {Robot.tilt.set(0);}
	
	protected void interrupted() {end();}
}