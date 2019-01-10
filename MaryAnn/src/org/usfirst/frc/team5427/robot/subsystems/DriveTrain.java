//Sai Juttu
package org.usfirst.frc.team5427.robot.subsystems;

import org.usfirst.frc.team5427.robot.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DriveTrain extends Subsystem
{
	public DifferentialDrive drive;
	public SpeedControllerGroup drive_Left;
	public SpeedControllerGroup drive_Right;
	
	public DriveTrain(SpeedControllerGroup drive_Left, SpeedControllerGroup drive_Right) 
	{
		this.drive_Left = drive_Left;
		this.drive_Right = drive_Right;
		drive = new DifferentialDrive(drive_Left,drive_Right);
	}

	protected void initDefaultCommand(){setDefaultCommand(new DriveWithJoystick());}
	
	
	public void takeJoystickInputs(Joystick joy) 
	{
		double speed = Math.abs(joy.getY()) > 0.05 ? joy.getY() : 0f;
		drive.arcadeDrive(-joy.getY(), joy.getZ() * .75);
	}
	
	public void stop() {drive.stopMotor();}
}