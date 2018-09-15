package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.commands.Drive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem 
{
	
	public DifferentialDrive drive;
	
	public SpeedControllerGroup drive_Left;
	
	public SpeedControllerGroup drive_Right;
	
	public DriveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right, DifferentialDrive drive)
	{
		this.drive = drive;
		this.drive_Left = drive_Left;
		this.drive_Right = drive_Right;
	}
	
	

	@Override
	protected void initDefaultCommand() 
	{
		setDefaultCommand(new Drive());
		// TODO Auto-generated method stub

	}
	
	
	
	public void stop()
	{
		drive.stopMotor();
	}



	public void takeJoystickInputs(Joystick joy) 
	{
		drive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
	}

}
