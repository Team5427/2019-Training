package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;
import org.usfirst.frc.team5427.util.Config;

import edu.wpi.first.wpilibj.command.Command;

public class TiltDown extends Command 
{
	
	public TiltDown()
	{
		requires(Robot.tilt);
	}
	
	public void execute()
	{
		Robot.motorPWM_Tilt.set(Config.TILE_MOTOR_SPEED_DOWN);
	}

	@Override
	protected boolean isFinished() 
	{
		// TODO Auto-generated method stub
		return !Robot.m_oi.getJoy().getRawButton(Config.BUTTON_TILT_DOWN);
	}
	
	public void end()
	{
		//Robot.motorPWM_Tilt.set(0);
		Robot.tilt.stop();//might be deleted
	}
	
	public void interrupted()
	{
		end();
	}

}
