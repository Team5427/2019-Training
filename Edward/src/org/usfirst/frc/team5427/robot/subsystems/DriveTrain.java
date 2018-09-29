package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class DriveTrain extends Subsystem {

	public DifferentialDrive drive;
	public SpeedControllerGroup drive_Left;
	public SpeedControllerGroup drive_Right;
	
	public DriveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right, DifferentialDrive drive) {

		this.drive = drive;
		this.drive_Left = drive_Left;
		this.drive_Right = drive_Right;
	}
	@Override
	protected void initDefaultCommand() 
	{
		setDefaultCommand(new DriveWithJoystick());
	}
	public void takeJoystickInputs(Joystick joy) 
	{
		drive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
	}
	public void stop() {
		drive.stopMotor();
	}

}
